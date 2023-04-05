package webnovelservice.domain.user.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
@Getter
public class User {
    final private Long userId;
    final private String email;
    private String password;
    final private String userName;
    final private LocalDate birthday;
    final private LocalDateTime createdAt;

    @Builder
    public User(Long userId, String email, String password, String userName, LocalDate birthday, LocalDateTime createdAt) {
        this.userId = userId;
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);
        this.userName = Objects.requireNonNull(userName);
        this.birthday = Objects.requireNonNull(birthday);
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }

}
