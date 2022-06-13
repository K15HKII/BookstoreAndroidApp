package k15hkii.se114.bookstore.data.model.api.book;

import k15hkii.se114.bookstore.data.model.ISubEnum;

import java.util.Locale;

public enum BookTag implements ISubEnum {
    DRAMA("Drama")
    ,COMEDY("Hài kịch")
    ,HORROR("") //TODO:
    ,THRILLER("") //TODO:
    ,ROMANCE("") //TODO:
    ,MYSTERY("") //TODO:
    ,FANTASY("") //TODO:
    ,SCIENCEFICTION("") //TODO:
    ,BIOGRAPHY("") //TODO:
    , SELFHELP("") //TODO:
    ,HEALTH("") //TODO:
    ,HUMOR("") //TODO:
    ,HISTORY("") //TODO:
    ,POETRY("") //TODO:
    ,ESSAY("") //TODO:
    ,MEMOIR("") //TODO:
    ,AUTOBIOGRAPHY("") //TODO:
    ,BUSINESS("") //TODO:
    ,TRAVEL("") //TODO:
    ,JOURNALIST("") //TODO:
    ,ART("") //TODO:
    ,LITERATURE(""); //TODO:

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
