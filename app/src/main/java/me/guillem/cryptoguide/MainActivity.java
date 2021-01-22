package me.guillem.cryptoguide;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static String BASE_URL ="https://api.coingecko.com/api/v3/";

    RecyclerView recyclerView;

    CoinListAdapter coinListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_coinlist);
        getBottomNavigationView();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        coinListAdapter = new CoinListAdapter();
        getCoinList();


    }

    private void getCoinList() {
        Call<List<Coin>> call = ApiClient.getJSONPlaceHolderAPI().getCoins();
        call.enqueue(new Callback<List<Coin>>() {
            @Override
            public void onResponse(Call<List<Coin>> call, Response<List<Coin>> response) {
                if (response.isSuccessful()){
                    List<Coin> coins = response.body();
                    coinListAdapter.setData(coins);
                    recyclerView.setAdapter(coinListAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Coin>> call, Throwable t) {
                //Toast.makeText(, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getBottomNavigationView() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.list:
                        Toast.makeText(MainActivity.this, "Action A", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_B:
                        Toast.makeText(MainActivity.this, "Action B", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_C:
                        Toast.makeText(MainActivity.this, "Action C", Toast.LENGTH_SHORT).show();
                        break;                }
                return true;
            }
        });
    }
}