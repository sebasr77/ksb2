package com.example.httpclient.domain.currency;

public enum CurrencyEnum {
    CAD("Dolar kanadyjski"),
    HKD("Dolar hongkongu"),
    ISK("Korona islandzka"),
    PHP("Peso filipińskie"),
    DKK("Korona duńska"),
    HUF("Forint węgierski"),
    CZK("Korona czeska"),
    GBP("Funt brytyjski"),
    RON("Lej rumuński"),
    SEK("Korona szwedzka"),
    IDR("Rupia indonezyjska"),
    INR("Rupia indyjska"),
    BRL("Real brazylijski"),
    RUB("Rubel rosyjski"),
    HRK("Kuna chorwacka"),
    JPY("Jen japoński"),
    THB("Bat tajlandzki"),
    CHF("Frank szwajcarski"),
    EUR("Euro"),
    MYR("Rinngit malezyjski"),
    BGN("Lew bułgarski"),
    TRY("Lira turecka"),
    CNY("Juan chiński"),
    NOK("Korona norweska"),
    NZD("Dolar nowozelandzki"),
    ZAR("Rand południowoafrykański"),
    USD("Dolar amerykański"),
    MXN("Peso meksykańskie"),
    SGD("Dolar singapurski"),
    AUD("Dolar australijski"),
    ILS("Szekel izraelski"),
    KRW("Won południowokoreański");

    private String name;

    CurrencyEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
