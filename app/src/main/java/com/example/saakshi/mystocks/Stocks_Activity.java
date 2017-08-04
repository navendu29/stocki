package com.example.saakshi.mystocks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Stocks_Activity extends AppCompatActivity {

    ArrayList<Stocks> stockNames;
    ArrayList<Stocks> stocks;
    /*   ArrayList<Tickers> tinkerNames;
       ArrayList<Tickers> tinkers;
    */ ExpenseListAdapter expenseListAdapter;

    String y;
    String str = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stocks_);
       /* tinkerNames = new ArrayList<>();
        tinkers = new ArrayList<>();
*/
        Intent i = getIntent();
        String tickername = i.getStringExtra("ticker");

        stocks = new ArrayList<>();
        ListView ll2 = (ListView) findViewById(R.id.ll2);
        stockNames = new ArrayList<>();
      /*  Intent i = getIntent();
        String word = i.getStringExtra("search");
      */
        expenseListAdapter = new ExpenseListAdapter(this, stocks);
        ll2.setAdapter(expenseListAdapter);
/*
        tinkers(word);
*/
        info(tickername);

    }
/*

    private void tinkers(String word) {


//        String urlString = "https://stocksearchapi.com/api/?api_key=63951d6323a8ca82611e86c1a36706c6c47dc01b&format=api&search_text=" + word;


        //1st Method
*/
/*        String urlString = "http://autoc.finance.yahoo.com/autoc?query="+word+"&region=US&lang=en";

        TinkerAsyncTask tinkerAsyncTask = new TinkerAsyncTask();
        tinkerAsyncTask.execute(urlString);
        tinkerAsyncTask.setOnDownloadCompleteListener(this);
*//*



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://autoc.finance.yahoo.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
//        Call<TinkerResponse> call  =  apiInterface.getTinkers(word);
        Call<TickerResponse> call = apiInterface.getTinkers(word, "US", "en");

        // apiInterface.getPost(1, 3);

        call.enqueue(new Callback<TickerResponse>() {
            @Override
            public void onResponse(Call<TickerResponse> call, Response<TickerResponse> response) {
                TickerResponse tinkerResponse = response.body();
                ArrayList<Tickers> tinkerArrayList = tinkerResponse.resultset.getTinkersList();
                onDownloadComplete(tinkerArrayList);
            }

            @Override
            public void onFailure(Call<TickerResponse> call, Throwable t) {

            }
        });


    }
*/

    private void info(String word) {
        //Log.i("check", "1");
     /*   int i;
        for (i = 0; i < tinkers.size() - 1; i++) {
            //  Log.i("check", "2");
            str += "\"" + tinkers.get(i).tinkerName + "\"" + "%2C";
        }*/
        str = "\"" + word + "\"";


        //1st ,method
     /*   String urlString = "https://query.yahooapis.com/v1/public/yql?q=select+*+from+yahoo.finance.quotes+where+symbol+in(" + str + ")&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback";
        StockAsynTask stockAsyncTask = new StockAsynTask();
        stockAsyncTask.execute(urlString);
        stockAsyncTask.setOnDownloadCompleteListener2(this);
*/

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
                    //ArrayList<Stocks> stockArrayList = stockResponse.query.results.getStockList();
                    //onDownloadComplete2(stockArrayList);
                    String created=stockResponse.query.created;
                    String lang=stockResponse.query.lang;
                    Stocks stocks = stockResponse.query.results.getStocks();
                    onDownloadComplete2(stocks,created,lang);

                }
            }

            @Override
            public void onFailure(Call<StockResponse> call, Throwable t) {

            }
        });


    }

   /* public void onDownloadComplete2(ArrayList<Stocks> stockList) {
        stockNames.clear();
        stockNames.addAll(stockList);

        for (int i = 0; i < stockNames.size(); i++) {
            Stocks c = new Stocks(stockNames.get(i).Symbol, stockNames.get(i).YearLow, stockNames.get(i).YearHigh);
//            Stocks c = new Stocks(stockNames.get(i).Created, stockNames.get(i).Language, stockNames.get(i).Symbol, stockNames.get(i).YearLow, stockNames.get(i).YearHigh);

            stocks.add(c);
        }
        expenseListAdapter.notifyDataSetChanged();

    }*/

    public void onDownloadComplete2(Stocks stock,String created,String lang) {
        //stockNames.clear();
        //stockNames.addAll(stockList);

        //for (int i = 0; i < stockNames.size(); i++) {
        Stocks c = new Stocks(created,lang,stock.Symbol, stock.YearLow, stock.YearHigh);
//            Stocks c = new Stocks(stockNames.get(i).Created, stockNames.get(i).Language, stockNames.get(i).Symbol, stockNames.get(i).YearLow, stockNames.get(i).YearHigh);

        stocks.add(c);

        expenseListAdapter.notifyDataSetChanged();
    }
   /* public void onDownloadComplete(ArrayList<Tickers> tinkerList) {
        tinkerNames.clear();
        tinkerNames.addAll(tinkerList);
        //  y = tinkerNames.get(0).tinkerName;
        for (int i = 0; i < tinkerNames.size(); i++) {
            Tickers c = new Tickers(tinkerNames.get(i).companyName, tinkerNames.get(i).tinkerName);

            tinkers.add(c);
        }

        info(tinkers);
        //  expenseListAdapter.notifyDataSetChanged();

    }

    public boolean onCreateOptionsMenu(Menu menu) {




        *//*   MenuInflater inflater = getMenuInflater();
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
*//*
        return super.onCreateOptionsMenu(menu);
    }*/

}
