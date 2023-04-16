package webnovelservice.domain.episode.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webnovelservice.domain.episode.dao.EpisodeDao;
import webnovelservice.domain.episode.dto.EpisodeDto;
import webnovelservice.domain.episode.entity.NovelEpisode;

@Service
@RequiredArgsConstructor
public class EpisodeReadService {
//TODO TEXT 타입 content를 페이징처리하여 (커서기반)
    final private EpisodeDao episodeDao;
    public EpisodeDto toDto(NovelEpisode episode) {
        return new EpisodeDto(
                episode.getEpisodeId(),
                episode.getNovelId(),
                episode.getEpisodeImage(),
                episode.getTitle(),
                episode.getEpisodeNum(),
                episode.getContent()
        );
    }

    public EpisodeDto findEpisodeByNovelIdAndepisodeId(Long novelId, Long episodeId) {
        var epiosde = episodeDao.findEpisodeByNovelIdAndepisodeId(novelId, episodeId);
        return toDto(epiosde);
    }
}
