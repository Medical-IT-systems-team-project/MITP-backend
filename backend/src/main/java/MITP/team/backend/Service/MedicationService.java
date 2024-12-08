package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.MedicationRequestDto;
import MITP.team.backend.Model.Enum.MedicalStatus;
import MITP.team.backend.Model.Mapper.MedicationMapper;
import MITP.team.backend.Model.Medication;
import MITP.team.backend.Repository.MedicationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
