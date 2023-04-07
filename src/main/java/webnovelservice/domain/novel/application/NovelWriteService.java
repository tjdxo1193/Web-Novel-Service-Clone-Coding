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

        return novel;
    }

    public void update(Long novelId, NovelDto novelDto) {
        var novel = novelDao.findByNovelId(novelId);
        novel.chanageNovelCover(novelDto);
        novelDao.update(novel);
    }
}
