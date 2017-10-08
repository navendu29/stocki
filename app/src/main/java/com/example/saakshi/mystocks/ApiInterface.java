package com.example.saakshi.mystocks;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {


    /* @GET("autoc?query=YHOO&region=US&lang=en")*/
//    Call<TinkerResponse> getTinkers(@Path("Query")String query);
    //   Call<TinkerResponse> getTinkers();
//    @GET("autoc")
  //  Call<TickerResponse> getTinkers(@Query("query") String query, @Query("region") String region, @Query("lang") String lang);


    @GET("flight")
    Call<FlightResponse> getFlight();



    //    @GET("yql?q=select+*+from+yahoo.finance.quotes+where+symbol+in+(\"YHOO\")&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback")
//Call<StockResponse> getStocks(@Path("symbol")String symbol);
//@GET("yql?q=select+*+from+yahoo.finance.quotes+where+symbol+in+(\"YHOO\")&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback")
    //retrofit2.Response<StockResponse> getStocks(@Query("q") String q, @Query("format") String format, @Query("env") String env);

   //@GET("yql?format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
    //Call <StockResponse> getStocks(@Query(value = "q", encoded = true) String q);


//    @GET("posts/{post_id}/comments/{comment_id}")
//    Call<PostResponse> getPost(@Path("post_id") int id, @Path("comment_id") int commentId);
//
//    @GET("posts")
//    Call<UserPosts> getUserPosts(@Query("userId") int userId);


//    @GET("users")
//    Call<ArrayList<User>> getUsers();

    /*



    @GET("comments")
    Call<ResponseType> getComments();
     */



/*
    @GET("autoc")
    Call<TickerResponse> getTinkers(@Query("query") String query, @Query("region") String region, @Query("lang") String lang);
*/









}
