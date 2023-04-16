package webnovelservice.domain.episode.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webnovelservice.domain.episode.dao.EpisodeDao;
import webnovelservice.domain.episode.dto.EpisodeCommand;
import webnovelservice.domain.episode.dto.EpisodeDto;
import webnovelservice.domain.episode.entity.NovelEpisode;
import webnovelservice.domain.episode.entity.EpisodeInfo;

@Service
@RequiredArgsConstructor
public class EpisodeWriteService {

    final private EpisodeDao episodeDao;

    // TODO 소설의 가격이 각 소설마다 정해져있는지,
    //  또는 소설의 가격이 고정적으로 모두 동일한지의 정책에 따라서 로직이 달라질수 있다.
    // 그러므로 소설가격정책 인터페이스를 두어서 DIP 설계원칙으로 하위 모듈이 상위 모듈을 의존하도록 한다.
//    final private NovelPricePolicy novelPricePolicy;
    final private EpisodeReadService episodeReadService;

    public EpisodeDto createEpisode(EpisodeCommand command) {
        int result = 0;
        var episode = NovelEpisode.builder()
                .novelId(command.novelId())
                .title(command.title())
                .episodeNum(command.episodeNum())
                .content(command.content())
                .build();

        Long episodeId = episodeDao.createEpisode(episode);

        var episodeInfo = EpisodeInfo.builder()
                .episodeId(episode.getEpisodeId())
                .novelId(episode.getNovelId())
                .episodeImage(command.episodeImage())
                .build();

        episodeDao.createEpisodeInfo(episodeInfo);


        // novelPricePolicy.fixedPricePolicy(episode);
        return new EpisodeDto(
                episodeId,
                command.novelId(),
                command.episodeImage(),
                command.title(),
                command.episodeNum(),
                command.content()
        );
    }

    public EpisodeDto updateEpisode(Long episodeId, EpisodeCommand command) {

        var episode = NovelEpisode.builder()
                .episodeId(episodeId)
                .novelId(command.novelId())
                .title(command.title())
                .episodeNum(command.episodeNum())
                .content(command.content())
                .build();

        episodeDao.updateEpisode(episode);

        var episodeInfo = EpisodeInfo.builder()
                .episodeId(episode.getEpisodeId())
                .novelId(episode.getNovelId())
                .episodeImage(command.episodeImage())
                .build();

        episodeDao.updateEpisodeImage(episodeInfo);

        // novelPricePolicy.fixedPricePolicy(episode);
        return new EpisodeDto(
                episodeId,
                command.novelId(),
                command.episodeImage(),
                command.title(),
                command.episodeNum(),
                command.content()
        );
    }

}
