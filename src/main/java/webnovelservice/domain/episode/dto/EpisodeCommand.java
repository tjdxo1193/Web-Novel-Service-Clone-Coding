package webnovelservice.domain.episode.dto;

import java.io.File;

public record EpisodeCommand(
        Long episodeId,
        Long novelId,
        String title,
        int episodeNum,
        String content,
        File episodeImage
) {
}
