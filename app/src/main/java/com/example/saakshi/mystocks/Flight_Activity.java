package com.example.saakshi.mystocks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by navendu on 8/10/17.
 */

public class Flight_Activity extends AppCompatActivity {
    /*ArrayList<Stocks> stockNames;
  ArrayList<Stocks> stocks;*/
    ArrayList<flight> flightNames;
    ArrayList<flight> flight;
    FlightListAdapter FlightListAdapter;

    String y;
    String str = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight);
        flightNames = new ArrayList<>();
        flight = new ArrayList<>();
/*
        stocks = new ArrayList<>();*/
        ListView ll = (ListView) findViewById(R.id.ll);
  /*      stockNames = new ArrayList<>();*/
        Intent i = getIntent();
        String word = i.getStringExtra("search");
        FlightListAdapter = new FlightListAdapter( this , flight);
        ll.setAdapter(FlightListAdapter);
        flight(word);
/*
        ll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent j = new Intent(Flight_Activity.this, Stocks_Activity.class);
                j.putExtra("flight", flight.get(i).fid);
                startActivity(j);
            }
        });*/
    }

    private void flight(String word) {


//        String urlString = "https://stocksearchapi.com/api/?api_key=63951d6323a8ca82611e86c1a36706c6c47dc01b&format=api&search_text=" + word;


        //1st Method
/*        String urlString = "http://autoc.finance.yahoo.com/autoc?query="+word+"&region=US&lang=en";

        TinkerAsyncTask tinkerAsyncTask = new TinkerAsyncTask();
        tinkerAsyncTask.execute(urlString);
        tinkerAsyncTask.setOnDownloadCompleteListener(this);
*/


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ab9416fb.ngrok.io/customer/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
//        Call<TinkerResponse> call  =  apiInterface.getTinkers(word);
        Call<FlightResponse> call = apiInterface.getFlight();

        // apiInterface.getPost(1, 3);

        call.enqueue(new Callback<FlightResponse>() {
            @Override
            public void onResponse(Call<FlightResponse> call, Response<FlightResponse> response) {
                FlightResponse flightResponse = response.body();
                ArrayList<flight> flightArrayList = flightResponse.resultset.getFlightList();
                onDownloadComplete(flightArrayList);


            }

            @Override
            public void onFailure(Call<FlightResponse> call, Throwable t) {

            }
        });


    }

   /* private void info(ArrayList<Tickers> tinkers) {
        //Log.i("check", "1");
        int i;
        for (i = 0; i < tinkers.size() - 1; i++) {
            //  Log.i("check", "2");
            str += "\"" + tinkers.get(i).tinkerName + "\"" + "%2C";
        }
        str += "\"" + tinkers.get(i).tinkerName + "\"";


        //1st ,method
     *//*   String urlString = "https://query.yahooapis.com/v1/public/yql?q=select+*+from+yahoo.finance.quotes+where+symbol+in(" + str + ")&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback";
        StockAsynTask stockAsyncTask = new StockAsynTask();
        stockAsyncTask.execute(urlString);
        stockAsyncTask.setOnDownloadCompleteListener2(this);
*//*

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://query.yahooapis.com/v1/public/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        String url = "select+*+from+yahoo.finance.quotes+where+symbol+in+(" + str + ")";
        Call<StockResponse> call = apiInterface.getStocks(url);
//        Call<StockResponse> call  =  apiInterface.getStocks(str);

        // apiInterface.getPost(1, 3);

        // String urlFromCall = call.request().url().toString();

        call.enqueue(new Callback<StockResponse>() {
            @Override
            public void onResponse(Call<StockResponse> call, Response<StockResponse> response) {
                if (response.isSuccessful()) {
                    StockResponse stockResponse = response.body();
                    ArrayList<Stocks> stockArrayList = stockResponse.query.results.getStockList();
                    onDownloadComplete2(stockArrayList);
                }
            }

            @Override
            public void onFailure(Call<StockResponse> call, Throwable t) {

            }
        });


    }

    public void onDownloadComplete2(ArrayList<Stocks> stockList) {
        stockNames.clear();
        stockNames.addAll(stockList);

        for (int i = 0; i < stockNames.size(); i++) {
            Stocks c = new Stocks(stockNames.get(i).Symbol, stockNames.get(i).YearLow, stockNames.get(i).YearHigh);
//            Stocks c = new Stocks(stockNames.get(i).Created, stockNames.get(i).Language, stockNames.get(i).Symbol, stockNames.get(i).YearLow, stockNames.get(i).YearHigh);

            stocks.add(c);
        }
        expenseListAdapter.notifyDataSetChanged();

    }*/

    public void onDownloadComplete(ArrayList<flight> FlightList) {
        flightNames.clear();
        flightNames.addAll(FlightList);
        //  y = tinkerNames.get(0).tinkerName;
        for (int i = 0; i < flightNames.size(); i++) {
            flight c = new flight(flightNames.get(i).id,flightNames.get(i).fid, flightNames.get(i).source,flightNames.get(i).destination,flightNames.get(i).stime,flightNames.get(i).dtime);

            flight.add(c);
        }

        FlightListAdapter.notifyDataSetChanged();

        // info(tinkers);
        //  expenseListAdapter.notifyDataSetChanged();

    }

    public boolean onCreateOptionsMenu(Menu menu) {




        /*   MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.search);
        android.support.v7.widget.SearchView searchview = (android.support.v7.widget.SearchView) item.getActionView();
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                //  expenseListAdapter.getFilter.filter(newText);
                expenseListAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
*/
        return super.onCreateOptionsMenu(menu);
    }
}
