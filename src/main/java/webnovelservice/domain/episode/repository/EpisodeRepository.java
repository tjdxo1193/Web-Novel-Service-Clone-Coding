package webnovelservice.domain.episode.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webnovelservice.domain.episode.domain.bookmark.dto.LastReadDto;
import webnovelservice.domain.episode.entity.EpisodeInfo;
import webnovelservice.domain.episode.entity.NovelEpisode;
import webnovelservice.domain.novel.entity.Novel;

@Repository
public class EpisodeRepository {

/*    Long createEpisode(NovelEpisode episode);

    NovelEpisode findEpisodeByNovelIdAndepisodeId(@Param("novelId") Long novelId, @Param("episodeId") Long episodeId);

    Integer createEpisodeInfo(EpisodeInfo episodeInfo);

    Integer updateEpisodeImage(EpisodeInfo episodeInfo);

    Integer updateEpisode(NovelEpisode episode);

    Integer createBookMark(LastReadDto lastReadDto);*/
}
