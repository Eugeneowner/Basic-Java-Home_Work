package com.hw8.Services;
import com.hw8.*;
import com.hw8.DAO.CollectionFamilyDao;
import com.hw8.DAO.FamilyDao;

import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FamilyService {
    private FamilyDao familyDao = new CollectionFamilyDao();
    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        Iterator<Family> familyIterator = familyDao.getAllFamilies().iterator();
        int counter = 1;
        while (familyIterator.hasNext()) {
            Family familyCurrent = familyIterator.next();
            counter++;
            System.out.println(counter + ". " + familyCurrent);
        }
    }


    public List<Family> getFamiliesBiggerThan(int quantity) {
        List<Family> newFamilies = new ArrayList<>();
        for (Family family : familyDao.getAllFamilies()) {
            if (family.countFamily() > quantity) {
                newFamilies.add(family);
                System.out.println(family);
            }
        }
        return newFamilies;
    }

    public List<Family> getFamiliesLessThan(int quantity) {
        List<Family> newFamilies = new ArrayList<>();
        for (Family family : familyDao.getAllFamilies()) {
            if (family.countFamily() < quantity) {
                newFamilies.add(family);
                System.out.println(family);
            }
        }
        return newFamilies;
    }

    public int countFamiliesWithMemberNumber(int quantity) {
        int counter = 0;
        for (Family family : familyDao.getAllFamilies()) {
            if (family.countFamily() == quantity) {
                counter++;
            }
        }
        System.out.println("The quantity is " + counter);
        return counter;
    }


    public void createNewFamily(Human human1, Human human2) {
        Family family = new Family(human1, human2);
        familyDao.saveFamily(family);
    }


    public Family bornChild(Family family, String boyName, String girlName) {
        String childName = Math.random() < 0.5 ? boyName : girlName;
        Human child;
        if (childName.equals(boyName)) {
            child = new Man();
        } else {
            child = new Woman();
        }
        child.setFamily(family);
        child.setSurname(family.getFather().getSurname());
        child.setName(childName);
        family.addChild(child);
        return family;
    }

    public Family adoptChild(Family family, Human human) {
        family.addChild(human);
        familyDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThen(int age) {
        Year currentYear = Year.now();
        for (Family family : familyDao.getAllFamilies()) {
            Iterator<Human> iterator = family.getChildren().iterator();
            while (iterator.hasNext()) {
                Human human = iterator.next();
                int birthYear = human.getYear();
                int ageOfHuman = currentYear.getValue() - birthYear;

                if (ageOfHuman > age) {
                    iterator.remove();
                    family.deleteChild(human);
                }
            }
            familyDao.saveFamily(family);
        }
    }

    public int count() {
        return familyDao.getAllFamilies().size();
    }

    public Set<Pet> getPets(int index) {
        Family family = familyDao.getFamilyByIndex(index);
        return family.getPets();
    }
    public void addPet(int familyIndex, Pet pet) {
        if (familyIndex >= 0 && familyIndex < familyDao.getAllFamilies().size()) {
            familyDao.getAllFamilies().get(familyIndex).addPetTwo(pet);
        }
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamily(index);
    }

    public boolean deleteFamilyByFamily(Family family) {
        return familyDao.deleteFamily(family);
    }

    public Family getFamilyById(int index) {
        System.out.println(familyDao.getFamilyByIndex(index));
        return familyDao.getFamilyByIndex(index);
    }
}