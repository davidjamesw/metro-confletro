package uk.co.davidjamesw.metroconfletro.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Retro {

    @SerializedName("Liked")
    private List<Item> liked;
    @SerializedName("Learned")
    private List<Item> learned;
    @SerializedName("Longed For")
    private List<Item> longedFor;
    @SerializedName("Lacked")
    private List<Item> lacked;
    @SerializedName("Actions")
    private List<Item> actions;

    public Retro(List<Item> liked,
                 List<Item> learned,
                 List<Item> longedFor,
                 List<Item> lacked,
                 List<Item> actions) {
        this.liked = liked;
        this.learned = learned;
        this.longedFor = longedFor;
        this.lacked = lacked;
        this.actions = actions;
    }

    public List<Item> getLiked() {
        return liked;
    }

    public List<Item> getLearned() {
        return learned;
    }

    public List<Item> getLongedFor() {
        return longedFor;
    }

    public List<Item> getLacked() {
        return lacked;
    }

    public List<Item> getActions() {
        return actions;
    }
}
