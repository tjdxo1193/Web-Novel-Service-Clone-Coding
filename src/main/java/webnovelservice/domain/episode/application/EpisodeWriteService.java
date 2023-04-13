package webnovelservice.domain.episode.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webnovelservice.domain.episode.dao.EpisodeDao;
import webnovelservice.domain.episode.dto.EpisodeDto;
import webnovelservice.domain.episode.entity.Episode;

@Service
@RequiredArgsConstructor
public class EpisodeWriteService {

    final private EpisodeReadService episodeReadService;
    final private EpisodeDao episodeDao;
    public EpisodeDto createEpisode(Long novelId, Long userId) {
        Long episodeIdx = episodeDao.createEpisode(novelId, userId);
        return episodeReadService.toDto(Episode.builder()
                .build());
    }

    public EpisodeDto updateEpisode(Long novelId, Long episodeIdx) {
        episodeDao.updateEpisode(novelId, episodeIdx);
        var episode = episodeReadService.findEpisodeByNovelIdAndEpisodeIdx(novelId, episodeIdx);
        return episodeReadService.toDto(Episode.builder()
                .build());
    }
}
