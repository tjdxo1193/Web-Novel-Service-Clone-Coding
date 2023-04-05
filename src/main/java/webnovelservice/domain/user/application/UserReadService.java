package webnovelservice.domain.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webnovelservice.domain.user.dao.UserDao;
import webnovelservice.domain.user.dto.ResponseUserDto;
import webnovelservice.domain.user.entity.User;
@Service
@RequiredArgsConstructor
public class UserReadService {

    final private UserDao userDao;

    public ResponseUserDto getUser(Long userId) {
        return null;
    }

    public ResponseUserDto toDto(User user) {
        return null;
    }
}
