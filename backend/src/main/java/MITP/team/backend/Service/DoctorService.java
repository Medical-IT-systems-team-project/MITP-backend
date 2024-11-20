package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.PatientRequestDto;
import MITP.team.backend.Repository.MedicalDoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorService implements IDoctorService {
    private MedicalDoctorRepository doctorRepository;

    @Override
    public void addPatient(PatientRequestDto patientRequestDto) {

    }
}
