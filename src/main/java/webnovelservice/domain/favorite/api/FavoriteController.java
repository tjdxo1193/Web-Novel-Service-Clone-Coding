package webnovelservice.domain.favorite.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webnovelservice.domain.favorite.application.FavoriteReadService;
import webnovelservice.domain.favorite.application.FavoriteWriteService;
import webnovelservice.domain.favorite.usecase.GetNovelFavoriteUsecase;
import webnovelservice.domain.novel.dto.ResponseNovelDto;

import java.util.List;

@Tag(name = "선호작 API")
@RestController
@RequestMapping("favorite")
@RequiredArgsConstructor
public class FavoriteController {

    final private FavoriteReadService favoriteReadService;
    final private FavoriteWriteService favoriteWriteService;
    final private GetNovelFavoriteUsecase getNovelFavoriteUsecase;

    // 내 선호작 추가 -> 유저는 소설 목록에 해당 소설을 클릭하고 들어가서, 선호버튼을 누른다.
    @Operation(summary = "내 선호작 등록")
    @PostMapping("/{userId}/{novelId}")
    public ResponseEntity<Integer> favorite(@PathVariable Long userId, @PathVariable Long novelId) {
        return ResponseEntity.ok(favoriteWriteService.addFavorite(userId, novelId));
    }
    // TODO SoftDelete Vs HardDelete 오라클은 delete 쿼리를 날릴시에 로깅 테이블에 백업 row를 저장해준다.
    //  그러면서 delete 하는데 걸리는 시간이 느릴 텐데 softDelete가 맞는지 모르겠다..
    // 내 선호작 삭제 -> 취소 다시 누름
    @Operation(summary = "내 선호작 삭제(취소)")
    @DeleteMapping("/{userId}/{novelId}")
    public ResponseEntity<Integer> cancel(@PathVariable Long userId, @PathVariable Long novelId) {
        return ResponseEntity.ok(favoriteWriteService.deleteFavorite(userId, novelId));
    }

    // 내 선호작 조회
    @Operation(summary = "내 선호작 조회")
    @GetMapping("/{userId}")
    public ResponseEntity<List<ResponseNovelDto>> getFavoriteNovels(@PathVariable Long userId) {
        return ResponseEntity.ok(getNovelFavoriteUsecase.execute(userId));
    }
}
