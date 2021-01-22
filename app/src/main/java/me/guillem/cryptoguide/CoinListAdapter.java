package me.guillem.cryptoguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * * Created by Guillem on 22/01/21.
 */
public class CoinListAdapter extends RecyclerView.Adapter<CoinListAdapter.CoinListAdapterVH> {

    private List<Coin> coinList;
    private Context context;

    public CoinListAdapter() {
    }

    public void setData(List<Coin> coinList) {
        this.coinList = coinList;
    }


    @NonNull
    @Override
    public CoinListAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_coin_list, parent, false);
        return new CoinListAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoinListAdapterVH holder, int position) {
        Coin coin = coinList.get(position);

        String name = coin.getName();
        String symbol = (coin.getSymbol()).toUpperCase();

        holder.name.setText(name);
        holder.symbol.setText(symbol);
    }

    @Override
    public int getItemCount() {
        return coinList.size();
    }

    public class CoinListAdapterVH extends RecyclerView.ViewHolder {
        TextView name, symbol;

        public CoinListAdapterVH(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.coin_name);
            symbol = itemView.findViewById(R.id.coin_symbol);
        }
    }
}
