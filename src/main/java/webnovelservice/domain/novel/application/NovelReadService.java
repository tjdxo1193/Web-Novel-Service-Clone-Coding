package webnovelservice.domain.novel.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webnovelservice.domain.novel.dao.NovelDao;
import webnovelservice.domain.novel.dto.NovelDto;
import webnovelservice.domain.novel.dto.NovelRequest;
import webnovelservice.domain.novel.dto.ResponseNovelDto;
import webnovelservice.domain.novel.entity.Novel;
import webnovelservice.global.util.CursorRequest;
import webnovelservice.global.util.PageCursor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NovelReadService {

    final private NovelDao novelDao;

    public ResponseNovelDto findByNovelId(Long novelId) {
        var novel = novelDao.findByNovelId(novelId);
        return toDto(novel);
    }

    public PageCursor<ResponseNovelDto> findByAuthorAndTitle(CursorRequest<NovelRequest> cursorRequest) {
        var novels = novelDao.findByAuthorAndTitle(cursorRequest.r(), cursorRequest.key(), cursorRequest.size());
        var nextKey = novels.stream().mapToLong(Novel::getNovelId).min().orElse(CursorRequest.NONE_KEY);
        return new PageCursor<>(cursorRequest.next(nextKey),
                novels.stream()
                .map(this::toDto)
                .toList());
    }

    public ResponseNovelDto toDto(Novel novel) {
        return new ResponseNovelDto(
                novel.getNovelId(),
                novel.getTitle(),
                novel.getAuthor(),
                novel.getGenre(),
                novel.getDescription(),
                novel.getPublicationDate(),
                novel.getPublicationStatus(),
                novel.getCreatedAt());
    }

    public List<ResponseNovelDto> findByMostViews(NovelRequest params) {
        var novels = novelDao.findByMostViews(params);

        return novels.stream()
                .map(this::toDto)
                .toList();
    }

    public List<ResponseNovelDto> findByBestDailyFree(NovelRequest params) {
        var novels = novelDao.findByBestDailyFree(params);

        return novels.stream()
                .map(this::toDto)
                .toList();
    }

    public List<ResponseNovelDto> findByBestDailyPaid(NovelRequest params) {
        var novels = novelDao.findByBestDailyPaid(params);

        return novels.stream()
                .map(this::toDto)
                .toList();
    }

    public List<ResponseNovelDto> findByBestDailyView(NovelRequest params) {
        var novels = novelDao.findByBestDailyView(params);

        return novels.stream()
                .map(this::toDto)
                .toList();
    }

    public List<ResponseNovelDto> findByMostSales(NovelRequest params) {
        var novels = novelDao.findByMostSales(params);

        return novels.stream()
                .map(this::toDto)
                .toList();
    }

    public List<ResponseNovelDto> findByInNovelIds(List<Long> novelIds) {
        var novels = novelDao.findByInNovelIds(novelIds);
        return novels.stream()
                .map(this::toDto)
                .toList();
    }
}
