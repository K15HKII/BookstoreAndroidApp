package k15hkii.se114.bookstore.data.model.api;

import k15hkii.se114.bookstore.data.model.ISubEnum;

import java.util.Locale;

public enum Payment implements ISubEnum {
    CASH("Tiền mặt"), BANK_TRANSFER("Chuyển khoản"), CREDIT_CARD("Thẻ tín dụng"), PAYPAL("Paypal"), BITCOIN("Bitcoin"), WECHAT("Wechat"), ALIPAY("Alipay"), OTHER("Khác"), DEBIT_CARD("Thẻ ghi nợ");

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
