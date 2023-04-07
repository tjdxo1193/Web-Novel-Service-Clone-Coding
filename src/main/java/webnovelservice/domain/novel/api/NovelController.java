package webnovelservice.domain.novel.api;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webnovelservice.domain.novel.application.NovelReadService;
import webnovelservice.domain.novel.application.NovelWriteService;
import webnovelservice.domain.novel.dto.NovelDto;
import webnovelservice.domain.novel.dto.NovelRequestForPaging;
import webnovelservice.domain.novel.dto.RegisterNovelCommand;
import webnovelservice.domain.novel.dto.ResponseNovelDto;

import java.util.List;

@RestController
@RequestMapping("novel")
@RequiredArgsConstructor
public class NovelController {
    final private NovelReadService novelReadService;
    final private NovelWriteService novelWriteService;

    // 소설 1차 등록 , 작가의 이름을 정규화 vs 비정규화 ?
    @Operation(summary = "소설 커버 등록")
    @PostMapping("/")
    public ResponseEntity<ResponseNovelDto> register(@RequestBody RegisterNovelCommand command) {
        var novel = novelWriteService.create(command);
        return ResponseEntity.ok(novelReadService.toDto(novel));
    }

    @Operation(summary = "소설 커버 수정")
    @PostMapping("/{novelId}")
    public ResponseEntity<ResponseNovelDto> update(
            @PathVariable Long novelId,
            NovelDto novelDto
    ) {
        var novel = novelWriteService.update(novelId, novelDto);
        return ResponseEntity.ok(novelReadService.toDto(novel));
    }

    // 소설 목록 전체 조회, 페이징
    @Operation(summary = "소설 커버 삭제")
    @DeleteMapping("/소설 커버 삭제")
    public ResponseEntity<ResponseNovelDto> delete(@RequestBody RegisterNovelCommand command) {
        var novel = novelWriteService.create(command);
        return ResponseEntity.ok(novelReadService.toDto(novel));
    }

    // 일반적인 검색, 작가명, 작품명으로 조회
    @Operation(summary = "소설 목록 조회 - 작가명, 작품명")
    @GetMapping("/novels-by-basic")
    public ResponseEntity<List<ResponseNovelDto>> findByAuthorAndTitle(@RequestBody NovelRequestForPaging params) {
        return ResponseEntity.ok(novelReadService.findByAuthorAndTitle(params));
    }

    // 이달의 화제작 조회

    // 소설

    // 베스트 셀러 소설 -

    // 화제의 신작 소설 -


}
