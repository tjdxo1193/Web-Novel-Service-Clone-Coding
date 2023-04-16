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
    // TODO 화면 영역을 DTO나 변수명으로 정하는 것이 좋지 않음 -> 바꾸기
    public NovelDetailDto fetchNovelDetail(Long novelId, Long userId) {
        var novelHeader = novelReadService.findNovelDetailByNovelId(novelId, userId);
        // var novelBody
        return null;
    }
}
