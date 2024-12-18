package MITP.team.backend.Service;

import MITP.team.backend.Exceptions.DataNotFoundException;
import MITP.team.backend.Exceptions.ServerInternalError;
import MITP.team.backend.Model.Dto.StatusRequestDto;
import MITP.team.backend.Model.Dto.TreatmentRequestDto;
import MITP.team.backend.Model.Enum.MedicalStatus;
import MITP.team.backend.Model.Mapper.TreatmentMapper;
import MITP.team.backend.Model.Treatment;
import MITP.team.backend.Repository.TreatmentRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@AllArgsConstructor
public class TreatmentService implements ITreatmentService {

    private final TreatmentRepository treatmentRepository;
    private final TreatmentMapper treatmentMapper;

    @Override
    public void createNewTreatment(TreatmentRequestDto treatmentRequestDto) {
        Treatment treatmentToSave = treatmentMapper.mapToTreatment(treatmentRequestDto);
        treatmentToSave.setStatus(MedicalStatus.PLANNED);
        treatmentRepository.save(treatmentToSave);
    }

    @Override
    @SneakyThrows(ServerInternalError.class)
    public void changeTreatmentStatus(Long id, StatusRequestDto statusRequestDto) {
        Treatment treatment = treatmentRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Treatment not found"));
        treatment.setStatus(statusRequestDto.status());
        treatmentRepository.save(treatment);
    }

}
