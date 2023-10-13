package webnovelservice.domain.novel.entity;

import lombok.Builder;
import lombok.Getter;
import webnovelservice.domain.novel.enums.GenreDiv;
import webnovelservice.domain.novel.enums.PublicationStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
public class Novel {
    final private Long novelId;
    private String novelIds;
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
        this.genre = Objects.requireNonNullElse(genre, GenreDiv.NONE);
        this.description = Objects.requireNonNull(description);
        this.publicationDate = Objects.requireNonNull(publicationDate);
        this.publicationStatus = Objects.requireNonNullElse(publicationStatus, PublicationStatus.DEFAULT);
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }

    public void toNovelIdsWithComma(List<Long> novelIds) {
        if (novelIds.size() != 0) {
            // TODO IN 에 들어갈 형식으로 만들기
            this.novelIds = novelIds.toString();
        } else {
            this.novelIds = "";
        }
    }
}
