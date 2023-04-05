package webnovelservice.domain.novel.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Novel {
    final private String novelId;
    final private String title;
    final private String genre;
    final private String description;
    final private String publicationDate;
    final private String publicationStatus;
    final private String createAt;
    @Builder
    public Novel(String novelId, String title, String genre, String description, String publicationDate, String publicationStatus, String createAt) {
        this.novelId = novelId;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.publicationDate = publicationDate;
        this.publicationStatus = publicationStatus;
        this.createAt = createAt;
    }
}
