package uk.co.davidjamesw.metroconfletro;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import uk.co.davidjamesw.metroconfletro.model.Retro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        String json = Files.readString(Path.of(args[0]));
        Gson gson = new Gson();
        MarkdownGenerator markdownGenerator =
                new MarkdownGenerator(gson.fromJson(json, Retro.class));
    }

}
