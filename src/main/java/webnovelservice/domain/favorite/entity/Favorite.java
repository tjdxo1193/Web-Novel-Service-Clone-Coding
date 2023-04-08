package webnovelservice.domain.favorite.entity;

import lombok.Builder;
import lombok.Getter;
import webnovelservice.domain.favorite.enums.ThumbDiv;

import java.time.LocalDateTime;

@Getter
public class Favorite {
    final private Long novelId;
    final private Long userId;
    final private ThumbDiv thumbYn;
    final private LocalDateTime thumbDate;
    @Builder
    public Favorite(Long novelId, Long userId, ThumbDiv thumbYn, LocalDateTime thumbDate) {
        this.novelId = novelId;
        this.userId = userId;
        this.thumbYn = thumbYn;
        this.thumbDate = thumbDate;
    }
}
