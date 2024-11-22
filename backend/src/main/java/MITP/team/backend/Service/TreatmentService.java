package MITP.team.backend.Service;


import MITP.team.backend.Model.Dto.TreatmentDto;
import MITP.team.backend.Model.Mapper.TreatmentMapper;
import MITP.team.backend.Repository.TreatmentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@AllArgsConstructor
public class TreatmentService implements ITreatmentService {

    private final TreatmentRepository treatmentRepository;
    private final TreatmentMapper treatmentMapper;

    @Override
    public void createNewTreatment(TreatmentDto treatmentDto) {
        treatmentRepository.save(treatmentMapper.mapToTreatment(treatmentDto));
    }
}
