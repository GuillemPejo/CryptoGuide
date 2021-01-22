package me.guillem.cryptoguide;


import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class CoinExtended {

    @SerializedName("id")
    private String id;

    @SerializedName("symbol")
    private String symbol;

    @SerializedName("name")
    private String name;

    @SerializedName("categories")//0
    private List<Object> category;

    @SerializedName("description") //2
    private Map<String, String> description;

    @SerializedName("image")// 0
    private Image image;

    public CoinExtended(String id, String symbol, String name, List<Object> category, Map<String, String> description, Image image) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.category = category;
        this.description = description;
        this.image = image;
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

    public List<Object> getCategory() {
        return category;
    }

    public Map<String, String> getDescription() {
        return description;
    }

    public Image getImage() {
        return image;
    }
}