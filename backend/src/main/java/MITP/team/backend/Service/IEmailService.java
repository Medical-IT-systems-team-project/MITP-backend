package MITP.team.backend.Service;

public interface IEmailService {
  void sendSummaryEmail(Long id);

  void sendRestartEmail(String email, String accessId);
}
