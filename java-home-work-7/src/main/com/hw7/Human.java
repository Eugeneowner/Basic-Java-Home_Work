package main.com.hw7;

import java.util.Map;
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
    private Map<DayOfWeek, String> schedule;

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    private Pet pet;
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

    public Map<DayOfWeek, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<DayOfWeek, String> schedule) {
        this.schedule = schedule;
    }

    public void greetPet() {
        if (getFamily().getPets() != null) {
            for (Pet pet : getFamily().getPets()) {
                System.out.println("Привіт, " + this.family.findOnePet(pet).getNickname());
            }
        } else {
            System.out.println("no pets");
        }
    }
    public void describePet() {
        if (getFamily().getPets() != null) {
            for (Pet pet : getFamily().getPets()) {
                String trickLevel = (this.family.findOnePet(pet).getTrickLevel() > 50) ? "дуже хитрий" : "майже не хитрий";
                System.out.println("У мене є " + this.family.findOnePet(pet).getSpecies() + ", їй " + this.family.findOnePet(pet).getAge() + " років, він " + trickLevel);
            }
        } else {
            System.out.println("no pets");
        }
    }

    public boolean feedPet(boolean timeToFeed) {
        if (getFamily().getPets() != null) {
            if (timeToFeed) {
                for (Pet pet : getFamily().getPets()) {
                    System.out.println("Хм... треба мені годувати " + this.family.findOnePet(pet).getNickname() + ".");
                }
                return true;
            } else {
                Random random = new Random();
                byte randomNumber = (byte) random.nextInt(101);
                for (Pet pet : getFamily().getPets()) {
                    if (this.family.findOnePet(pet).getTrickLevel() > randomNumber) {
                        System.out.println("Хм... треба мені годувати " + this.family.findOnePet(pet).getNickname() + ".");
                        return true;
                    } else {
                        System.out.println("Думаю, " + this.family.findOnePet(pet).getNickname() + " не голодний.");
                    }
                }
                return false;
            }
        }
        return false;
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human() {
    }

    public Human(String name, String surname, int year, int iq, Map<DayOfWeek, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
    }
    public Human(String name, String surname, int year, int iq, Map<DayOfWeek, String> schedule, Pet pet) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
        this.pet =pet;
    }


    @Override
    public String toString() {
        return "Human: \n name=" + this.name + " surname=" + this.surname + "\n year = " + this.year + " iq = " + this.iq + "\n schedule =  " + this.schedule;

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
