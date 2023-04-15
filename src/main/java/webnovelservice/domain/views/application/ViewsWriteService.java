package webnovelservice.domain.views.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webnovelservice.domain.views.dao.ViewsDao;
import webnovelservice.domain.views.domain.model.CountViewsPolicy;
import webnovelservice.domain.views.dto.ViewsDto;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ViewsWriteService {
    final private ViewsDao viewsDao;
    final private CountViewsPolicy countViewsPolicy;
    // 첫 조회일 때
    public ViewsDto addViewCount(Long userId, Long novelId) {
        // 조회 수 정책 - 1. 같은 유저(이미 조회 조건에서 부터 확인됨),
        //              2. 일정 시간 안에 들어 온 요청은 막는다.
        // 정책에 따라서 올릴 것 인지,말 것 인지 정하는 것 뿐 아니라
        // 실제로 올리기 까지 하는 모듈을 실행한다.
        var views =
                Optional.ofNullable(viewsDao.findOneById(userId, novelId))
                .orElseGet(() ->{
                           var newViews = new ViewsDto(
                                    userId,
                                    novelId,
                                    0,
                                    LocalDateTime.now());
                            viewsDao.createViews(newViews);
                            return newViews;
                });

        // 조회수 모듈은 하위 모듈이기 때문에 상위 모듈인
        // 이 클래스에서 의존하지 않게 DIP 설계에 따른다.
        return countViewsPolicy.execute(views);
    }
}
