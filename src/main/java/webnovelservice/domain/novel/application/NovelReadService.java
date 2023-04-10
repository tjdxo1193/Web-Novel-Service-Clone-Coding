package webnovelservice.domain.novel.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webnovelservice.domain.novel.dao.NovelDao;
import webnovelservice.domain.novel.dto.NovelRequest;
import webnovelservice.domain.novel.dto.ResponseNovelDto;
import webnovelservice.domain.novel.entity.Novel;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NovelReadService {

    final private NovelDao novelDao;

    public ResponseNovelDto getNovel(Long novelId) {
        var novel = novelDao.findByNovelId(novelId);
        return toDto(novel);
    }

    public List<ResponseNovelDto> getNovels(NovelRequest params) {

        var novels = novelDao.findByAuthorAndTitle(params);

        return novels.stream()
                .map(this::toDto)
                .toList();
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

    public List<ResponseNovelDto> getThisMonthNovels(NovelRequest params) {
        var novels = novelDao.findByMostViews(params);

        return novels.stream()
                .map(this::toDto)
                .toList();
    }

    public List<ResponseNovelDto> getBestSellerNovels(NovelRequest params) {
        var novels = novelDao.findByMostSales(params);

        return novels.stream()
                .map(this::toDto)
                .toList();
    }
}
