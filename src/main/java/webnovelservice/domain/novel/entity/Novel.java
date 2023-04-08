package webnovelservice.domain.novel.entity;

import lombok.Builder;
import lombok.Getter;
import webnovelservice.domain.novel.enums.GenreDiv;
import webnovelservice.domain.novel.enums.PublicationStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class Novel {
    final private Long novelId;
    final private String title;
    final private String author;
    final private GenreDiv genre;
    private String description;
    final private LocalDate publicationDate;
    final private PublicationStatus publicationStatus;
    final private LocalDateTime createdAt;

    @Builder
    public Novel(Long novelId, String title, String author, GenreDiv genre, String description, LocalDate publicationDate, PublicationStatus publicationStatus, LocalDateTime createdAt) {
        this.novelId = novelId;
        this.title = Objects.requireNonNull(title);
        this.author = Objects.requireNonNull(author);
        this.genre = Objects.requireNonNull(genre);
        this.description = Objects.requireNonNull(description);
        this.publicationDate = Objects.requireNonNull(publicationDate);
        this.publicationStatus = Objects.requireNonNullElse(publicationStatus, PublicationStatus.DEFAULT);
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }
}
