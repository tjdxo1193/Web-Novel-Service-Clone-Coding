package webnovelservice.domain.episode.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import webnovelservice.domain.episode.domain.bookmark.dto.LastReadDto;
import webnovelservice.domain.episode.entity.EpisodeInfo;
import webnovelservice.domain.episode.entity.NovelEpisode;

@Mapper
public interface EpisodeDao {

    Long createEpisode(NovelEpisode episode);

    NovelEpisode findEpisodeByNovelIdAndepisodeId(@Param("novelId") Long novelId, @Param("episodeId") Long episodeId);

    Integer createEpisodeInfo(EpisodeInfo episodeInfo);

    Integer updateEpisodeImage(EpisodeInfo episodeInfo);

    Integer updateEpisode(NovelEpisode episode);

    Integer createBookMark(LastReadDto lastReadDto);
}
