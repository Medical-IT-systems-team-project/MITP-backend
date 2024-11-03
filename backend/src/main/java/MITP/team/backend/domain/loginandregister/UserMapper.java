package MITP.team.backend.domain.loginandregister;

import MITP.team.backend.domain.loginandregister.dto.UserRequestDto;
import MITP.team.backend.domain.loginandregister.dto.UserResponseDto;
import org.springframework.stereotype.Service;


@Service
class UserMapper {

    User mapToUser(UserRequestDto userRequestDto) {
        return User.builder()
                .login(userRequestDto.login())
                .password(userRequestDto.password())
                .build();
    }

    UserResponseDto mapToUserResponseDto(User user) {
        return UserResponseDto.builder()
                .login(user.getLogin())
                .password(user.getPassword())
                .build();
    }
}
