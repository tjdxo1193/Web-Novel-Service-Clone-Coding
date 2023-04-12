package webnovelservice.domain.favorite.dao;

import org.apache.ibatis.annotations.Mapper;
import webnovelservice.domain.favorite.entity.Favorite;

import java.util.List;

@Mapper
public interface FavoriteDao {

    int addFavorite(Long userId, Long novelId);

    List<Favorite> findFavoritesByUserId(Long userId);

    int deleteFavorite(Long userId, Long novelId);
}


