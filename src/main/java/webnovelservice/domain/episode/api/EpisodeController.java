package webnovelservice.domain.episode.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webnovelservice.domain.episode.application.EpisodeWriteService;
import webnovelservice.domain.episode.dto.EpisodeDto;

@Tag(name = "에피소드 API")
@RestController
@RequestMapping("episode")
@RequiredArgsConstructor
public class EpisodeController {
    final private EpisodeWriteService episodeWriteService;

    @Operation(summary = "에피소드 등록")
    @PostMapping("/{novelId}/{userId}")
    public ResponseEntity<EpisodeDto> register(@PathVariable Long novelId, @PathVariable Long userId){
        return ResponseEntity.ok(episodeWriteService.createEpisode(novelId, userId));
    }

    @Operation(summary = "에피소드 수정")
    @PutMapping("/{novelId}/{episodeIdx}")
    public ResponseEntity<EpisodeDto> update(@PathVariable Long novelId, @PathVariable Long episodeIdx){
        return ResponseEntity.ok(episodeWriteService.updateEpisode(novelId, episodeIdx));
    }

}
