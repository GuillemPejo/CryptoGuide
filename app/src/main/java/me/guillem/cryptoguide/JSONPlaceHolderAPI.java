package me.guillem.cryptoguide;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * * Created by Guillem on 22/01/21.
 */
public interface JSONPlaceHolderAPI {


    @GET("coins/{id}?localization=true&tickers=false&market_data=true&community_data=false&developer_data=false&sparkline=false")
    Call<CoinExtended> getDetailedCoin(@Path("id") String id);


    @GET("coins/list")
    Call<List<Coin>> getCoins();

}
