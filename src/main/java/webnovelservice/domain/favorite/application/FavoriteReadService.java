package webnovelservice.domain.favorite.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webnovelservice.domain.favorite.dao.FavoriteDao;
import webnovelservice.domain.favorite.dto.FavoriteDto;
import webnovelservice.domain.favorite.entity.Favorite;
import webnovelservice.domain.favorite.enums.ThumbDiv;
import webnovelservice.domain.novel.dto.ResponseNovelDto;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteReadService {

    final private FavoriteDao favoriteDao;

    public FavoriteDto toDto(Favorite favorite) {
        return new FavoriteDto(
                favorite.getNovelId(),
                favorite.getUserId(),
                favorite.getThumbYn(),
                favorite.getThumbDate());
    }

    public List<FavoriteDto> findFavoritesByUserId(Long userId) {
        var favorites = favoriteDao.findFavoritesByUserId(userId);
        return favorites.stream()
                .map(this::toDto)
                .toList();
    }
}
