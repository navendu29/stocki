package com.example.saakshi.mystocks;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by saakshi on 13/7/17.
 */

public class StockResponse {

    public Query query;
    // public int status;

    public static class Query {
    public String created;
        public  String lang;

        public Results results;

        public static class Results implements Serializable {


            @SerializedName("quote")
            public Stocks stock;
            public Stocks getStocks()
            {
                return stock;

            }
           // @SerializedName("quote")
           /* public ArrayList<Stocks> stockList;


            public ArrayList<Stocks> getStockList() {
                return stockList;
            }

            public void setStockList(ArrayList<Stocks> stockList) {
                this.stockList = stockList;
            }
*/
        }
    }
}