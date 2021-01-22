package me.guillem.cryptoguide;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * * Created by Guillem on 22/01/21.
 */
public class Coin implements Serializable {

        @SerializedName("id")
        private String id;

        @SerializedName("symbol")
        private String symbol;

        @SerializedName("name")
        private String name;


        public Coin(String id, String symbol, String name) {
                this.id = id;
                this.symbol = symbol;
                this.name = name;
        }


        public String getId() {
                return id;
        }

        public String getSymbol() {
                return symbol;
        }

        public String getName() {
                return name;
        }
}
