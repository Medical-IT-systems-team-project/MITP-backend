package MITP.team.backend.Model.Dto;

import MITP.team.backend.Model.MedicalDoctor;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder

public record MedicalDataCaseDto(
        String admissionReason,
        LocalDateTime admissionDate,
        String description,
        MedicalDoctor createdBy,
        List<MedicationsDto> medications,
        List<TreatmentDto> treatments) {
    public MedicalDataCaseDto sortMedicationsByDate() {
        return null;
        //TODO: implement (czy chcemy czasem sortować listę leków? a moze odrazu przy dodawnanuiu? )
    }
}
