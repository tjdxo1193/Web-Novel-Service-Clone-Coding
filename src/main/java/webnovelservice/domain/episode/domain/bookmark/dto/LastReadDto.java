package webnovelservice.domain.episode.domain.bookmark.dto;

import lombok.Builder;

import java.time.LocalDateTime;

public class LastReadDto {
    private Long lastReadId;
    private Long userId;
    private Long novelId;
    private Long episodeId;
    private Integer lastReadPage;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    @Builder
    public LastReadDto(Long lastReadId, Long userId, Long novelId, Long episodeId, Integer lastReadPage, LocalDateTime updatedAt, LocalDateTime createdAt) {
        this.lastReadId = lastReadId;
        this.userId = userId;
        this.novelId = novelId;
        this.episodeId = episodeId;
        this.lastReadPage = lastReadPage;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }
}
