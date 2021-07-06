package uk.co.davidjamesw.metroconfletro.model;

import java.util.List;

public class Retro {

    private List<String> attendees;
    private List<String> liked;
    private List<String> learned;
    private List<String> longedFor;
    private List<String> lacked;
    private List<String> actions;

    public Retro(List<String> attendees,
                 List<String> liked,
                 List<String> learned,
                 List<String> longedFor,
                 List<String> lacked,
                 List<String> actions) {
        this.attendees = attendees;
        this.liked = liked;
        this.learned = learned;
        this.longedFor = longedFor;
        this.lacked = lacked;
        this.actions = actions;
    }

    public List<String> getAttendees() {
        return attendees;
    }

    public List<String> getLiked() {
        return liked;
    }

    public List<String> getLearned() {
        return learned;
    }

    public List<String> getLongedFor() {
        return longedFor;
    }

    public List<String> getLacked() {
        return lacked;
    }

    public List<String> getActions() {
        return actions;
    }
}
