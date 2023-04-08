package webnovelservice.domain.novel.api;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webnovelservice.domain.novel.application.NovelReadService;
import webnovelservice.domain.novel.application.NovelWriteService;
import webnovelservice.domain.novel.dto.NovelDto;
import webnovelservice.domain.novel.dto.NovelRequest;
import webnovelservice.domain.novel.dto.RegisterNovelCommand;
import webnovelservice.domain.novel.dto.ResponseNovelDto;
import webnovelservice.global.common.model.CommonResponse;

import java.util.List;

@RestController
@RequestMapping("novel")
@RequiredArgsConstructor
public class NovelController {
    final private NovelReadService novelReadService;
    final private NovelWriteService novelWriteService;

    // 소설 1차 등록 , 작가의 이름을 정규화 vs 비정규화 ?
    @Operation(summary = "소설 커버 등록")
    @PostMapping("/register")
    public ResponseEntity<ResponseNovelDto> register(@RequestBody RegisterNovelCommand command) {
        var novel = novelWriteService.create(command);
        return ResponseEntity.ok(novelReadService.toDto(novel));
    }

    @Operation(summary = "소설 커버 조회")
    @GetMapping("/{novelId}")
    public ResponseEntity<ResponseNovelDto> findByNovelId(@RequestBody Long novelId) {
        return ResponseEntity.ok(novelReadService.findByNovelId(novelId));
    }
    
    @Operation(summary = "소설 커버 수정")
    @PutMapping("/{novelId}/update")
    public ResponseEntity<ResponseNovelDto> update(
            @PathVariable Long novelId,
            @RequestBody NovelDto novelDto
    ) {

        var novel = novelWriteService.update(novelId, novelDto);
        return ResponseEntity.ok(novelReadService.toDto(novel));
    }

    // 소설 목록 전체 조회, 페이징
    @Operation(summary = "소설 커버 삭제")
    @DeleteMapping("/{novelId}/delete")
    public ResponseEntity<CommonResponse> delete(@PathVariable Long novelId) {
        novelWriteService.delete(novelId);
        return ResponseEntity.ok(new CommonResponse());
    }

    // 일반적인 검색, 작가명, 작품명으로 조회
    @Operation(summary = "소설 목록 조회 - 작가명, 작품명")
    @GetMapping("/novels-by-basic")
    public ResponseEntity<List<ResponseNovelDto>> findByAuthorAndTitle(@RequestBody NovelRequest params) {
        return ResponseEntity.ok(novelReadService.findByAuthorAndTitle(params));
    }

    // 이달의 화제작 조회


    // 소설


    // 베스트 셀러 소설 -


    // 화제의 신작 소설 -


}
