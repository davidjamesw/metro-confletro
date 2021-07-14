package uk.co.davidjamesw.metroconfletro;

import com.google.gson.Gson;
import uk.co.davidjamesw.metroconfletro.model.Retro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        String json = Files.readString(Path.of(args[0]));
        Gson gson = new Gson();
        MarkupGenerator markupGenerator =
                new MarkupGenerator(gson.fromJson(json, Retro.class));
    }

}
