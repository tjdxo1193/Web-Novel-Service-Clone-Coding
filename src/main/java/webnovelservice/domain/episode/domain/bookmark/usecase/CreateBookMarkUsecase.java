package webnovelservice.domain.episode.domain.bookmark.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webnovelservice.domain.episode.dao.EpisodeDao;
import webnovelservice.domain.episode.domain.bookmark.dto.LastReadDto;

@Service
@RequiredArgsConstructor
public class CreateBookMarkUsecase {
    final private EpisodeDao episodeDao;

    public Integer createBookMark(LastReadDto lastReadDto) {
        return episodeDao.createBookMark(lastReadDto);
    }
}
