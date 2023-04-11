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
        var user = User.builder()
                .email(command.email())
                .userName(command.userName())
                .birthday(command.birthday())
                .password(command.password())
                .build();
        userDao.saveUser(user);

        return user;
    }
}
