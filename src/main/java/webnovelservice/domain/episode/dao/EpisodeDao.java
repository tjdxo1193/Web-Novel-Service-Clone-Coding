package webnovelservice.domain.episode.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import webnovelservice.domain.episode.entity.Episode;

@Mapper
public interface EpisodeDao {

    Long createEpisode(@Param("novelId") Long novelId,@Param("userId") Long userId);

    int updateEpisode(@Param("novelId") Long novelId,@Param("episodeIdx") Long episodeIdx);

    Episode findEpisodeByNovelIdAndEpisodeIdx(@Param("novelId")Long novelId, @Param("episodeIdx") Long episodeIdx);
}
