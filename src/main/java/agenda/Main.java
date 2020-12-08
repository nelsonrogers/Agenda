/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author nelsonrogers
 */
public class Main {
    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.of(2020, 11, 1, 22, 30);
        Duration duration = Duration.ofDays(12);
        Event e = new Event("évènement",  start, duration);
        Agenda agenda = new Agenda();
        agenda.addEvent(e);
        System.out.println(e.isInDay(LocalDate.of(2020, 11, 14)));
    }
}
