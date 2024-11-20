package MITP.team.backend.Service;

import MITP.team.backend.Exceptions.UserNotFoundException;
import MITP.team.backend.Model.Dto.DrugTreatmentDto;
import MITP.team.backend.Model.Dto.MedicalDataCaseDto;
import MITP.team.backend.Model.Dto.MedicationsDto;
import MITP.team.backend.Model.Dto.TreatmentDto;
import MITP.team.backend.Model.Mapper.MedicalDataCaseMapper;
import MITP.team.backend.Model.Patient;
import MITP.team.backend.Repository.MedicalCaseData;
import MITP.team.backend.Repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// TOD O cala klasa xd
@AllArgsConstructor
@Service
public class MedicalDataService implements IMedicalDataService {

    private final PatientRepository patientRepository;
    private final MedicalCaseData medicalCaseData;
    private final MedicalDataCaseMapper medicalDataCaseMapper;


    @Override
    public MedicalDataCaseDto getMedicalDataByAccessId(String uuid) {
        Patient patient =
                patientRepository
                        .findByAccessId(uuid)
                        .orElseThrow(
                                () ->
                                        new UserNotFoundException(
                                                "Patient with access ID " + uuid + " does not exist"));
        return null;
    }

    @Override
    public List<TreatmentDto> getTreatmentByAccessId(String uuid) {
        Patient patient =
                patientRepository
                        .findByAccessId(uuid)
                        .orElseThrow(
                                () ->
                                        new UserNotFoundException("Patient with access ID" + uuid + "does not exist"));
        return null;
    }

    @Override
    public List<DrugTreatmentDto> getDrugTreatmentByAccessId(String uuid) {
        Patient patient =
                patientRepository
                        .findByAccessId(uuid)
                        .orElseThrow(
                                () ->
                                        new UserNotFoundException("Patient with access ID" + uuid + "does not exist"));
        return null;
    }

    @Override
    public List<MedicationsDto> getMedicationsByAccessId(String uuid) {
        Patient patient =
                patientRepository
                        .findByAccessId(uuid)
                        .orElseThrow(
                                () ->
                                        new UserNotFoundException("Patient with access ID" + uuid + "does not exsit"));

        return null;
    }

    @Override
    public void addNewCase(MedicalDataCaseDto medicalDataCaseDto) {
        medicalDataCaseMapper.MedicalDataCaseRequestToMedicalDataCase(medicalDataCaseDto);

    }


}
