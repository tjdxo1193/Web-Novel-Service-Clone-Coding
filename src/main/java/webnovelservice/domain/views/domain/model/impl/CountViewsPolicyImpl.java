package webnovelservice.domain.views.domain.model.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webnovelservice.domain.views.dao.ViewsDao;
import webnovelservice.domain.views.domain.model.CountViewsPolicy;
import webnovelservice.domain.views.dto.ViewsDto;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CountViewsPolicyImpl implements CountViewsPolicy{

    final private ViewsDao viewsDao;

    @Override
    public ViewsDto execute(ViewsDto viewsDto) {
        // 첫 생성인지 , 아닌지
        // 목록에서 SELECT 쿼리를 날릴때 VIEW_DATE 까지 조회하여 가져 가서 비교할 수는 있으나
        // 프론트는 언제든 조작 가능하여 조회 수가
        // 토이 프로젝트이기에 짧게 정함 - 1
        var views = viewsDto;
        LocalDateTime lastViewDatePlusOneMinute = viewsDto.viewDate().plusMinutes(1);
        boolean isAfterThanLastViewDate = LocalDateTime.now().isAfter(lastViewDatePlusOneMinute);
        if (isAfterThanLastViewDate) {
            viewsDao.plusViewsByOne(viewsDto);
            views = viewsDto.createViewCountPlusOne();
        }

        return views;
    }
}
