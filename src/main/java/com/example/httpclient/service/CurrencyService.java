package com.example.httpclient.service;

import com.example.httpclient.domain.currency.BankData;
import com.example.httpclient.domain.currency.Currency;
import com.example.httpclient.domain.currency.CurrencyEnum;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CurrencyService {

    private Random random;
    private List<Currency> currencies;
    private BigDecimal chosenRate;
    private BigDecimal userInput;
    private Currency chosenCurrency;
    private int attempts;
    private int status;

    public CurrencyService() {
        this.currencies = new ArrayList<>();
        random = new Random();
    }

    public String getMessage() {
        CurrencyEnum currencyEnum = chosenCurrency.getCurrencyEnum();

        StringBuilder builder = new StringBuilder();
        builder.append("Wprowadź aktualny kurs ");
        builder.append(currencyEnum);
        builder.append(" (");
        builder.append(currencyEnum.getName());
        builder.append(") uwzględniając dwa miejsca po przecinku");

        return builder.toString();
    }

    public void setupGame(BankData bankData) {
        attempts = 0;
        status = 0;
        initializeCurrencies(bankData);

        int index = random.nextInt(currencies.size());

        chosenCurrency = currencies.get(index);
        chosenRate = BigDecimal.valueOf(currencies.get(index).getRate()).setScale(2, RoundingMode.HALF_UP);
    }

    public void checkInput(String input) {
        if (input.contains(",")) {
            input = input.replace(",", ".");
        }

        userInput = BigDecimal.valueOf(Double.parseDouble(input)).setScale(2, RoundingMode.HALF_UP);
        attempts++;

        if (userInput.compareTo(chosenRate) < 0) {
            status = -1;
        } else if (userInput.compareTo(chosenRate) > 0) {
            status = 1;
        } else {
            status = 0;
        }
    }

    public int getAttempts() {
        return attempts;
    }

    public int getStatus() {
        return status;
    }

    private void initializeCurrencies(BankData bankData) {
        currencies.add(new Currency(bankData.getRate().getCAD(), CurrencyEnum.CAD));
        currencies.add(new Currency(bankData.getRate().getHKD(), CurrencyEnum.HKD));
        currencies.add(new Currency(bankData.getRate().getISK(), CurrencyEnum.ISK));
        currencies.add(new Currency(bankData.getRate().getPHP(), CurrencyEnum.PHP));
        currencies.add(new Currency(bankData.getRate().getDKK(), CurrencyEnum.DKK));
        currencies.add(new Currency(bankData.getRate().getHUF(), CurrencyEnum.HUF));
        currencies.add(new Currency(bankData.getRate().getCZK(), CurrencyEnum.CZK));
        currencies.add(new Currency(bankData.getRate().getGBP(), CurrencyEnum.GBP));
        currencies.add(new Currency(bankData.getRate().getRON(), CurrencyEnum.RON));
        currencies.add(new Currency(bankData.getRate().getSEK(), CurrencyEnum.SEK));
        currencies.add(new Currency(bankData.getRate().getIDR(), CurrencyEnum.IDR));
        currencies.add(new Currency(bankData.getRate().getINR(), CurrencyEnum.INR));
        currencies.add(new Currency(bankData.getRate().getBRL(), CurrencyEnum.BRL));
        currencies.add(new Currency(bankData.getRate().getRUB(), CurrencyEnum.RUB));
        currencies.add(new Currency(bankData.getRate().getHRK(), CurrencyEnum.HRK));
        currencies.add(new Currency(bankData.getRate().getJPY(), CurrencyEnum.JPY));
        currencies.add(new Currency(bankData.getRate().getTHB(), CurrencyEnum.THB));
        currencies.add(new Currency(bankData.getRate().getCHF(), CurrencyEnum.CHF));
        currencies.add(new Currency(bankData.getRate().getEUR(), CurrencyEnum.EUR));
        currencies.add(new Currency(bankData.getRate().getMYR(), CurrencyEnum.MYR));
        currencies.add(new Currency(bankData.getRate().getBGN(), CurrencyEnum.BGN));
        currencies.add(new Currency(bankData.getRate().getTRY(), CurrencyEnum.TRY));
        currencies.add(new Currency(bankData.getRate().getCNY(), CurrencyEnum.CNY));
        currencies.add(new Currency(bankData.getRate().getNOK(), CurrencyEnum.NOK));
        currencies.add(new Currency(bankData.getRate().getNZD(), CurrencyEnum.NZD));
        currencies.add(new Currency(bankData.getRate().getZAR(), CurrencyEnum.ZAR));
        currencies.add(new Currency(bankData.getRate().getUSD(), CurrencyEnum.USD));
        currencies.add(new Currency(bankData.getRate().getMXN(), CurrencyEnum.MXN));
        currencies.add(new Currency(bankData.getRate().getSGD(), CurrencyEnum.SGD));
        currencies.add(new Currency(bankData.getRate().getAUD(), CurrencyEnum.AUD));
        currencies.add(new Currency(bankData.getRate().getILS(), CurrencyEnum.ILS));
        currencies.add(new Currency(bankData.getRate().getKRW(), CurrencyEnum.KRW));
    }
}
