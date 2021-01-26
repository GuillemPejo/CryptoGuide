package me.guillem.cryptoguide;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoinDetail extends AppCompatActivity {

    TextView name, symbol, category, description;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_detail);

        name = findViewById(R.id.name);
        symbol = findViewById(R.id.symbol);
        category = findViewById(R.id.category);
        description = findViewById(R.id.description);
        image = findViewById(R.id.image);

        getIdItemClicked();
        getCoinList();

    }
    private String getIdItemClicked() {
        String id = null;

        Intent intent = getIntent();
        if (intent.getExtras() != null){
            id = intent.getStringExtra("id");
            Toast.makeText(CoinDetail.this, id, Toast.LENGTH_SHORT).show();
        }
            return id;
    }

    private void getCoinList() {
        Call<CoinExtended> call = ApiClient.getJSONPlaceHolderAPI().getDetailedCoin(getIdItemClicked());
        call.enqueue(new Callback<CoinExtended>() {
            @Override
            public void onResponse(Call<CoinExtended> call, Response<CoinExtended> response) {
                if (response.isSuccessful()){
                    CoinExtended coin = response.body();

                    name.setText(coin.getName());
                    symbol.setText(coin.getSymbol());
                    category.setText(coin.getCategory().toString());
                    description.setText(coin.getDescription().get("es"));
                    Picasso.get().load(coin.getImage().getSmall()).into(image);

                    //coinListAdapter.setData(coins);
                    //recyclerView.setAdapter(coinListAdapter);
                }

            }

            @Override
            public void onFailure(Call<CoinExtended> call, Throwable t) {
                Log.e("CRP","FALLA");
                Log.e("CRP","FALLA PERQUE: "+t.getLocalizedMessage());
                Log.e("CRP","FALLA PERQUE: "+t.getCause());
                Log.e("CRP","FALLA PERQUE: "+t.getMessage());




                Toast.makeText(CoinDetail.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
