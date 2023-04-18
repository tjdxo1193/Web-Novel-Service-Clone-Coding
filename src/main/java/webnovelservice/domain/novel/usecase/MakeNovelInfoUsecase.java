package webnovelservice.domain.novel.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webnovelservice.domain.episode.application.EpisodeReadService;
import webnovelservice.domain.novel.application.NovelReadService;
import webnovelservice.domain.novel.dto.NovelDetailDto;
@Service
@RequiredArgsConstructor
public class MakeNovelInfoUsecase {

    final private NovelReadService novelReadService;
    final private EpisodeReadService episodeReadService;

    public NovelDetailDto fetchNovelDetail(Long novelId, Long userId) {
        var novelHeader = novelReadService.findNovelDetailByNovelId(novelId, userId);
        // TODO 값을 넣어야함.
        return new NovelDetailDto(

        );
    }
}
