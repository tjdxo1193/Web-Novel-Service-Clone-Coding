package webnovelservice.domain.user.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ResponseUserDto(
        Long userId,
        String email,
        String userName,
        LocalDate birthday,
        LocalDateTime createdAt
) {
}
