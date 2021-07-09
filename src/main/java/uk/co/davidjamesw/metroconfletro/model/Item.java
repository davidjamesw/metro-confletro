package uk.co.davidjamesw.metroconfletro.model;

import com.google.gson.JsonObject;

public class Item {

    private JsonObject author;
    private String content;

    public Item(JsonObject author, String content) {
        this.author = author;
        this.content = content;
    }

    public String getAuthor() {
        if (author != null && author.has("name"))
            return author.get("name").getAsString();
        return null;
    }

    public String getContent() {
        return content;
    }
}
