package MITP.team.backend.domain_KW.Service;

import MITP.team.backend.domain_KW.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UniqueIdGenerator {
  private final PatientRepository patientRepo;
  private static final int ID_LENGTH = 10;
  private static final int MAX_ATTEMPTS = 10;

  private final RandomStringGenerator generator =
      new RandomStringGenerator.Builder()
          .withinRange('0', 'z')
          .filteredBy(Character::isLetterOrDigit)
          .build();

  public String generateUniqueId() {
    String generatedId;
    int attempts = 0;

    do {
      generatedId = generator.generate(ID_LENGTH);
      attempts++;

      if (attempts >= MAX_ATTEMPTS) {
        throw new RuntimeException(
            "Unable to generate unique ID after " + MAX_ATTEMPTS + " attempts");
      }
    } while (patientRepo.existsByAccessId(generatedId));

    return generatedId;
  }
}
