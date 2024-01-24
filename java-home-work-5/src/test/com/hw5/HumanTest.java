package test.com.hw5;

import main.com.hw5.DayOfWeek;
import main.com.hw5.Human;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    @Test
    void testToString() {
        String[][] schedule = {
                {DayOfWeek.MONDAY.name(), "go home"},
                {DayOfWeek.TUESDAY.name(), "go to gym"},
                {DayOfWeek.WEDNESDAY.name(), "SPA"},
                {DayOfWeek.THURSDAY.name(), "go home"},
                {DayOfWeek.FRIDAY.name(), "visit friends"},
                {DayOfWeek.SATURDAY.name(), "film"},
                {DayOfWeek.SUNDAY.name(), "zoo"}
        };
        Human father = new Human("Eugen", "Lobok", 1986, 100, schedule);
        String father1 = "Human{name='Eugen', surname='Lobok', year=1986, iq=100, schedule= [[MONDAY, go home], [TUESDAY, go to gym], [WEDNESDAY, SPA], [THURSDAY, go home], [FRIDAY, visit friends], [SATURDAY, film], [SUNDAY, zoo]]}}";
        String father2 = "Human{name='Eugenn', surname='Lobok', year=1986, iq=100, schedule= [[MONDAY, go home], [TUESDAY, go to gym], [WEDNESDAY, SPA], [THURSDAY, go home], [FRIDAY, visit friends], [SATURDAY, film], [SUNDAY, zoo]]}}";
        assertEquals(father.toString(), father1, "Cool");
        assertNotEquals(father.toString(), father2, "No Cool");
    }

    @Test
    void testEquals() {
        String[][] schedule = {
                {DayOfWeek.MONDAY.name(), "go home"},
                {DayOfWeek.TUESDAY.name(), "go to gym"},
                {DayOfWeek.WEDNESDAY.name(), "SPA"},
                {DayOfWeek.THURSDAY.name(), "go home"},
                {DayOfWeek.FRIDAY.name(), "visit friends"},
                {DayOfWeek.SATURDAY.name(), "film"},
                {DayOfWeek.SUNDAY.name(), "zoo"}
        };
        Human father = new Human("Eugen", "Lobok", 1986, 100, schedule);
        Human father1 = new Human("Eugen", "Lobok", 1986, 100, schedule);
        Human father2 = new Human("Eugenn", "Lobok", 1986, 100, schedule);
        assertEquals(father, father1, "Cool");
        assertNotEquals(father, father2, "No Cool");
    }

    @Test
    void testHashCode() {
        String[][] schedule = {
                {DayOfWeek.MONDAY.name(), "Learn programing java"},
                {DayOfWeek.TUESDAY.name(), "Doctor's visit"},
                {DayOfWeek.WEDNESDAY.name(), "Spending time with family"},
                {DayOfWeek.THURSDAY.name(), "A trip to the store for a shopping spree"},
                {DayOfWeek.FRIDAY.name(), "A corporate call in"},
                {DayOfWeek.SATURDAY.name(), "Going to the shooting range with your friends"},
                {DayOfWeek.SUNDAY.name(), "A trip to my parents' house"}
        };
        Human father = new Human("Eugen", "Lobok", 1986, 100, schedule);
        Human father1 = new Human("Eugen", "Lobok", 1986, 100, schedule);
        Human father2 = new Human("Eugenn", "Lobok", 1986, 100, schedule);
        assertEquals(father.hashCode(), father1.hashCode(), "Cool");
        assertNotEquals(father.hashCode(), father2.hashCode(), "No Cool");
    }
}