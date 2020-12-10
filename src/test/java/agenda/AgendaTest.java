package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class AgendaTest {
    Agenda agenda;
    
    // November 1st, 2020
    LocalDate nov_1_2020 = LocalDate.of(2020, 11, 1);

    // January 5, 2021
    LocalDate jan_5_2021 = LocalDate.of(2021, 1, 5);

    // November 1st, 2020, 22:30
    LocalDateTime nov_1__2020_22_30 = LocalDateTime.of(2020, 11, 1, 22, 30);
    
    // November 1st, 2020, 22:30
    LocalDateTime nov_1__2020_22_31 = LocalDateTime.of(2020, 11, 1, 22, 31);
    
    // November 1st, 2020, 20:29
    LocalDateTime nov_1__2020_20_29 = LocalDateTime.of(2020, 11, 1, 20, 29);
    
    // November 1st, 2020, 21:30
    LocalDateTime nov_1__2020_21_30 = LocalDateTime.of(2020, 11, 1, 21, 30);
    
    // 120 minutes
    Duration min_120 = Duration.ofMinutes(120);

    // A simple event
    // November 1st, 2020, 22:30, 120 minutes
    Event simple = new Event("Simple event", nov_1__2020_22_30, min_120);
    
    // evènement se produisant en même temps que simple
    Event sameAsSimple = new Event("Same as simple event", nov_1__2020_22_30, min_120);
    
    // evènement commençant pendant l'evenement simple
    Event simple2 = new Event("Simple event 2", nov_1__2020_22_31, min_120);
    
    // evènement se terminant pendant l'evenement simple
    Event simple3 = new Event("Simple event 3", nov_1__2020_21_30, min_120);
    
    // evènement ne créant pas de conflits de date avec les autres evenements
    Event simple4 = new Event("Simple event 4", nov_1__2020_20_29, min_120);

    // A Weekly Repetitive event ending at a given date
    RepetitiveEvent fixedTermination = new FixedTerminationEvent("Fixed termination weekly", nov_1__2020_22_30, min_120, ChronoUnit.WEEKS, jan_5_2021);

    // A Weekly Repetitive event ending after a give number of occurrrences
    RepetitiveEvent fixedRepetitions = new FixedTerminationEvent("Fixed termination weekly", nov_1__2020_22_30, min_120, ChronoUnit.WEEKS, 10);
    
    // A daily repetitive event, never ending
    // November 1st, 2020, 22:30, 120 minutes
    RepetitiveEvent neverEnding = new RepetitiveEvent("Never Ending", nov_1__2020_22_30, min_120, ChronoUnit.DAYS);
    
    
    @BeforeEach
    public void setUp() {
        agenda = new Agenda();
        agenda.addEvent(simple);
        agenda.addEvent(fixedTermination);
        agenda.addEvent(fixedRepetitions);
        agenda.addEvent(neverEnding);
    }
    
    @Test
    public void testMultipleEventsInDay() {
        assertEquals(4, agenda.eventsInDay(nov_1_2020).size(), "Il y a 4 événements ce jour là");
        assertTrue(agenda.eventsInDay(nov_1_2020).contains(neverEnding));
    }
       

    @Test
    public void testFindByTitle() {
        assertTrue(1 == agenda.findByTitle("Simple event").size());
        agenda.addEvent(sameAsSimple);
        assertTrue(1 == agenda.findByTitle("Same as simple event").size());
        agenda.addEvent(simple);
        assertTrue(2 == agenda.findByTitle("Simple event").size());
    }
    
    
    @Test
    public void testIsFreeFor() {
        // on vérifie que 2 evenements se passant exactement en même temps sont en conflit
        assertFalse(agenda.isFreeFor(sameAsSimple));
        // on vérifie qu'un evenement commençant pendant un autre evenement créé un conflit
        assertFalse(agenda.isFreeFor(simple2));
        // on vérifie qu'un evenement finissant pendant un autre evenement créé un conflit
        assertFalse(agenda.isFreeFor(simple3));
        
        // on vérifie agenda est libre pour un evenement n'étant pas en conflit de date avec un autre
        assertTrue(agenda.isFreeFor(simple4));
    }
}
