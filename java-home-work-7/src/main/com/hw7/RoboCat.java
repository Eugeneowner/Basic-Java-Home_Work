package main.com.hw7;

import java.util.Set;

public class RoboCat extends Pet {
    public RoboCat(Species species, String nickname) {
        super(species, nickname);
    }

    public RoboCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    public RoboCat() {
    }

    @Override
    public void respond()
    {
        System.out.println("Привіт, хазяїн. Я - " + this.getNickname() + ". Я скучив!");
    }
}
