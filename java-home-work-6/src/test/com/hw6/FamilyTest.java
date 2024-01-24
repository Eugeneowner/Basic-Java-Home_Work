package test.com.hw6;

import main.com.hw6.Family;
import main.com.hw6.Human;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FamilyTest {

    @org.junit.jupiter.api.Test
    void testToString() {
        Human human = new Human("human", "human", 1234);
        Human human1 = new Human("human", "human", 1234);
        Human human2 = new Human("human1", "human2", 1234);
        Family family = new Family(human, human1);
        Family family1 = new Family(human2, human1);
        String familyResult = "Family{mother='Human{name='human', surname='human', year=1234, iq=0, schedule= null}}', father='Human{name='human', surname='human', year=1234, iq=0, schedule= null}}', children=[], pet=null.";
        assertEquals(family.toString(), familyResult);
        assertNotEquals(family1.toString(), familyResult);
    }

    @Test
    void testEquals() {
        Human human = new Human("human", "human", 1234);
        Human human1 = new Human("human", "human", 1234);
        Human human2 = new Human("human1", "human2", 1234);

        Family family = new Family(human, human2);
        Family family1 = new Family(human, human1);
        Family family2 = new Family(human, human2);
        assertEquals(family, family2);
        assertNotEquals(family, family1);
    }

    @Test
    void testHashCode() {
        Human human = new Human("human", "human", 1234);
        Human human1 = new Human("human", "human", 1234);
        Human human2 = new Human("human1", "human2", 1234);
        Family family = new Family(human, human2);
        Family family1 = new Family(human, human1);
        Family family2 = new Family(human, human2);
        assertEquals(family.hashCode(), family2.hashCode());
        assertNotEquals(family.hashCode(), family1.hashCode());
    }

    @Test
    void addChild() {
        Human human = new Human("human", "human", 1234);
        Human human1 = new Human("human", "human", 1234);
        Human child = new Human("human1", "human2", 1234);
        Family family = new Family(human, human1);
        family.addChild(child);
        assertEquals(1, family.getChildren().length);
        assertEquals(family, child.getFamily());
    }

    @Test
    void deleteChild() {
        Human human = new Human("human", "human", 1234);
        Human human1 = new Human("human", "human", 1234);
        Human child = new Human("human1", "human2", 1234);
        Human child2 = new Human("human2", "human2", 1234);

        Family family = new Family(human, human1);
        Family family2 = new Family(human, human1);
        family.addChild(child);
        assertNotEquals(family, family2, "deleting");
        assertTrue(family.deleteChild(child), "deleting");

        assertFalse(family.deleteChild(child2), "is not exists");
        assertNull(child2.getFamily());
    }

    @Test
    void testDeleteChildByIndex() {
        Human mother = new Human("Nastya", "Markov", 1991);
        Human father = new Human("Alex", "Markov", 1989);
        Family family = new Family(mother, father);
        Human child = new Human("Den", "Markov", 2005);
        family.addChild(child);
        assertTrue(family.deleteChild(family.getChildIndex(child)), "deleting complete");
        assertEquals(0, family.getChildren().length);
        assertFalse(family.deleteChild(family.getChildIndex(child)), "deleting complete");
        assertEquals(0, family.getChildren().length);
        assertNull(child.getFamily());
    }


    @Test
    void countFamily() {
        Human human = new Human("human", "human", 1234);
        Human human1 = new Human("human", "human", 1234);
        Human child = new Human("human1", "human2", 1234);
        Family family = new Family(human, human1);
        family.addChild(child);
        assertEquals(3, family.countFamily(), "cool");
    }
}