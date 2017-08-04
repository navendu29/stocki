package com.example.saakshi.mystocks;

import com.google.gson.annotations.SerializedName;

/**
 * Created by saakshi on 10/7/17.
 */

public class Stocks {

@SerializedName("created")
    String Created;
    @SerializedName("lang")
    String Language;
    @SerializedName("symbol")
    String Symbol;
    String YearLow;
    String YearHigh;

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getYearLow() {
        return YearLow;
    }

    public void setYearLow(String yearLow) {
        YearLow = yearLow;
    }

    public String getCreated() {
        return Created;
    }

    public void setCreated(String created) {
        Created = created;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getYearHigh() {
        return YearHigh;
    }

    public void setYearHigh(String yearHigh) {
        YearHigh = yearHigh;
    }

    //public Stocks(String Created, String Language, String Symbol, String YearLow, String YearHigh)
public Stocks(String Created,String Language,String Symbol, String YearLow, String YearHigh)

{

    this.Created=Created;
    this.Language=Language;
    this.Symbol=Symbol;
    this.YearLow=YearLow;
    this.YearHigh=YearHigh;





}



}
