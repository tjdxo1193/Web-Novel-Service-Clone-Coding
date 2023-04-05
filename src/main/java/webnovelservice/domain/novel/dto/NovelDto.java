package webnovelservice.domain.novel.dto;

import webnovelservice.domain.novel.enums.PublicationStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record NovelDto(
        Long novelId,
        String title,
        String genre,
        String description,
        LocalDate publicationDate,
        PublicationStatus publicationStatus,
        LocalDateTime createdAt
) {
}
