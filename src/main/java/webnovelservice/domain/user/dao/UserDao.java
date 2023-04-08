package webnovelservice.domain.user.dao;

import webnovelservice.domain.user.entity.User;

public interface UserDao {

    User saveUser(User member);
    void updateUser(User member);
    User findByUserId(Long userId);
}
