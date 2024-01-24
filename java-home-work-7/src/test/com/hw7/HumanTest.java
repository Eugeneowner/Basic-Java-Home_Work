package test.com.hw7;

import main.com.hw7.DayOfWeek;
import main.com.hw7.Human;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    @Test
    void testToString() {
        Map<DayOfWeek, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY, "go home");
        schedule.put(DayOfWeek.TUESDAY, "go to gym");
        schedule.put(DayOfWeek.WEDNESDAY, "SPA");
        schedule.put(DayOfWeek.THURSDAY, "go home");
        schedule.put(DayOfWeek.FRIDAY, "visit friends");
        schedule.put(DayOfWeek.SATURDAY, "film");
        schedule.put(DayOfWeek.SUNDAY, "zoo");


        Human father = new Human("Eugen", "Lobok", 1986, 100, schedule);
        String father1 = "Human{name='Eugen', surname='Lobok', year=1986, iq=100, schedule= [[MONDAY, go home], [TUESDAY, go to gym], [WEDNESDAY, SPA], [THURSDAY, go home], [FRIDAY, visit friends], [SATURDAY, film], [SUNDAY, zoo]]}}";
        String father2 = "Human{name='Eugenn', surname='Lobok', year=1986, iq=100, schedule= [[MONDAY, go home], [TUESDAY, go to gym], [WEDNESDAY, SPA], [THURSDAY, go home], [FRIDAY, visit friends], [SATURDAY, film], [SUNDAY, zoo]]}}";
        assertEquals(father.toString(), father1, "Cool");
        assertNotEquals(father.toString(), father2, "No Cool");
    }

    @Test
    void testEquals() {

        Map<DayOfWeek, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY, "go home");
        schedule.put(DayOfWeek.TUESDAY, "go to gym");
        schedule.put(DayOfWeek.WEDNESDAY, "SPA");
        schedule.put(DayOfWeek.THURSDAY, "go home");
        schedule.put(DayOfWeek.FRIDAY, "visit friends");
        schedule.put(DayOfWeek.SATURDAY, "film");
        schedule.put(DayOfWeek.SUNDAY, "zoo");


        Human father = new Human("Eugen", "Lobok", 1986, 100, schedule);
        Human father1 = new Human("Eugen", "Lobok", 1986, 100, schedule);
        Human father2 = new Human("Eugenn", "Lobok", 1986, 100, schedule);

        assertEquals(father, father1, "Cool");

        assertNotEquals(father, father2, "No Cool");
    }

    @Test
    void testHashCode() {
        Map<DayOfWeek, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY, "go home");
        schedule.put(DayOfWeek.TUESDAY, "go to gym");
        schedule.put(DayOfWeek.WEDNESDAY, "SPA");
        schedule.put(DayOfWeek.THURSDAY, "go home");
        schedule.put(DayOfWeek.FRIDAY, "visit friends");
        schedule.put(DayOfWeek.SATURDAY, "film");
        schedule.put(DayOfWeek.SUNDAY, "zoo");
        Human father = new Human("Eugen", "Lobok", 1986, 100, schedule);
        Human father1 = new Human("Eugen", "Lobok", 1986, 100, schedule);
        Human father2 = new Human("Eugenn", "Lobok", 1986, 100, schedule);
        assertEquals(father.hashCode(), father1.hashCode(), "Cool");
        assertNotEquals(father.hashCode(), father2.hashCode(), "No Cool");
    }
}