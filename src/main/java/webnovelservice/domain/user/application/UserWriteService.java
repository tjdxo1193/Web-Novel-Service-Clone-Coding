package webnovelservice.domain.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webnovelservice.domain.user.dao.UserDao;
import webnovelservice.domain.user.dto.RegisterUserCommand;
import webnovelservice.domain.user.entity.User;
@Service
@RequiredArgsConstructor
public class UserWriteService {

    final private UserDao userDao;

    public User create(RegisterUserCommand command) {
        var member = User.builder()
                .email(command.email())
                .email(command.email())
                .email(command.email())
                .email(command.email())
                .email(command.email())
                .birthday(command.birthday())
                .build();
        var savedUser = userDao.save(member);

        return savedUser;
    }
}
