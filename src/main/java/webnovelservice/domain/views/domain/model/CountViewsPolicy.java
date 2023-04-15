package webnovelservice.domain.views.domain.model;

import webnovelservice.domain.views.dto.ViewsDto;

public interface CountViewsPolicy {
    ViewsDto execute(ViewsDto viewsDto);
}
