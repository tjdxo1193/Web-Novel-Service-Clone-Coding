package webnovelservice.domain.episode.dto;

import java.io.File;

public record EpisodeDto (
    Long episodeIdx,
    Long novelId,
    File episodeImage,
    String title,
    Integer episodeNum,
    String content,
    Integer page,
    Integer size
){
}
