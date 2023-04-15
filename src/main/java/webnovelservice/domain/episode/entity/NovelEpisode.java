package webnovelservice.domain.episode.entity;

import lombok.Builder;
import lombok.Getter;
import webnovelservice.global.util.Paging;


@Getter
public class NovelEpisode extends Paging {
final private Long episodeId;
final private Long novelId;
final private String title;
final private int episodeNum;
final private String content;
    @Builder
    public NovelEpisode(Long episodeId, Long novelId, String title, int episodeNum, String content) {
        this.episodeId = episodeId;
        this.novelId = novelId;
        this.title = title;
        this.episodeNum = episodeNum;
        this.content = content;
    }
}
