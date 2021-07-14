package uk.co.davidjamesw.metroconfletro;

import uk.co.davidjamesw.metroconfletro.model.Item;
import uk.co.davidjamesw.metroconfletro.model.Retro;

import java.util.List;
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
        markupBuffer.append(generateBulletsFromItemList(retro.getLiked()));
        markupBuffer.append(generateHeader("Learned"));
        markupBuffer.append(generateBulletsFromItemList(retro.getLearned()));
        markupBuffer.append(generateHeader("Lacked"));
        markupBuffer.append(generateBulletsFromItemList(retro.getLacked()));
        markupBuffer.append(generateHeader("Longed For"));
        markupBuffer.append(generateBulletsFromItemList(retro.getLongedFor()));
        markupBuffer.append(generateHeader("Actions"));
        markupBuffer.append(generateBulletsFromItemList(retro.getActions()));
        return markupBuffer.toString();
    }

    private String generateAttendeeTable() {
        return
                "|| Date || Attendees\r\n"
               + "| | " + getAttendeesAsBulletList();
    }

    private String generateHeader(String headerText) {
        return "\r\nh2. " + headerText + "\r\n";
    }

    private String getAttendeesAsBulletList() {
        return retro.getAttendees().stream()
             .map(attendee -> "* " + attendee + "\r\n")
             .collect(Collectors.joining());
    }

    private String generateBulletsFromItemList(List<Item> items) {
        return items.stream()
                    .filter(item -> item.getContent() != null)
                    .map(item -> "* " + item.getContent() + "\r\n")
                    .collect(Collectors.joining());
    }

}
