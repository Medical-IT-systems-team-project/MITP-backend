package MITP.team.backend.Service;

import MITP.team.backend.Exceptions.DataNotFoundException;
import MITP.team.backend.Model.Dto.*;
import MITP.team.backend.Model.Enum.MedicalStatus;
import MITP.team.backend.Model.Mapper.MedicationMapper;
import MITP.team.backend.Model.Medication;
import MITP.team.backend.Repository.MedicationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class MedicationService implements IMedicationService {

    public final MedicationRepository medicationRepository;
    public final MedicationMapper medicationsMapper;

    @Override
    public void createNewMedication(MedicationRequestDto medicationRequestDto) {
        Medication medicationToSave = medicationsMapper.mapToMedication(medicationRequestDto);
        medicationToSave.setStatus(MedicalStatus.PLANNED);
        medicationRepository.save(medicationToSave);
    }

    @Override
    public StatusResponseDto changeMedicationStatus(Long id, StatusRequestDto statusRequestDto) {
        statusRequestValidate(statusRequestDto);

        Medication medication = medicationRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Medication not found"));
        String status = statusRequestDto.status();
        MedicalStatus medicalStatus = MedicalStatus.valueOf(status);
        medication.setStatus(medicalStatus);
        Medication savedMedication = medicationRepository.save(medication);
        return StatusResponseDto.builder().status(savedMedication.getStatus().name()).build();
    }

    @Override
    public StatusResponseDto changeMedicationStatus(MedicationRequestMandatoryDataDto requestMandatoryDataDto) {
        statusRequestValidate(StatusRequestDto.builder().status(requestMandatoryDataDto.status()).build());

        List<Medication> medications = medicationRepository.findAllByNameAndStartDateAndEndDate(
                requestMandatoryDataDto.name(),
                requestMandatoryDataDto.startDate(),
                requestMandatoryDataDto.endDate()
        );
        if (medications.isEmpty()) {
            throw new DataNotFoundException("Medication not found");
        }
        if(medications.size() > 1) {
            throw new DataNotFoundException("Multiple medications found");
        }

        Medication medication = medications.get(0);
        String status = requestMandatoryDataDto.status();
        MedicalStatus medicalStatus = MedicalStatus.valueOf(status);
        medication.setStatus(medicalStatus);
        Medication savedMedication = medicationRepository.save(medication);

        return StatusResponseDto.builder().status(savedMedication.getStatus().name()).build();
    }

    private static void statusRequestValidate(StatusRequestDto statusRequestDto) {
        List<String> allStatuses = Arrays.stream(MedicalStatus.values()).map(Enum::name).toList();
        String statusName = statusRequestDto.status();
        if (!allStatuses.contains(statusName)) {
            throw new DataNotFoundException("Status not found");
        }
    }
}
