package webnovelservice.domain.episode.dto;

import java.io.File;

public record EpisodeDetail(
        Long novelId,
        Long episodeId,
        String title,
        Integer episodeNum,
        Integer pageCount,
        // TODO image 어떤 타입으로 방식으로 내려줄지
        File episodeImage
        ) {
}
