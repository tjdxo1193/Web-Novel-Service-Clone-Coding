package webnovelservice.domain.novel.dao;

import org.apache.ibatis.annotations.Mapper;
import webnovelservice.domain.novel.dto.NovelDto;
import webnovelservice.domain.novel.dto.NovelRequestForPaging;
import webnovelservice.domain.novel.entity.Novel;

import java.util.List;

@Mapper
public interface NovelDao {

    Novel findByNovelId(Long novelId);
    List<Novel> findByAuthorAndTitle(NovelRequestForPaging params);
}
