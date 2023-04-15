package webnovelservice.domain.views.dto;

import java.time.LocalDateTime;

public record ViewsDto(
        Long userId,
        Long novelId,
        Integer viewCount,
        LocalDateTime viewDate
) {
    public ViewsDto createViewCountPlusOne() {
        return new ViewsDto(
                this.userId,
                this.novelId,
                this.viewCount + 1,
                LocalDateTime.now()
        );
    }
}
