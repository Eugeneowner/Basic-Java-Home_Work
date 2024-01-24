package test.com.hw5;

import main.com.hw5.Pet;
import main.com.hw5.Species;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    @org.junit.jupiter.api.Test
    void testToString() {
        Pet pet = new Pet(Species.BEAGLE, "Pet", 3, 49, new String[]{"sleep", "eat"});
        Pet pet2 = new Pet(Species.BEAGLE, "Pet", 4, 49, new String[]{"sleep", "eat"});
        String petResult = "BEAGLE{nickname='Pet', age=3, trickLevel=49, habits=[sleep, eat]}";
        assertEquals(pet.toString(), petResult, "Cool");
        assertNotEquals(pet2.toString(), petResult, "No cool");
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        Pet pet = new Pet(Species.BEAGLE, "Pet", 3, 49, new String[]{"sleep", "eat"});
        Pet pet1 = new Pet(Species.BEAGLE, "Pet", 3, 49, new String[]{"sleep", "eat"});
        Pet pet2 = new Pet(Species.BEAGLE, "Pet", 4, 49, new String[]{"sleep", "eat"});
        assertEquals(pet, pet1, "Cool");
        assertNotEquals(pet, pet2, "No cool");
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
        Pet pet = new Pet(Species.BEAGLE, "Pet", 3, 49, new String[]{"sleep", "eat"});
        Pet pet1 = new Pet(Species.BEAGLE, "Pet", 3, 49, new String[]{"sleep", "eat"});
        Pet pet2 = new Pet(Species.BEAGLE, "Pet", 4, 49, new String[]{"sleep", "eat"});
        assertEquals(pet.hashCode(), pet1.hashCode(), "Cool");
        assertNotEquals(pet.hashCode(), pet2.hashCode(), "No cool");
    }
}