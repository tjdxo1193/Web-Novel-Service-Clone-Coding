package webnovelservice.domain.novel.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
import webnovelservice.global.util.CursorRequest;
import webnovelservice.global.util.PageCursor;

import java.util.List;
@Tag(name = "소설 API")
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

    @Operation(summary = "소설 커버 조회")
    @GetMapping("/{novelId}")
    public ResponseEntity<ResponseNovelDto> getNovel(@PathVariable Long novelId) {
        return ResponseEntity.ok(novelReadService.getNovel(novelId));
    }

    @Operation(summary = "소설 커버 수정")
    @PutMapping("/{novelId}")
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

    // 일반적인 검색, 작가명, 작품명으로 조회 # 페이징 필요
    @Operation(summary = "소설 목록 조회 - 작가명, 작품명")
    @GetMapping("/novels-by-basic")
    public ResponseEntity<PageCursor<ResponseNovelDto>> getNovels(@RequestBody CursorRequest<NovelRequest> cursorRequest) {
        return ResponseEntity.ok(novelReadService.getNovels(cursorRequest));
    }

    // 이달의 화제작 조회
    @Operation(summary = "이달의 화제작 목록 조회 - TOP 20")
    @GetMapping("/this-month-novel")
    public ResponseEntity<List<ResponseNovelDto>> getThisMonthNovels(@RequestBody NovelRequest params) {
        return ResponseEntity.ok(novelReadService.getThisMonthNovels(params));
    }


    // 베스트 셀러 소설 -
    @Operation(summary = "베스트 셀러 목록 조회 - TOP 20")
    @GetMapping("/best-seller-novel")
    public ResponseEntity<List<ResponseNovelDto>> getBestSellerNovels(@RequestBody NovelRequest params) {
        return ResponseEntity.ok(novelReadService.getBestSellerNovels(params));
    }

    // 일일 조회 베스트 소설 -
    @Operation(summary = "일일 조회 베스트 - TOP 20")
    @GetMapping("/best-daily-view")
    public ResponseEntity<List<ResponseNovelDto>> getBestDailyViewNovels(@RequestBody NovelRequest params) {
        return ResponseEntity.ok(novelReadService.getBestDailyViewNovels(params));
    }

    // 일일 유료 베스트 소설 -
    @Operation(summary = "일일 유료 베스트 - TOP 20")
    @GetMapping("/best-daily-paid")
    public ResponseEntity<List<ResponseNovelDto>> getBestDailyPaidNovels(@RequestBody NovelRequest params) {
        return ResponseEntity.ok(novelReadService.getBestDailyPaidNovels(params));
    }

    // 일일 무료 베스트 소설 -
    @Operation(summary = "일일 무료 베스트 - TOP 20")
    @GetMapping("/best-daily-free")
    public ResponseEntity<List<ResponseNovelDto>> getBestDailyFreeNovels(@RequestBody NovelRequest params) {
        return ResponseEntity.ok(novelReadService.getBestDailyFreeNovels(params));
    }
}
