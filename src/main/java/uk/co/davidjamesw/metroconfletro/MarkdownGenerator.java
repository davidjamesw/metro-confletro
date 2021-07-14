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
        markdownBuffer.append(getAttendeeTable());
        return markdownBuffer.toString();
    }

    private String getAttendeeTable() {
        return
                "|| Date || Attendees\r\n"
               + "| | " + getAttendeesAsBulletList();
    }

    private String getAttendeesAsBulletList() {
        return retro.getAttendees().stream()
             .map(attendee -> "* " + attendee + "\r\n")
             .collect(Collectors.joining());
    }

}
