package webnovelservice.domain.user.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import webnovelservice.domain.user.application.UserReadService;
import webnovelservice.domain.user.application.UserWriteService;
import webnovelservice.domain.user.dto.RegisterUserCommand;
import webnovelservice.domain.user.dto.ResponseUserDto;

@Tag(name = "유저정보")
@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserReadService userReadService;
    private final UserWriteService userWriteService;


    @Operation(summary = "유저정보 등록")
    @PostMapping("/")
    public ResponseUserDto register(@RequestBody RegisterUserCommand command) {
        var user = userWriteService.create(command);
        return userReadService.toDto(user);
    }

    @Operation(summary = "유저정보 단건 조회")
    @GetMapping("/{userId}")
    public ResponseUserDto getMember(@PathVariable Long userId) {
        return userReadService.getUser(userId);
    }

}
