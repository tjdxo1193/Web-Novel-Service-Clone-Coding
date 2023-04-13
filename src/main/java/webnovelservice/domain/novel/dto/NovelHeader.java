package webnovelservice.domain.novel.dto;

import webnovelservice.domain.novel.enums.PublicationStatus;

import java.io.File;

public record NovelHeader(
        Long novelId,
        Long userId,
        Integer favoriteCount,
        String genre,
        String author,
        PublicationStatus publicationStatus,
        String description,
        String title,
        File novelCoverImage
) {
}
