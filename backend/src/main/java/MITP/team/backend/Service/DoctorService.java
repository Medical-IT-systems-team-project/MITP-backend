package MITP.team.backend.Service;

import MITP.team.backend.Exceptions.DataNotFoundException;
import MITP.team.backend.Model.Dto.ImportedPatientDto;
import MITP.team.backend.Model.Dto.MedicalCaseResponseDto;
import MITP.team.backend.Model.Enum.MedicalCaseStatus;
import MITP.team.backend.Model.Mapper.MedicalCaseMapper;
import MITP.team.backend.Model.MedicalCase;
import MITP.team.backend.Model.MedicalDoctor;
import MITP.team.backend.Model.Patient;
import MITP.team.backend.Repository.MedicalCaseRepository;
import MITP.team.backend.Repository.MedicalDoctorRepository;
import MITP.team.backend.Repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class DoctorService implements IDoctorService {

    private final MedicalCaseRepository medicalCaseRepository;
    private final MedicalCaseMapper medicalCaseMapper;
    private final MedicalDoctorRepository doctorRepository;
    private final PatientRepository patientRepository;


    @Override
    public Set<MedicalCaseResponseDto> getMedicalCases(Authentication auth) {
        String username = (String) auth.getPrincipal();
        MedicalDoctor medicalDoctor =
                doctorRepository
                        .findByLogin(username)
                        .orElseThrow(() -> new SecurityException("Unauthorized access"));
        Set<MedicalCase> attendingDoctorCases = new HashSet<>(medicalCaseRepository.getAllMedicalCaseByAttendingDoctorId(medicalDoctor.getId()));
        Set<MedicalCase> allowedDoctorCases = new HashSet<>(medicalCaseRepository.getAllMedicalCaseByAllowedDoctorsId(medicalDoctor.getId()));
        attendingDoctorCases.addAll(allowedDoctorCases);
        return attendingDoctorCases.stream()
                .map(medicalCaseMapper::mapToMedicalDataResponseDto)
                .collect(Collectors.toSet());
    }

    @Override
    public void importPatient(ImportedPatientDto importedPatientDto) {
        Patient patient = patientRepository.findByAccessId(importedPatientDto.accessId())
                .orElseThrow(() -> new DataNotFoundException("Patient not found"));

        MedicalDoctor doctor = doctorRepository.findById(importedPatientDto.doctorId())
                .orElseThrow(() -> new DataNotFoundException("Doctor not found"));

        List<MedicalCase> medicalCases = medicalCaseRepository.getAllMedicalCaseByPatientId(patient.getId());

        medicalCases = medicalCases.stream().filter(medicalCase -> medicalCase.getStatus().equals(MedicalCaseStatus.ONGOING)).toList();

        for (MedicalCase medicalCase : medicalCases) {
            if(medicalCase.getAllowedDoctors().stream().noneMatch(d -> d.getId().equals(doctor.getId()))){
                medicalCase.getAllowedDoctors().add(doctor);
                medicalCaseRepository.save(medicalCase);
            }
        }
    }
}
