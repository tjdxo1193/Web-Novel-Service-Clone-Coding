package webnovelservice.domain.novel.dto;

import lombok.Getter;
import webnovelservice.domain.episode.dto.EpisodeDetail;

import java.util.ArrayList;
import java.util.List;

@Getter
public class NovelDetailDto {
    // 에피소드 LIst -> 에피소드에 대한 정보 리스트
    // 소설 정보
    // 조회수, 선호수 + 그에 대한 사용자 여부
    private List<EpisodeDetail> episodeDetails = new ArrayList<>();
    private NovelHeader novelHeader;
}
