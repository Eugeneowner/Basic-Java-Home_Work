package com.hw8;

import com.hw8.Dog;
import com.hw8.Pet;
import com.hw8.Species;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    @org.junit.jupiter.api.Test
    void testToString() {
        Set<String> habits = new HashSet<>();
        habits.add("sleep");
        habits.add("eat");
        Pet pet = new Dog( "Pet", 3, 49,habits);
        pet.setSpecies(Species.BEAGLE);
        Pet pet2 = new Dog("Pet", 4, 49, habits);
        pet2.setSpecies(Species.BEAGLE);
        String petResult = "BEAGLE{nickname='Pet', age=3, trickLevel=49, habits=[sleep, eat]}";
        assertEquals(pet.toString(), petResult, "Cool");
        assertNotEquals(pet2.toString(), petResult, "No cool");
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        Set<String> habits = new HashSet<>();
        habits.add("sleep");
        habits.add("eat");
        Pet pet = new Dog( "Pet", 3, 49, habits);
        Pet pet1 = new Dog("Pet", 3, 49, habits);
        Pet pet2 = new Dog( "Pet", 4, 49, habits);
        assertEquals(pet, pet1, "Cool");
        assertNotEquals(pet, pet2, "No cool");
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
        Set<String> habits = new HashSet<>();
        habits.add("sleep");
        habits.add("eat");
        Pet pet = new Dog("Pet", 3, 49, habits);
        Pet pet1 = new Dog( "Pet", 3, 49, habits);
        Pet pet2 = new Dog("Pet", 4, 49, habits);
        assertEquals(pet.hashCode(), pet1.hashCode(), "Cool");
        assertNotEquals(pet.hashCode(), pet2.hashCode(), "No cool");
    }
}