package MITP.team.backend.domain_KW.Service;

import MITP.team.backend.domain_KW.Dto.MedicalDataDto;
import MITP.team.backend.domain_KW.Model.DrugTeratment;
import MITP.team.backend.domain_KW.Model.Medication;
import MITP.team.backend.domain_KW.Model.Treatment;
import MITP.team.backend.domain_KW.Repository.DrugTreatmentRepository;
import MITP.team.backend.domain_KW.Repository.MedicationRepository;
import MITP.team.backend.domain_KW.Repository.TreatmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MedicalDataService implements IMedicalDataService {


    private final TreatmentRepository treatmentRepository;
    private final DrugTreatmentRepository drugTreatmentRepository;
    private final MedicationRepository medicationRepository;

    @Override
    public MedicalDataDto getMedicalDataById(Long id) {
        List<Treatment> treatments = treatmentRepository.findAllById(List.of(id));
        List<Medication> medications = medicationRepository.findAllById(List.of(id));
        List<DrugTeratment> drugTeratments = drugTreatmentRepository.findAllById(List.of(id));

        MedicalDataDto medicalDataDto = new MedicalDataDto();
        medicalDataDto.setPatientId(id);
        medicalDataDto.setTreatments(treatments);
        medicalDataDto.setMedications(medications);
        medicalDataDto.setDrugTeratments(drugTeratments);

        return medicalDataDto;
    }
}
