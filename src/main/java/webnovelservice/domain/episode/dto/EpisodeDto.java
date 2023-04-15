package webnovelservice.domain.episode.dto;

import java.io.File;

public record EpisodeDto (
    Long episodeId,
    Long novelId,
    File episodeImage,
    String title,
    Integer episodeNum,
    String content
){
}
