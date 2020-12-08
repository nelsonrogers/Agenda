package agenda;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Event {

    /**
     * The myTitle of this event
     */
    private final String myTitle;
    
    /**
     * The starting time of the event
     */
    private final LocalDateTime myStart;

    /**
     * The durarion of the event 
     */
    private final Duration myDuration;


    /**
     * Constructs an event
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     */
    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
    }

    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    public boolean isInDay(LocalDate aDay) {
        
        // Initialisation du booléen 
        boolean isInDay = false;
        // On récupère la date de fin
        LocalDateTime myEnd = myStart.plus(myDuration);
        // If the given day is between start and end of event, event occurs on that day
        if (aDay.compareTo(myStart.toLocalDate()) >= 0 && aDay.compareTo(myEnd.toLocalDate()) <= 0)
            isInDay = true;
        return isInDay;
    }
    
    /**
     * @return the myTitle
     */
    public String getTitle() {
        return myTitle;
    }

    /**
     * @return the myStart
     */
    public LocalDateTime getStart() {
        return myStart;
    }


    /**
     * @return the myDuration
     */
    public Duration getDuration() {
        return myDuration;
    }

   
    
}
