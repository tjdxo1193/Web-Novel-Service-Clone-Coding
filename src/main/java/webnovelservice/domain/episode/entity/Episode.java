package webnovelservice.domain.episode.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import webnovelservice.global.util.Paging;

import java.io.File;
import java.util.Objects;

@Getter
public class Episode extends Paging {

    final private Long episodeIdx;
    final private Long novelId;
    final private File episodeImage;
    final private String title;
    final private Integer episodeNum;
    final private String content;

    private Long userId;

    @Builder
    public Episode(Long episodeIdx, Long novelId, File episodeImage, String title, Integer episodeNum, String content, Long userId) {
        this.episodeIdx = Objects.requireNonNull(episodeIdx);
        this.novelId = Objects.requireNonNull(novelId);
        this.episodeImage = episodeImage;
        this.title = Objects.requireNonNull(title);
        this.episodeNum = Objects.requireNonNull(episodeNum);
        this.content = Objects.requireNonNull(content);
        this.userId = userId;
    }

    @AllArgsConstructor
    @Builder
    public class EpisodeKey{
        private Long userId;
        private Long novelId;
        private Long episodeIdx;
    }
}
