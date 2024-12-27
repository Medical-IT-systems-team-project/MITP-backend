package MITP.team.backend.Service;

import MITP.team.backend.Exceptions.DataNotFoundException;
import MITP.team.backend.Exceptions.MedicationNotFoundException;
import MITP.team.backend.Exceptions.ServerInternalError;
import MITP.team.backend.Model.Dto.MedicationRequestDto;
import MITP.team.backend.Model.Dto.StatusRequestDto;
import MITP.team.backend.Model.Enum.MedicalStatus;
import MITP.team.backend.Model.Mapper.MedicationMapper;
import MITP.team.backend.Model.Medication;
import MITP.team.backend.Repository.MedicationRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class MedicationService implements IMedicationService {

    public final MedicationRepository medicationRepository;
    public final MedicationMapper medicationMapper;

    @Override
    @SneakyThrows(ServerInternalError.class)
    public void createNewMedication(MedicationRequestDto medicationRequestDto) {
        Medication medicationToSave = medicationMapper.mapToMedication(medicationRequestDto);
        medicationToSave.setStatus(MedicalStatus.PLANNED);
        medicationRepository.save(medicationToSave);
    }

    @Override
    public void changeMedicationStatus(Long id, StatusRequestDto statusRequestDto) {
        Medication medication = medicationRepository.findById(id).orElseThrow(MedicationNotFoundException::new);
        if (medication.getStatus().equals(statusRequestDto.status())) {
            throw new DataNotFoundException("Status is already " + medication.getStatus());
        }
        medication.setStatus(statusRequestDto.status());
        medicationRepository.save(medication);
    }
}
