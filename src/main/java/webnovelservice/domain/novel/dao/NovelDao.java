package webnovelservice.domain.novel.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import webnovelservice.domain.novel.dto.NovelRequest;
import webnovelservice.domain.novel.dto.ResponseNovelDto;
import webnovelservice.domain.novel.entity.Novel;

import java.util.List;

@Mapper
public interface NovelDao {
    Novel findByNovelId(Long novelId);
//    List<Novel> findByAuthorAndTitle(NovelRequest params);
    List<Novel> findByMostViews(NovelRequest params);
    List<Novel> findByMostSales(NovelRequest params);
    List<Novel> findByBestDailyView(NovelRequest params);
    List<Novel> findByBestDailyPaid(NovelRequest params);
    List<Novel> findByBestDailyFree(NovelRequest params);
    List<Novel> findByAuthorAndTitle(@Param("novelRequest") NovelRequest t, @Param("key") Long key, @Param("size") int size);
    void updateNovel(Novel novel);
    void deleteNovel(Long novelId);
    Long saveNovel(Novel novel);
}
