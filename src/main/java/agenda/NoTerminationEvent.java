package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


/**
 * Description : A repetitive event that never terminates
 */

public class NoTerminationEvent extends RepetitiveEvent {
	public NoTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
             super(title, start, duration, frequency);
            // TODO : implémenter cette méthode
            throw new UnsupportedOperationException("Pas encore implémenté");
        }
}