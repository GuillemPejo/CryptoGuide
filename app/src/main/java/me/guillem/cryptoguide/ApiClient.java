package me.guillem.cryptoguide;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * * Created by Guillem on 22/01/21.
 */
public class ApiClient {
    public static String BASE_URL ="https://api.coingecko.com/api/v3/";


    private static Retrofit getRetrofit() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        return retrofit;
    }

    public static JSONPlaceHolderAPI getJSONPlaceHolderAPI(){
            JSONPlaceHolderAPI jsonPlaceHolderAPI = getRetrofit().create(JSONPlaceHolderAPI.class);
            return jsonPlaceHolderAPI;
    }


}