package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    
    List<Event> agenda = new LinkedList<>();
    
    public void addEvent(Event e) {
        // TODO : implémenter cette méthode
        agenda.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        // TODO : implémenter cette méthode
        List eventsInDay = new LinkedList<>();
        for (Event event : agenda) {
            if (event.isInDay(day))
                eventsInDay.add(event);
        }
        return eventsInDay;
        
    }
}
