package MITP.team.backend.Service;


import MITP.team.backend.Model.Dto.MedicationsDto;
import MITP.team.backend.Model.Mapper.MedicationsMapper;
import MITP.team.backend.Repository.MedicationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class MedicationService implements IMedicationService {

    public final MedicationRepository medicationRepository;
    public final MedicationsMapper medicationsMapper;

    @Override
    public void createNewMedications(MedicationsDto medicationsDto) {
        medicationRepository.save(medicationsMapper.mapToMedication(medicationsDto));

    }
}
