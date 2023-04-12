
package webnovelservice.domain.favorite.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webnovelservice.domain.favorite.application.FavoriteReadService;
import webnovelservice.domain.favorite.application.FavoriteWriteService;
import webnovelservice.domain.favorite.dto.FavoriteDto;
import webnovelservice.domain.novel.application.NovelReadService;
import webnovelservice.domain.novel.dto.NovelDto;
import webnovelservice.domain.novel.dto.ResponseNovelDto;
import webnovelservice.domain.user.application.UserReadService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetNovelFavoriteUsecase {
    final private NovelReadService novelReadService;
    final private FavoriteReadService favoriteReadService;

    public List<ResponseNovelDto> execute(Long userId) {
        var favorite = favoriteReadService.findFavoritesByUserId(userId);
        return novelReadService.findByInNovelIds(favorite.stream().map(FavoriteDto::novelId).toList());
    }
}
