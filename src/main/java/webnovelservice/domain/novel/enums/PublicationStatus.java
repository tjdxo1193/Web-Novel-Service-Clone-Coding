package webnovelservice.domain.novel.enums;

public enum PublicationStatus {
    SERIALIZED("연재중", "S"),
    COMPLETE("완결", "C"),
    PAUSE("휴재", "P"),
    DEFAULT("미정", "D");
    private final String koreaName;
    private final String abbreviation;

    PublicationStatus(String koreaName, String abbreviation){
        this.koreaName = koreaName;
        this.abbreviation = abbreviation;
    }

    public String getKoreaName(){
        return koreaName;
    }
}
