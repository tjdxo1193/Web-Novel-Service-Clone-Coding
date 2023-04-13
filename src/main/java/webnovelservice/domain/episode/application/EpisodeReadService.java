package webnovelservice.domain.episode.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webnovelservice.domain.episode.dao.EpisodeDao;
import webnovelservice.domain.episode.dto.EpisodeDto;
import webnovelservice.domain.episode.entity.Episode;

import java.io.File;

@Service
@RequiredArgsConstructor
public class EpisodeReadService {

    final private EpisodeDao episodeDao;
    public EpisodeDto toDto(Episode episode) {
        return new EpisodeDto(
                episode.getEpisodeIdx(),
                episode.getNovelId(),
                episode.getEpisodeImage(),
                episode.getTitle(),
                episode.getEpisodeNum(),
                episode.getContent(),
                episode.getPage(),
                episode.getSize()
        );
    }

    public EpisodeDto findEpisodeByNovelIdAndEpisodeIdx(Long novelId, Long episodeIdx) {
        var epiosde = episodeDao.findEpisodeByNovelIdAndEpisodeIdx(novelId, episodeIdx);
        return toDto(epiosde);
    }
}
