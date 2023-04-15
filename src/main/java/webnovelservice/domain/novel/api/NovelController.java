package webnovelservice.domain.novel.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webnovelservice.domain.novel.application.NovelReadService;
import webnovelservice.domain.novel.application.NovelWriteService;
import webnovelservice.domain.novel.dto.*;
import webnovelservice.domain.novel.usecase.MakeNovelInfoUsecase;
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

    final private MakeNovelInfoUsecase makeNovelInfoUsecase;
    // 소설 1차 등록 , 작가의 이름을 정규화 vs 비정규화 ?
    @Operation(summary = "소설 커버 등록")
    @PostMapping("/")
    public ResponseEntity<ResponseNovelDto> register(@RequestBody RegisterNovelCommand command) {
        var novel = novelWriteService.createNovel(command);
        return ResponseEntity.ok(novelReadService.toDto(novel));
    }

    @Operation(summary = "소설 커버 조회")
    @GetMapping("/{novelId}")
    public ResponseEntity<ResponseNovelDto> getNovel(@PathVariable Long novelId) {
        return ResponseEntity.ok(novelReadService.findByNovelId(novelId));
    }

    @Operation(summary = "소설 커버 수정")
    @PutMapping("/{novelId}")
    public ResponseEntity<ResponseNovelDto> update(
            @PathVariable Long novelId,
            @RequestBody NovelDto novelDto
    ) {

        var novel = novelWriteService.updateNovel(novelId, novelDto);
        return ResponseEntity.ok(novelReadService.toDto(novel));
    }

    // 소설 목록 전체 조회, 페이징
    @Operation(summary = "소설 커버 삭제")
    @DeleteMapping("/{novelId}/delete")
    public ResponseEntity<CommonResponse> delete(@PathVariable Long novelId) {
        novelWriteService.deleteNovel(novelId);
        return ResponseEntity.ok(new CommonResponse());
    }

    // 일반적인 검색, 작가명, 작품명으로 조회 # 페이징 필요
    @Operation(summary = "소설 목록 조회 - 작가명, 작품명")
    @GetMapping("/novels-by-basic")
    public ResponseEntity<PageCursor<ResponseNovelDto>> getNovels(@RequestBody CursorRequest<NovelRequest> cursorRequest) {
        return ResponseEntity.ok(novelReadService.findByAuthorAndTitle(cursorRequest));
    }

    // 이달의 화제작 조회
    @Operation(summary = "이달의 화제작 목록 조회 - TOP 20")
    @GetMapping("/this-month-novel")
    public ResponseEntity<List<ResponseNovelDto>> getThisMonthNovels(@RequestBody NovelRequest params) {
        return ResponseEntity.ok(novelReadService.findByMostViews(params));
    }


    // 베스트 셀러 소설 -
    @Operation(summary = "베스트 셀러 목록 조회 - TOP 20")
    @GetMapping("/best-seller-novel")
    public ResponseEntity<List<ResponseNovelDto>> getBestSellerNovels(@RequestBody NovelRequest params) {
        return ResponseEntity.ok(novelReadService.findByMostSales(params));
    }

    // 일일 조회 베스트 소설 -
    @Operation(summary = "일일 조회 베스트 - TOP 20")
    @GetMapping("/best-daily-view")
    public ResponseEntity<List<ResponseNovelDto>> getBestDailyViewNovels(@RequestBody NovelRequest params) {
        return ResponseEntity.ok(novelReadService.findByBestDailyView(params));
    }

    // 일일 유료 베스트 소설 -
    @Operation(summary = "일일 유료 베스트 - TOP 20")
    @GetMapping("/best-daily-paid")
    public ResponseEntity<List<ResponseNovelDto>> getBestDailyPaidNovels(@RequestBody NovelRequest params) {
        return ResponseEntity.ok(novelReadService.findByBestDailyPaid(params));
    }

    // 일일 무료 베스트 소설 -
    @Operation(summary = "일일 무료 베스트 - TOP 20")
    @GetMapping("/best-daily-free")
    public ResponseEntity<List<ResponseNovelDto>> getBestDailyFreeNovels(@RequestBody NovelRequest params) {
        return ResponseEntity.ok(novelReadService.findByBestDailyFree(params));
    }

    @Operation(summary = "소설 상세 정보")
    @GetMapping("/list/{novelId}/{userId}")
    public ResponseEntity<NovelDetailDto> getNovelAndEpisodeDetail(@PathVariable Long novelId, @PathVariable Long userId){
        return ResponseEntity.ok(makeNovelInfoUsecase.fetchNovelDetail(novelId, userId));
    }
}
