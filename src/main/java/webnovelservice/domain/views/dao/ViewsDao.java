package webnovelservice.domain.views.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import webnovelservice.domain.views.dto.ViewsDto;

import java.time.LocalDateTime;
import java.util.Optional;

@Mapper
public interface ViewsDao {

    Integer createViews(ViewsDto viewsDto);
    Integer plusViewsByOne(ViewsDto viewsDto);
    ViewsDto findOneById(@Param("userId") Long userId, @Param("novelId") Long novelId);
}
