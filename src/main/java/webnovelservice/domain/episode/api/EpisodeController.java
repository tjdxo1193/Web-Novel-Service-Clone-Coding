package webnovelservice.domain.episode.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webnovelservice.domain.episode.application.EpisodeReadService;
import webnovelservice.domain.episode.application.EpisodeWriteService;
import webnovelservice.domain.episode.domain.bookmark.dto.LastReadDto;
import webnovelservice.domain.episode.domain.bookmark.usecase.CreateBookMarkUsecase;
import webnovelservice.domain.episode.dto.EpisodeCommand;
import webnovelservice.domain.episode.dto.EpisodeDto;

@Tag(name = "에피소드 API")
@RestController
@RequestMapping("episode")
@RequiredArgsConstructor
public class EpisodeController {
    final private EpisodeReadService episodeReadService;
    final private EpisodeWriteService episodeWriteService;

    final private CreateBookMarkUsecase createBookMarkUsecase;

    @Operation(summary = "에피소드 등록")
    @PostMapping("/create")
    public ResponseEntity<EpisodeDto> create(@RequestBody EpisodeCommand command) {
        return ResponseEntity.ok(episodeWriteService.createEpisode(command));
    }

    @Operation(summary = "에피소드 수정")
    @PutMapping("/{episodeId}")
    public ResponseEntity<EpisodeDto> update(@PathVariable Long episodeId, @RequestBody EpisodeCommand command) {
        return ResponseEntity.ok(episodeWriteService.updateEpisode(episodeId, command));
    }

    // 에피소드를 읽을 때 해당 에피소드에서 다른 화면으로 나가면 그때 북마크가 insert 또는 update 된다.
    @Operation(summary = "북마크 추가")
    @PostMapping("/book-mark")
    public ResponseEntity<Integer> addBookMark(@RequestBody LastReadDto lastReadDto) {
        return ResponseEntity.ok(createBookMarkUsecase.createBookMark(lastReadDto));
    }
}
