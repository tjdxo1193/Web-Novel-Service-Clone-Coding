package webnovelservice.domain.episode.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import webnovelservice.domain.episode.entity.EpisodeInfo;
import webnovelservice.domain.episode.entity.NovelEpisode;

@Mapper
public interface EpisodeDao {

    Long createEpisode(NovelEpisode episode);

    NovelEpisode findEpisodeByNovelIdAndepisodeId(@Param("episodeId") Long episodeId);

    Integer createEpisodeInfo(EpisodeInfo episodeInfo);

    int updateEpisodeImage(EpisodeInfo episodeInfo);

    int updateEpisode(NovelEpisode episode);

}
