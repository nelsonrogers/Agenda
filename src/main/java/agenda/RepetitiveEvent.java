package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {
    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    
    List<LocalDate> exceptions = new LinkedList<>();
    ChronoUnit frequency;
    
    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        this.frequency = frequency;
    }
    
    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {
        exceptions.add(date);
    }

    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        return frequency;  
    }

    @Override
    public boolean isInDay(LocalDate aDay) {

        if (exceptions.contains(aDay))
            return false;
        LocalDateTime lastStart = getStart();
        
        // On récupère la date de dernière occurence de l'événement avant
        // la date entrée.
        while (lastStart.toLocalDate().compareTo(aDay) < 0) {
            lastStart = lastStart.plus(1, frequency);
        }
        // On récupère la date de fin
        LocalDateTime myEnd = lastStart.plus(getDuration());
        
        // If the given day is between start and end of event, event occurs on that day
        if (aDay.compareTo(lastStart.toLocalDate()) >= 0 && aDay.compareTo(myEnd.toLocalDate()) <= 0)
            return true; 
        return false;

    }
}
