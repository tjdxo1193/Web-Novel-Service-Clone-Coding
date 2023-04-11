package webnovelservice.domain.novel.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webnovelservice.domain.novel.dao.NovelDao;
import webnovelservice.domain.novel.dto.NovelDto;
import webnovelservice.domain.novel.dto.RegisterNovelCommand;
import webnovelservice.domain.novel.entity.Novel;
import webnovelservice.domain.novel.enums.PublicationStatus;
import webnovelservice.domain.user.dto.RegisterUserCommand;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class NovelWriteService {

    final private NovelDao novelDao;


    public Novel create(RegisterNovelCommand command) {
        var novel = Novel.builder()
                .title(command.title())
                .genre(command.genre())
                .description(command.description())
                .publicationDate(command.publicationDate())
                .publicationStatus(PublicationStatus.SERIALIZED)
                .build();

        novelDao.saveNovel(novel);
        return novel;
    }

    public Novel update(Long novelId, NovelDto novelDto) {
        var novel = Novel.builder()
                .novelId(novelId)
                .title(novelDto.title())
                .genre(novelDto.genre())
                .description(novelDto.description())
                .publicationDate(novelDto.publicationDate())
                .publicationStatus(PublicationStatus.SERIALIZED)
                .build();

        novelDao.updateNovel(novel);

        return novel;
    }

    public void delete(Long novelId) {
        novelDao.deleteNovel(novelId);
    }
}
