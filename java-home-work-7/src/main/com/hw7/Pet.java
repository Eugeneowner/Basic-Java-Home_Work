package main.com.hw7;

import java.util.Objects;
import java.util.Set;

public abstract class Pet {
    static {
        System.out.println("Loading new Class Pet");
    }

    {
        System.out.println("Creating new Pet Object");
    }


    private Species species = Species.UNKNOWN;
    private String nickname;
    private int age;
    private int trickLevel;
    private Set<String> habits;

    public void eat() {
        System.out.println("Я ї'м!");
    }

    public abstract void respond();



    public Species getSpecies() {
        return species;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public Set<String> getHabits() {
        return habits;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public Pet(Species species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet( String nickname, int age, int trickLevel, Set<String> habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet() {
    }

    @Override
    public String toString() {
        return this.species + "{nickname='" + this.nickname + "', age=" + this.age + ", trickLevel=" + this.trickLevel + ", habits=" + this.habits + "canFly=" + this.species.isCanFly() + "numberOfLegs=" + this.species.getNumberOfLegs() + "hasFur=" + this.species.isHasFur() + "}";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return species == pet.species && Objects.equals(nickname, pet.nickname) && age == pet.age && trickLevel == pet.trickLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname, age, trickLevel);
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("Deleting from class Pet object " + this);
        super.finalize();
    }
}



