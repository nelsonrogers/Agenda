package agenda;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        agenda.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        List eventsInDay = new LinkedList<>();
        for (Event event : agenda) {
            if (event.isInDay(day))
                eventsInDay.add(event);
        }
        return eventsInDay;
        
    }
    
            /**
     * Trouver les événements de l'agenda en fonction de leur titre
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        List<Event> eventsWithSameTitle = new LinkedList<>();
        for (Event event : agenda) {
            if (event.getTitle().equals(title))
                eventsWithSameTitle.add(event);
        }
        return eventsWithSameTitle;
        
    }
    
    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        
        boolean isFree = true;
        LocalDateTime start = e.getStart();
        LocalDateTime end = start.plus(e.getDuration());
        for (Event event : agenda) {
            if (event.getStart().compareTo(start) >= 0 && event.getStart().compareTo(end) <= 0) {
                isFree = false;
                break;
            }
            if (event.getStart().plus(event.getDuration()).compareTo(start) >= 0 && event.getStart().plus(event.getDuration()).compareTo(end) <= 0) {
                isFree = false;
                break;
            }
        }
        return isFree;
    }
    
}
