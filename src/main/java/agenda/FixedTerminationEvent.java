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
    LocalDateTime lastStart;
    
    long numberOfOccurrences;
    
    LocalDate date;
            
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, LocalDate terminationInclusive) {
        super(title, start, duration, frequency);
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
        // numberOfOccurrences doit être positif
        if (numberOfOccurrences < 0) 
            throw new IllegalArgumentException("numberOfOccurrences ne peut pas être négatif");
        this.numberOfOccurrences = numberOfOccurrences;
    }
    /**
     *
     * @return the termination date of this repetitive event
     */
    public LocalDate getTerminationDate() {
        if (terminationInclusive != null)
            return terminationInclusive;
        //Calculate end date from numberOfOccurrences
        lastStart = getStart().plus(numberOfOccurrences - 1, frequency);
        
        return lastStart.toLocalDate();
    }

    public long getNumberOfOccurrences() {
        // si numberOfOccurences a été définit dans le constructeur, on le retourne directement
        if (numberOfOccurrences != 0) 
            return numberOfOccurrences;
        
        //Calculer le nombre d'occurences à partir de la date de fin en utilisant frequency
        LocalDate endDate = getTerminationDate();
        date = getStart().toLocalDate();
        while (endDate.compareTo(date) > 0) {
            date = date.plus(1, frequency);
            numberOfOccurrences++;
        }
        return numberOfOccurrences;
    }
    
        
}
