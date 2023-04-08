package webnovelservice.domain.novel.enums;

public enum GenreDiv {
    ROMANCE("로맨스"),
    FANTASY("판타지"),
    MARTIAL_ARTS("무협"),
    REASONING("추리"),
    HORROR("공포"),
    THRILLER("스릴러"),
    SF("SF"),
    HISTORY("역사"),
    YOUTH("청춘"),
    DAILY("일상"),
    BL_GL("BL/GL"),
    GAME("게임"),
    ACTION("액션"),
    CULT("컬트"),
    COMEDY("희극"),
    ESSAY("에세이");

    private final String koreaName;
    GenreDiv(String koreaName){
        this.koreaName = koreaName;
    }

    public String getKoreaName(){
        return koreaName;
    }

}
