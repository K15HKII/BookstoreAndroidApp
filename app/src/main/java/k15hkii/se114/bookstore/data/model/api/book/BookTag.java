package k15hkii.se114.bookstore.data.model.api.book;

import k15hkii.se114.bookstore.data.model.ISubEnum;

import java.util.Locale;

public enum BookTag implements ISubEnum {
    DRAMA("Drama")
    ,COMEDY("Hài kịch")
    ,HORROR("Kinh dị")
    ,THRILLER("Giật gân")
    ,ROMANCE("Lãng mạn")
    ,MYSTERY("Thần bí")
    ,FANTASY("Huyền ảo")
    ,SCIENCEFICTION("Khoa học viễn tưởng")
    ,BIOGRAPHY("Sinh học")
    , SELFHELP("Tự lực")
    ,HEALTH("Sức khỏe")
    ,HUMOR("Hài hước")
    ,HISTORY("Lịch sử")
    ,POETRY("Thơ")
    ,ESSAY("Luận văn")
    ,MEMOIR("Hồi kí")
    ,AUTOBIOGRAPHY("Tự truyện")
    ,BUSINESS("Kinh doanh")
    ,TRAVEL("Du lịch")
    ,JOURNALIST("Nhà báo")
    ,ART("Hội họa")
    ,LITERATURE("Văn học");

    private final String sub;

    BookTag(String sub) {
        this.sub = sub;
    }

    @Override
    public String toDefaultLocale() {
        return sub;
    }

    @Override
    public String toLocale(Locale locale) {
        return sub;
    }
}
