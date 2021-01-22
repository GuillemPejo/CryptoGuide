package me.guillem.cryptoguide;

import com.google.gson.annotations.SerializedName;

/**
 * * Created by Guillem on 22/01/21.
 */
public class Image {

    @SerializedName("thumb")
    private String thumb;
    @SerializedName("small")
    private String small;
    @SerializedName("large")
    private String large;

    public Image(String thumb, String small, String large) {
        this.thumb = thumb;
        this.small = small;
        this.large = large;
    }

    public String getThumb() {
        return thumb;
    }

    public String getSmall() {
        return small;
    }

    public String getLarge() {
        return large;
    }
}