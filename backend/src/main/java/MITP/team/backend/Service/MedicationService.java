package MITP.team.backend.Service;


import MITP.team.backend.Exceptions.DataNotFoundException;
import MITP.team.backend.Model.Dto.MedicationsDto;
import MITP.team.backend.Model.Dto.MedicineRequestDto;
import MITP.team.backend.Model.Dto.MedicineResponseDto;
import MITP.team.backend.Model.Mapper.MedicationsMapper;
import MITP.team.backend.Model.MedicalDoctor;
import MITP.team.backend.Model.Medicine;
import MITP.team.backend.Model.Patient;
import MITP.team.backend.Repository.MedicalDoctorRepository;
import MITP.team.backend.Repository.MedicationRepository;
import MITP.team.backend.Repository.MedicineRepository;
import MITP.team.backend.Repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@AllArgsConstructor
public class MedicationService implements IMedicationService {

    public final MedicationRepository medicationRepository;
    public final MedicationsMapper medicationsMapper;
    private final MedicineRepository medicineRepository;
    private final PatientRepository patientRepository;
    private final MedicalDoctorRepository medicalDoctorRepository;

    @Override
    public void createNewMedications(MedicationsDto medicationsDto) {
        medicationRepository.save(medicationsMapper.mapToMedication(medicationsDto));

    }

    @Override
    public MedicineResponseDto addMedicine(MedicineRequestDto medicineRequestDto) {

        //identyfikacja czy istnieje pacjent o podanym patientLastName i patientFirstName
        Patient patient = patientRepository.findByFirstNameAndLastName(medicineRequestDto.patientFirstName(), medicineRequestDto.patientLastName())
                .orElseThrow(() -> new DataNotFoundException("Patient not found in system."));

        //identyfikacja czy istnieje lekarz o podanym loginie
        MedicalDoctor medicalDoctor = medicalDoctorRepository.findByLogin(medicineRequestDto.doctorLastName())
                .orElseThrow(() -> new DataNotFoundException("Doctor not found in system."));

        //zapis w bazie danych leku
        Medicine medicine = new Medicine();
        medicine.setName(medicineRequestDto.medName());
        medicine.setPatient(patient);
        medicine.setDoctor(medicalDoctor);
        medicine.setDosageDate(LocalDateTime.now());

        Medicine save = medicineRepository.save(medicine);

        //zwrócenie informacji o zapisanym leku
        return MedicineResponseDto.builder()
                .medName(save.getName())
                .patientLastName(save.getPatient().getLastName())
                .doctorLastName(save.getDoctor().getUsername())
                .dosageDate(save.getDosageDate().toString())
                .build();
    }
}
