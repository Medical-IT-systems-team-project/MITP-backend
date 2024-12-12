package MITP.team.backend.Service;

import MITP.team.backend.Exceptions.DataNotFoundException;
import MITP.team.backend.Model.Dto.StatusRequestDto;
import MITP.team.backend.Model.Dto.StatusResponseDto;
import MITP.team.backend.Model.Dto.TreatmentRequestDto;
import MITP.team.backend.Model.Dto.TreatmentRequestMandatoryDataDto;
import MITP.team.backend.Model.Enum.MedicalStatus;
import MITP.team.backend.Model.Mapper.TreatmentMapper;
import MITP.team.backend.Model.Treatment;
import MITP.team.backend.Repository.TreatmentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static MITP.team.backend.Service.MedicationService.statusRequestValidate;

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
    public StatusResponseDto changeTreatmentStatus(Long id, StatusRequestDto statusRequestDto) {
        statusRequestValidate(statusRequestDto);

        Treatment treatment = treatmentRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Treatment not found"));
        String status = statusRequestDto.status();
        MedicalStatus medicalStatus = MedicalStatus.valueOf(status);
        treatment.setStatus(medicalStatus);
        Treatment savedTreatment = treatmentRepository.save(treatment);
        return StatusResponseDto.builder().status(savedTreatment.getStatus().name()).build();
    }

    @Override
    public StatusResponseDto changeTreatmentStatus(TreatmentRequestMandatoryDataDto requestMandatoryDataDto) {
        statusRequestValidate(StatusRequestDto.builder().status(requestMandatoryDataDto.status()).build());

        List<Treatment> allByNameAndStartDateAndEndDate = treatmentRepository.findAllByNameAndStartDateAndEndDate(
                requestMandatoryDataDto.name(),
                requestMandatoryDataDto.startDate(),
                requestMandatoryDataDto.endDate()
        );

        if (allByNameAndStartDateAndEndDate.isEmpty()) {
            throw new DataNotFoundException("Treatment not found");
        }

        if(allByNameAndStartDateAndEndDate.size() > 1) {
            throw new DataNotFoundException("Multiple treatments found");
        }

        Treatment treatment = allByNameAndStartDateAndEndDate.get(0);
        String status = requestMandatoryDataDto.status();
        MedicalStatus medicalStatus = MedicalStatus.valueOf(status);
        treatment.setStatus(medicalStatus);
        Treatment savedTreatment = treatmentRepository.save(treatment);

        return StatusResponseDto.builder().status(savedTreatment.getStatus().name()).build();
    }
}
