package com.hwang.webnovelservice.domain.novel;

import com.hwang.webnovelservice.domain.novel.enums.PublicationStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record Novel(
        Long novelId,
        String title,
        String genre,
        String description,
        LocalDate publicationDate,
        PublicationStatus publicationStatus,
        LocalDateTime createAt
) {
}
