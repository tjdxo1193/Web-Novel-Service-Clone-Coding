package webnovelservice.domain.novel.enums;

public enum PublicationStatus {
    SERIALIZED("연재중"),
    COMPLETE("완결"),
    PAUSE("휴재"),
    DEFAULT("미정");
    private final String koreaName;
    PublicationStatus(String koreaName){
        this.koreaName = koreaName;
    }

    public String getKoreaName(){
        return koreaName;
    }
}
