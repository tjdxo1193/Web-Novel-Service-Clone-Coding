package webnovelservice.domain.novel.enums;

public enum GenreDiv {
    ROMANCE("로맨스" , "romance"),
    FANTASY("판타지" , "fantasy"),
    MARTIAL_ARTS("무협" , "martialArts"),
    REASONING("추리" , "reasoning"),
    HORROR("공포" , "horror"),
    THRILLER("스릴러" , "thriller"),
    SF("SF" , "sf"),
    HISTORY("역사" , "history"),
    YOUTH("청춘" , "youth"),
    DAILY("일상" , "daily"),
    BL_GL("BL/GL" , "blgl"),
    GAME("게임" , "game"),
    ACTION("액션" , "action"),
    CULT("컬트" , "cult"),
    COMEDY("희극" , "comedy"),
    ESSAY("에세이" , "essay"),
    NONE("없음", "none");

    private final String koreaName;
    private final String englishName;

    GenreDiv(String koreaName, String englishName){
        this.koreaName = koreaName;
        this.englishName = englishName;
    }

    public String getKoreaName(){
        return koreaName;
    }


}
