package com.hw8;

import com.hw8.Controllers.FamilyController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> habits = new HashSet<>();
        habits.add("sleep");
        habits.add("eat");
        Map<DayOfWeek, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY, "Learn programing java");
        schedule.put(DayOfWeek.TUESDAY, "Doctor's visit");
        schedule.put(DayOfWeek.WEDNESDAY, "Spending time with family");
        schedule.put(DayOfWeek.THURSDAY, "A trip to the store for a shopping spree");
        schedule.put(DayOfWeek.FRIDAY, "A corporate call in");
        schedule.put(DayOfWeek.SATURDAY, "Going to the shooting range with your friends");
        schedule.put(DayOfWeek.SUNDAY, "A trip to my parents' house");

        Human father = new Human("Eugen", "Lobok", 1986, 100, schedule);
        System.out.println(father);
        Human mather = new Human("Tatiayna", "Lobok", 1995, 100, schedule);
        System.out.println(mather);

        Family family = new Family(mather, father);

        Human child1 = new Human("Danya", "Lobok", 2021, 100, schedule);
        System.out.println(child1);

        Human child2 = new Human("David", "Lobok", 2015, 100, schedule);
        System.out.println(child2);

        Human child3 = new Human("Dima", "Dima", 2020, 100, schedule);
        System.out.println(child3);

        Human child4 = new Human("Dimaaaaa", "Dimaaaaa", 2020, 100, schedule);
        System.out.println(child4);

        family.addChild(child1);
        family.addChild(child2);
        family.addChild(child3);
        family.addChild(child4);
        family.deleteChild(child3);
        family.deleteChild(family.getChildIndex(child4));

        Human children = new Human();
        family.bornChild(children);

        Pet pet = new Dog("Pet", 3, 49, habits);
        Pet petAdd = new Dog("PetAdd", 1, 32, habits);
        pet.setSpecies(Species.BEAGLE);
        petAdd.setSpecies(Species.CHIHUAHUA);
        family.addPet(pet);
        family.addPet(petAdd);
        child1.greetPet();
        child1.feedPet(true);
        child1.describePet();


        System.out.println(pet);

        System.out.println(family);

        for (int i = 0; i < 10000001; i++) {
             new Human();
        }

        FamilyController familyController = new FamilyController();
        familyController.createNewFamily(mather, father);
        familyController.getFamiliesBiggerThan(1);
        familyController.getFamiliesLessThan(5);
        familyController.countFamiliesWithMemberNumber(2);
        familyController.bornChild(familyController.getFamilyById(0), "Erik", "Elsa");
        familyController.adoptChild(familyController.getFamilyById(0), child3);
        familyController.deleteAllChildrenOlderThen(30);
        familyController.count();
        familyController.addPet(0, pet);
        familyController.displayAllFamilies();
        familyController.getPets(0);
        familyController.getFamilyById(0);
        familyController.deleteFamilyByIndex(0);
        familyController.deleteFamilyByFamily(familyController.getFamilyById(0));
    }
}
