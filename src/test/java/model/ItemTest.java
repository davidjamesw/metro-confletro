package model;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uk.co.davidjamesw.metroconfletro.model.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ItemTest {

    private String json =
            "{" +
                "\"author\": {" +
                    "\"name\": \"Joe Bloggs\", " +
                    "\"email\": \"joe@bloggs.com\"" +
                "}, " +
                "\"content\": \"Some retro content\"" +
            "}";

    @Test
    void item_givenItemJson_returnsOnlyAuthorNameForAuthor() {
        Item item = getItemFromJson(getFullyPopulatedItem());
        assertEquals("Joe Bloggs", item.getAuthor());
    }

    @Test
    void item_givenItemJsonWithContent_returnsContent() {
        Item item = getItemFromJson(getFullyPopulatedItem());
        assertEquals("Some retro content", item.getContent());
    }

    @Test
    void item_givenItemWithNoContent_givesNullContent() {
        Item item = getItemFromJson(getItemWithNoContent());
        assertNull(item.getContent());
    }

    @Test
    void item_givenItemWithNoAuthor_givesNullAuthor() {
        Item item = getItemFromJson(getItemWithNoAuthor());
        assertNull(item.getAuthor());
    }

    @Test
    void item_givenItemWithNoAuthorName_givesNullAuthor() {
        Item item = getItemFromJson(getItemWithNoAuthorName());
        assertNull(item.getAuthor());
    }

    private Item getItemFromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Item.class);
    }

    private String getFullyPopulatedItem() {
        return "{" +
                    "\"author\": {" +
                        "\"name\": \"Joe Bloggs\", " +
                        "\"email\": \"joe@bloggs.com\"" +
                    "}, " +
                    "\"content\": \"Some retro content\"" +
                "}";
    }

    private String getItemWithNoContent() {
        return "{" +
                    "\"author\": {" +
                        "\"name\": \"Joe Bloggs\", " +
                        "\"email\": \"joe@bloggs.com\"" +
                    "}" +
                "}";
    }

    private String getItemWithNoAuthor() {
        return "{\"content\": \"Some retro content\"}";
    }

    private String getItemWithNoAuthorName() {
        return "{" +
                    "\"author\": {" +
                        "\"email\": \"joe@bloggs.com\"" +
                    "}, " +
                    "\"content\": \"Some retro content\"" +
                "}";
    }
}
