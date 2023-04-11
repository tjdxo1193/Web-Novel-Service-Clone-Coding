package webnovelservice.domain.user.dao;

import org.apache.ibatis.annotations.Mapper;
import webnovelservice.domain.user.entity.User;
@Mapper
public interface UserDao {

    int saveUser(User member);
    int updateUser(User member);
    User findByUserId(Long userId);
}
