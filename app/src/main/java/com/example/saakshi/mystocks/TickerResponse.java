package com.example.saakshi.mystocks;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

//import in.codingninjas.courses.Course;

/**
 * Created by manishakhattar on 11/07/17.
 */

public class TickerResponse {

@SerializedName("ResultSet")
    public resultSets resultset;
   // public int status;

   public static class resultSets{

        @SerializedName("Result")
        public ArrayList<Tickers> tinkersList;


       public ArrayList<Tickers> getTinkersList() {
           return tinkersList;
       }

       public void setTinkersList(ArrayList<Tickers> tinkersList) {
           this.tinkersList = tinkersList;
       }
   }

}




