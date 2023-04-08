package webnovelservice.domain.views.dto;

import org.springframework.format.annotation.DateTimeFormat;
import webnovelservice.domain.novel.enums.GenreDiv;
import webnovelservice.domain.novel.enums.PublicationStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ViewsDto(
        Long novelId,
        String title,
        String author,
        GenreDiv genre,
        String description,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate publicationDate,
        PublicationStatus publicationStatus,
        LocalDateTime createdAt
) {
}
