package com.hw8;

import java.util.Set;

public class Fish extends Pet implements Foul {
    public Fish(Species species, String nickname) {
        super(species, nickname);
    }

    public Fish(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    public Fish() {
    }

    @Override
    public void respond() {
        System.out.println("Привіт, хазяїн. Я - " + this.getNickname() + ". Я скучив!");
    }

    @Override
    public void foul() {
        System.out.println("Потрібно добре замести сліди...");
    }
}
