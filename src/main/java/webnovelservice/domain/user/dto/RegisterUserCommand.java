package webnovelservice.domain.user.dto;

import java.time.LocalDate;

public record RegisterUserCommand(
        String email,
        String password,
        String userName,
        LocalDate birthday
) {
}
