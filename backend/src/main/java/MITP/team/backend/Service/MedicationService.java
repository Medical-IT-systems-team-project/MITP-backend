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
        Medication medication = medicationRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Medication not found"));
        medication.setStatus(statusRequestDto.status());
        Medication savedMedication = medicationRepository.save(medication);
        return StatusResponseDto.builder().status(savedMedication.getStatus().name()).build();
    }
}
