package k15hkii.se114.bookstore.data.model.api;

import k15hkii.se114.bookstore.data.model.ISubEnum;

import java.util.Locale;

public enum Payment implements ISubEnum {
    CASH("Tiền mặt")
    ,BANK_TRANSFER("") //TODO:
    ,CREDIT_CARD("") //TODO:
    ,PAYPAL("") //TODO:
    ,BITCOIN("") //TODO:
    ,WECHAT("") //TODO:
    ,ALIPAY("") //TODO:
    ,WALLET("") //TODO:
    ,OTHER("") //TODO:
    ,DEBIT_CARD(""); //TODO:

    private final String sub;

    Payment(String sub) {
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
