package uk.co.davidjamesw.metroconfletro;

import uk.co.davidjamesw.metroconfletro.model.Retro;

import java.util.stream.Collectors;

public class MarkdownGenerator {

    private final Retro retro;

    public MarkdownGenerator(Retro retro) {
        this.retro = retro;
    }

    public String generateMarkdown() {
        StringBuffer markdownBuffer = new StringBuffer();
        markdownBuffer.append(generateAttendeeTable());
        markdownBuffer.append(generateHeader("Liked"));
        markdownBuffer.append(generateHeader("Learned"));
        markdownBuffer.append(generateHeader("Lacked"));
        markdownBuffer.append(generateHeader("Longed For"));
        markdownBuffer.append(generateHeader("Actions"));
        return markdownBuffer.toString();
    }

    private String generateAttendeeTable() {
        return
                "|| Date || Attendees\r\n"
               + "| | " + getAttendeesAsBulletList();
    }

    private String generateHeader(String headerText) {
        return "\r\nh2. " + headerText;
    }

    private String getAttendeesAsBulletList() {
        return retro.getAttendees().stream()
             .map(attendee -> "* " + attendee + "\r\n")
             .collect(Collectors.joining());
    }

}
