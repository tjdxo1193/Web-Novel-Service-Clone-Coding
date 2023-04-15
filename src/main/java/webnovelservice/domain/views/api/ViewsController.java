package webnovelservice.domain.views.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.jfr.Percentage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webnovelservice.domain.views.application.ViewsReadService;
import webnovelservice.domain.views.application.ViewsWriteService;
import webnovelservice.domain.views.dto.ViewsDto;

@Tag(name = "조회수 API")
@RestController
@RequestMapping("views")
@RequiredArgsConstructor
public class ViewsController {
    final private ViewsWriteService viewsWriteService;
    // 조회 수 -> 해당 소설에 유저 당 조회 수 SUM
    // 조회 수 규칙 또는 정책을 정하는데 있어 애매하지만
    // ID와, 시간제한으로 조회수 증가를 제한 해두려 한다.

    // 파라미터중 VIEW_DATE 와 VIEW_COUNT 를 받지 않은 것은
    // 얼마든지 저 부분을 조작하여 요청 보낼 수 있기에 의미가 없다 생각한다.
    @Operation(summary = "조회 수 증가")
    @PostMapping("/{userId}/{novelId}")
    public ResponseEntity<ViewsDto> addViews(@PathVariable Long userId, @PathVariable Long novelId) {
        return ResponseEntity.ok(viewsWriteService.addViewCount(userId, novelId));
    }
}
