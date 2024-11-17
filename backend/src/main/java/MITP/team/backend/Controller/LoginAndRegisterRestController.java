package MITP.team.backend.Controller;

import MITP.team.backend.Model.Dto.MedicalDoctorResponse;
import MITP.team.backend.Model.Dto.RegisterRequestDto;
import MITP.team.backend.Model.Dto.RegisterResponseDto;
import MITP.team.backend.Model.Mapper.LoginAndRegisterMapper;
import MITP.team.backend.Service.LoginAndRegisterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@AllArgsConstructor
public class LoginAndRegisterRestController {

  private final LoginAndRegisterService loginAndRegisterService;
    private final LoginAndRegisterMapper mapper;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RegisterResponseDto> registerUser(@RequestBody @Valid RegisterRequestDto registerRequestDto) {
    final MedicalDoctorResponse medicalDoctorResponse =
        loginAndRegisterService.register(mapper.fromRegisterRequestDto(registerRequestDto));
        String responseMessage = "REGISTERED";
    final RegisterResponseDto registered =
        mapper.fromUserResponseDto(medicalDoctorResponse, responseMessage);
        log.info("User registered: {}", registered);
        return ResponseEntity.status(HttpStatus.CREATED).body(registered);
    }

  @GetMapping("/find/{login}")
  public ResponseEntity<MedicalDoctorResponse> findUser(@PathVariable String login) {
    final MedicalDoctorResponse byUsername = loginAndRegisterService.findByUsername(login);
        log.info("User found: {}", byUsername);
        return ResponseEntity.ok(byUsername);
    }

  @PutMapping("/update/{login}")
  public ResponseEntity<MedicalDoctorResponse> updateUser(
      @PathVariable String login, @RequestBody @Valid RegisterRequestDto registerRequestDto) {
    final MedicalDoctorResponse body =
        loginAndRegisterService.updateByLogin(
            login, mapper.fromRegisterRequestDto(registerRequestDto));
        log.info("User updated: {}", body);
        return ResponseEntity.ok(body);
    }

  @DeleteMapping("/delete/{login}")
  public ResponseEntity<MedicalDoctorResponse> deleteUser(@PathVariable String login) {
        log.info("Deleting user: {}", login);
    return ResponseEntity.ok(loginAndRegisterService.deleteUser(login));
    }
}