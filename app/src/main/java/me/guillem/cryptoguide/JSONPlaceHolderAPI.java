package me.guillem.cryptoguide;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * * Created by Guillem on 22/01/21.
 */
public interface JSONPlaceHolderAPI {

    @GET("coins/list")
    Call<List<Coin>> getCoins();
}
