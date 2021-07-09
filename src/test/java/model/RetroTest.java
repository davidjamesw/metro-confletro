package model;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import uk.co.davidjamesw.metroconfletro.model.Retro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class RetroTest {
    private static Retro retroFromSampleJson;

    @BeforeAll
    static void setup() throws IOException {
        String sampleJsonString = Files.readString(Path.of("src/test/resources/sample.json"));
        Gson gson = new Gson();
        retroFromSampleJson = gson.fromJson(sampleJsonString, Retro.class);
    }

    @Test
    void retro_whenConvertedFromJson_hasPopulatedLackedList() {
        assertEquals(4, retroFromSampleJson.getLacked().size());
    }

    @Test
    void retro_whenConvertedFromJson_hasPopulatedLikedList() {
        assertEquals(7, retroFromSampleJson.getLiked().size());
    }

    @Test
    void retro_whenConvertedFromJson_hasPopulatedLongedForList() {
        assertEquals(4, retroFromSampleJson.getLongedFor().size());
    }

    @Test
    void retro_whenConvertedFromJson_hasPopulatedLearnedList() {
        assertEquals(3, retroFromSampleJson.getLearned().size());
    }

    @Test
    void retro_whenConvertedFromJson_hasPopulatedActionsList() {
        assertEquals(2, retroFromSampleJson.getActions().size());
    }

    @Test
    void retro_missingSection_isNullAndDoesNotCauseError() throws IOException {
        String sampleJsonString = Files.readString(Path.of("src/test/resources/sampleWithoutLearned.json"));
        Gson gson = new Gson();
        Retro retro = gson.fromJson(sampleJsonString, Retro.class);

        assertNull(retro.getLearned());
        assertNotNull(retro.getLiked());
        assertNotNull(retro.getLongedFor());
        assertNotNull(retro.getLacked());
        assertNotNull(retro.getActions());
    }

}
