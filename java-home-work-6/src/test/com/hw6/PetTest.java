package test.com.hw6;

import main.com.hw6.Dog;
import main.com.hw6.Pet;
import main.com.hw6.Species;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    @org.junit.jupiter.api.Test
    void testToString() {
        Pet pet = new Dog( "Pet", 3, 49, new String[]{"sleep", "eat"});
        pet.setSpecies(Species.BEAGLE);
        Pet pet2 = new Dog("Pet", 4, 49, new String[]{"sleep", "eat"});
        pet2.setSpecies(Species.BEAGLE);
        String petResult = "BEAGLE{nickname='Pet', age=3, trickLevel=49, habits=[sleep, eat]}";
        assertEquals(pet.toString(), petResult, "Cool");
        assertNotEquals(pet2.toString(), petResult, "No cool");
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        Pet pet = new Dog( "Pet", 3, 49, new String[]{"sleep", "eat"});
        Pet pet1 = new Dog("Pet", 3, 49, new String[]{"sleep", "eat"});
        Pet pet2 = new Dog( "Pet", 4, 49, new String[]{"sleep", "eat"});
        assertEquals(pet, pet1, "Cool");
        assertNotEquals(pet, pet2, "No cool");
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
        Pet pet = new Dog("Pet", 3, 49, new String[]{"sleep", "eat"});
        Pet pet1 = new Dog( "Pet", 3, 49, new String[]{"sleep", "eat"});
        Pet pet2 = new Dog("Pet", 4, 49, new String[]{"sleep", "eat"});
        assertEquals(pet.hashCode(), pet1.hashCode(), "Cool");
        assertNotEquals(pet.hashCode(), pet2.hashCode(), "No cool");
    }
}