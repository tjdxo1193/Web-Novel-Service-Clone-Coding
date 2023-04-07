package webnovelservice.domain.novel.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webnovelservice.domain.novel.dao.NovelDao;
import webnovelservice.domain.novel.dto.NovelDto;
import webnovelservice.domain.novel.dto.NovelRequestForPaging;
import webnovelservice.domain.novel.dto.ResponseNovelDto;
import webnovelservice.domain.novel.entity.Novel;
import webnovelservice.domain.novel.enums.PublicationStatus;
import webnovelservice.domain.user.dto.ResponseUserDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NovelReadService {

    final private NovelDao novelDao;

    public ResponseNovelDto findByNovelId(Long novelId) {
        var novel = novelDao.findByNovelId(novelId);
        return toDto(novel);
    }

    public List<ResponseNovelDto> findByAuthorAndTitle(NovelRequestForPaging params) {

        var novels = novelDao.findByAuthorAndTitle(params);

        return novels.stream()
                .map(this::toDto)
                .toList();
    }
    public ResponseNovelDto toDto(Novel novel) {
        return new ResponseNovelDto(
                novel.getNovelId(),
                novel.getTitle(),
                novel.getGenre(),
                novel.getDescription(),
                novel.getPublicationDate(),
                novel.getPublicationStatus(),
                novel.getCreatedAt());
    }

}
