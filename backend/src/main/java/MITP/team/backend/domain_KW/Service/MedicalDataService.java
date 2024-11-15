package MITP.team.backend.domain_KW.Service;

import MITP.team.backend.domain_KW.Dto.MedicalDataDto;
import MITP.team.backend.domain_KW.Dto.TreatmentDto;
import MITP.team.backend.domain_KW.Exceptions.UserNotFoundException;
import MITP.team.backend.domain_KW.Model.Patient;
import MITP.team.backend.domain_KW.Repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MedicalDataService implements IMedicalDataService {

    private final PatientRepository patientRepository;

    @Override
    public MedicalDataDto getMedicalDataByAccessId(String uuid) {
        Patient patient =
                patientRepository
                        .findByAccessId(uuid)
                        .orElseThrow(
                                () ->
                                        new UserNotFoundException(
                                                "Patient with access ID " + uuid + " does not exist"));
    System.out.println(patient.getId());
    System.out.println(patient.getTreatments());
        return new MedicalDataDto(
                patient.getTreatments(), patient.getMedications(), patient.getDrugTreatment());
    }

    @Override
    public List<TreatmentDto> getTreatmentByAccessId(String uuid) {
        Patient patient =
                patientRepository
                        .findByAccessId(uuid)
                        .orElseThrow(
                                () ->
                                        new UserNotFoundException(
                                                "Patient with access ID" + uuid + "does not exsit"
                                        )
                        );
        return Optional.ofNullable(patient.getTreatments())
                .orElse(Collections.emptyList())
                .stream()
                .map(treatment -> TreatmentDto.builder()
                        .treatment(treatment.getTreatment())
                        .description(treatment.getDescription())
                        .date(treatment.getDate())
                        .build()
                )
                .toList();
    }
}
