package uk.co.davidjamesw.metroconfletro;

import uk.co.davidjamesw.metroconfletro.model.Retro;

import java.util.stream.Collectors;

public class MarkupGenerator {

    private final Retro retro;

    public MarkupGenerator(Retro retro) {
        this.retro = retro;
    }

    public String generateMarkup() {
        StringBuffer markupBuffer = new StringBuffer();
        markupBuffer.append(generateAttendeeTable());
        markupBuffer.append(generateHeader("Liked"));
        markupBuffer.append(generateHeader("Learned"));
        markupBuffer.append(generateHeader("Lacked"));
        markupBuffer.append(generateHeader("Longed For"));
        markupBuffer.append(generateHeader("Actions"));
        return markupBuffer.toString();
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
