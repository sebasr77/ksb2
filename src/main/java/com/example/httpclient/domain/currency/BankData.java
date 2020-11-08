package com.example.httpclient.domain.currency;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "rates",
        "base",
        "date"
})
public class BankData {

    @JsonProperty("rates")
    private CurrentExchangeRate currentExchangeRate;
    @JsonProperty("base")
    private String base;
    @JsonProperty("date")
    private String date;

    @JsonProperty("rates")
    public CurrentExchangeRate getRate() {
        return currentExchangeRate;
    }

    @JsonProperty("rates")
    public void setRate(CurrentExchangeRate currentExchangeRate) {
        this.currentExchangeRate = currentExchangeRate;
    }

    @JsonProperty("base")
    public String getBase() {
        return base;
    }

    @JsonProperty("base")
    public void setBase(String base) {
        this.base = base;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }
}
