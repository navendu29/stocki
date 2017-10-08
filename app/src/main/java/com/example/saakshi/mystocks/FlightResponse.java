package com.example.saakshi.mystocks;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by navendu on 8/10/17.
 */

public class FlightResponse {


    @SerializedName("ResultSet")
    public FlightResponse.resultSets resultset;
    // public int status;

    public static class resultSets{

        @SerializedName("Result")
        public ArrayList<flight> FlightList;


        public ArrayList<flight> getFlightList() {
            return FlightList;
        }

        public void setFlightList(ArrayList<flight> FlightList) {
            this.FlightList = FlightList;
        }
    }


}
