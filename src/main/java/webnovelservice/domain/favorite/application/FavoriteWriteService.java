package webnovelservice.domain.favorite.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webnovelservice.domain.favorite.dao.FavoriteDao;

@Service
@RequiredArgsConstructor
public class FavoriteWriteService {

    final private FavoriteDao favoriteDao;

    public int addFavorite(Long userId, Long novelId) {
        return favoriteDao.createFavorite(userId, novelId);
    }

    public int deleteFavorite(Long userId, Long novelId) {
        return favoriteDao.deleteFavorite(userId, novelId);
    }
}
