package com.example.saakshi.mystocks;

import com.google.gson.annotations.SerializedName;

/**
 * Created by saakshi on 10/7/17.
 */

public class Tickers {
@SerializedName("name")
    String companyName;
    @SerializedName("symbol")
    String tinkerName;

    public Tickers(String companyName, String tinkerName) {
        this.companyName = companyName;
        this.tinkerName = tinkerName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTinkerName() {
        return tinkerName;
    }

    public void setTinkerName(String tinkerName) {
        this.tinkerName = tinkerName;
    }
}
