package webnovelservice.domain.favorite.dto;

import webnovelservice.domain.favorite.enums.ThumbDiv;

import java.time.LocalDateTime;

public record FavoriteCommand(
        Long novelId,
        Long userId,
        ThumbDiv thumbYn,
        LocalDateTime thumbDate
) {
}
