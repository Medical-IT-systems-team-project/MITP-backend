package MITP.team.backend.Exceptions;

public class MedicalDoctorNotFoundException extends DataNotFoundException {
    public MedicalDoctorNotFoundException() {
        super("medicalDoctor");
    }

    @Override
    public String getMessage() {
        return "Medical doctor not found";
    }
}
