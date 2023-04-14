package webnovelservice.domain.favorite.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import webnovelservice.domain.favorite.entity.Favorite;

import java.util.List;

@Mapper
public interface FavoriteDao {
    int createFavorite(@Param("userId") Long userId, @Param("novelId") Long novelId);
    int deleteFavorite(@Param("userId") Long userId,@Param("novelId") Long novelId);
    List<Favorite> findFavoritesByUserId(Long userId);
}


