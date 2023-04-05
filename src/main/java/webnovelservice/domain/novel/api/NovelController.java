package webnovelservice.domain.novel.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webnovelservice.domain.novel.application.NovelReadService;
import webnovelservice.domain.novel.application.NovelWriteService;

@RestController
@RequestMapping("novel")
@RequiredArgsConstructor
public class NovelController {
    final private NovelReadService novelReadService;
    final private NovelWriteService novelWriteService;

}
