package webnovelservice.domain.novel.dto;

import webnovelservice.domain.novel.enums.GenreDiv;
import webnovelservice.domain.novel.enums.PublicationStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RegisterNovelCommand(
        String title,
        String author,
        GenreDiv genre,
        String description,
        LocalDate publicationDate,
        PublicationStatus publicationStatus
) {
}
