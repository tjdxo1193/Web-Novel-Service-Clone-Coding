package webnovelservice.domain.episode.entity;

import lombok.Builder;

import java.io.File;

public class EpisodeInfo {
    final private Long episodeId;
    final private Long novelId;
    final private File episodeImage;
    @Builder
    public EpisodeInfo(Long episodeId, Long novelId, File episodeImage) {
        this.episodeId = episodeId;
        this.novelId = novelId;
        this.episodeImage = episodeImage;
    }
}
