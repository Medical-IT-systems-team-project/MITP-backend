package MITP.team.backend.infrastructure.loginandregister.controller;

import MITP.team.backend.domain.loginandregister.dto.UserRequestDto;
import MITP.team.backend.domain.loginandregister.dto.UserResponseDto;
import MITP.team.backend.infrastructure.loginandregister.controller.dto.RegisterRequestDto;
import MITP.team.backend.infrastructure.loginandregister.controller.dto.RegisterResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class LoginAndRegisterMapper {
    private final PasswordEncoder passwordEncoder;

    UserRequestDto fromReqisterRequestDto(RegisterRequestDto dto) {
        return UserRequestDto.builder()
                .login(dto.login())
                .password(passwordEncoder.encode(dto.password()))
                .build();
    }

    RegisterResponseDto fromUserResponseDto(UserResponseDto dto, String message) {
        return RegisterResponseDto.builder()
                .login(dto.login())
                .message(message)
                .build();
    }

}
