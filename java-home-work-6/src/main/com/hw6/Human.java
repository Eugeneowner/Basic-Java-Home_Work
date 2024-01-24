package main.com.hw6;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Human {
    static {
        System.out.println("Loading new Class Human");
    }

    {
        System.out.println("Creating new Human Object");
    }

    private String name;
    private String surname;
    private int year;
    private int iq;
    private String[][] schedule;

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    private Family family;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }


    public void greetPet() {
        System.out.println("Привіт, " + this.family.getPet().getNickname());
    }

    public void describePet() {
        if (this.family.getPet().getTrickLevel() > 50) {
            System.out.println("У мене є " + this.family.getPet().getSpecies() + ", їй " + this.family.getPet().getAge() + " років, він дуже хитрий");
        } else {
            System.out.println("У мене є " + this.family.getPet().getSpecies() + ", їй " + this.family.getPet().getAge() + " років, він майже не хитрий");
        }
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human() {
    }

    public Human(String name, String surname, int year, int iq, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
    }

    public boolean feedPet(boolean timeToFeed) {
        if (timeToFeed) {
            System.out.println("Хм... треба мені годувати " + this.family.getPet().getNickname() + ".");
            return true;
        } else {
            Random random = new Random();
            byte randomNumber = (byte) random.nextInt(101);
            if (this.family.getPet().getTrickLevel() > randomNumber) {
                System.out.println("Хм... треба мені годувати " + this.family.getPet().getNickname() + ".");
                return true;
            } else {
                System.out.println("Думаю, " + this.family.getPet().getNickname() + " не голодний.");
                return false;
            }
        }
    }

    @Override
    public String toString() {
        return "Human{name='" + this.name + "', surname='" + this.surname + "', year=" + this.year + ", iq=" + this.iq + ", schedule= " + Arrays.deepToString(this.schedule) + "}}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname) &&
                year == human.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year);
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Deleting from class Human object " + this);
        } finally {
            super.finalize();
        }
    }
}
