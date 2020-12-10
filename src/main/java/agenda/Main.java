/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author nelsonrogers
 */
public class Main {
    // Pour faire des tests
    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.of(2020, 11, 1, 22, 30);
        LocalDate terminationInclusive = LocalDate.of(2020, 11, 3);
        Duration duration = Duration.ofDays(1);
        Event e = new Event("évènement",  start, duration);
        RepetitiveEvent ev = new RepetitiveEvent("évènement",  start, duration, ChronoUnit.DAYS);
        Agenda agenda = new Agenda();
        agenda.addEvent(e);
        System.out.println(e.isInDay(LocalDate.of(2020, 11, 14)));
        //System.out.println(ev.getNumberOfOccurrences());
        //il faut faire une autre fonction isInDAy
        System.out.println(ev.isInDay(LocalDate.of(2020, 11, 2)));
    }
}
