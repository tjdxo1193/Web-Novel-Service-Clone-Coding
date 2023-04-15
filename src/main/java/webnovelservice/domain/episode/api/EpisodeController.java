package webnovelservice.domain.episode.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webnovelservice.domain.episode.application.EpisodeReadService;
import webnovelservice.domain.episode.application.EpisodeWriteService;
import webnovelservice.domain.episode.dto.EpisodeCommand;
import webnovelservice.domain.episode.dto.EpisodeDto;

@Tag(name = "에피소드 API")
@RestController
@RequestMapping("episode")
@RequiredArgsConstructor
public class EpisodeController {
    final private EpisodeReadService episodeReadService;
    final private EpisodeWriteService episodeWriteService;

    @Operation(summary = "에피소드 등록")
    @PostMapping("/create")
    public ResponseEntity<EpisodeDto> create(@RequestBody EpisodeCommand command) {
        var episode = episodeWriteService.createEpisode(command);
        return ResponseEntity.ok(episodeReadService.toDto(episode));
    }

    @Operation(summary = "에피소드 수정")
    @PutMapping("/{episodeId}")
    public ResponseEntity<EpisodeDto> update(@PathVariable Long episodeId,@RequestBody EpisodeCommand command){
        var episode = episodeWriteService.updateEpisode(episodeId, command);
        return ResponseEntity.ok(episodeReadService.toDto(episode));
    }

}
