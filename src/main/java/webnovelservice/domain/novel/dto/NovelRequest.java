package webnovelservice.domain.novel.dto;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import webnovelservice.domain.novel.enums.PublicationStatus;
import webnovelservice.global.util.Paging;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
public class NovelRequest extends Paging {
    private Long novelId;
    private String title;
    private String author;
    private String genre;
    private String description;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate publicationDate;
    private PublicationStatus publicationStatus;
    private LocalDateTime createdAt;
}
