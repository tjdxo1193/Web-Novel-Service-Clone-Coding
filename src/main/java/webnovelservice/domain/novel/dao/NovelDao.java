package webnovelservice.domain.novel.dao;

import org.apache.ibatis.annotations.Mapper;
import webnovelservice.domain.novel.dto.NovelRequest;
import webnovelservice.domain.novel.entity.Novel;

import java.util.List;

@Mapper
public interface NovelDao {

    Novel findByNovelId(Long novelId);
    List<Novel> findByAuthorAndTitle(NovelRequest params);

    void updateNovel(Novel novel);

    void deleteNovel(Long novelId);

    Long saveNovel(Novel novel);
}
