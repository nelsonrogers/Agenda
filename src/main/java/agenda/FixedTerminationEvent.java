package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive event that terminates after a given date, or after
 * a given number of occurrences
 */
public class FixedTerminationEvent extends RepetitiveEvent {

    
    /**
     * Constructs a fixed terminationInclusive event ending at a given date
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param terminationInclusive the date when this event ends
     */
    
    LocalDate terminationInclusive;
    
    long numberOfOccurrences;
    
    
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, LocalDate terminationInclusive) {
        super(title, start, duration, frequency);
        // TODO : implémenter cette méthode
        this.terminationInclusive = terminationInclusive;
    }

    /**
     * Constructs a fixed termination event ending after a number of iterations
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param numberOfOccurrences the number of occurrences of this repetitive event
     */
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, long numberOfOccurrences) {
        super(title, start, duration, frequency);
        // TODO : implémenter cette méthode
        this.numberOfOccurrences = numberOfOccurrences;
    }
    /**
     *
     * @return the termination date of this repetitive event
     */
    public LocalDate getTerminationDate() {
        // TODO : implémenter cette méthode
        if (terminationInclusive != null)
            return terminationInclusive;
        //Calculer la date de fin à partir de numberOfOccurrences
        
    }

    public long getNumberOfOccurrences() {
        // TODO : implémenter cette méthode
        if (numberOfOccurrences != null)
            return numberOfOccurrences;
        //Calculer le nombre d'occurences à partir de la date de fin en utilisant frequency
        
    }
        
}
