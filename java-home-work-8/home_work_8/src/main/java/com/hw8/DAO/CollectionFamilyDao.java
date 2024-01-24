package com.hw8.DAO;

import com.hw8.Family;
import com.hw8.Human;
import com.hw8.Pet;

import java.util.*;
import java.time.Year;

public class CollectionFamilyDao implements FamilyDao {
    private List<Family> familys = new ArrayList<>();

    public List<Family> getFamilyList() {
        return familys;
    }

    @Override
    public List<Family> getAllFamilies() {
        return familys;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        for (int i = 0; i < familys.size(); i++) {
            if (i == index) {
                return familys.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean deleteFamily(int index) {
        for (int i = 0; i < familys.size(); i++) {
            if (i == index) {
                familys.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return familys.remove(family);
    }

    @Override
    public void saveFamily(Family family) {
        for (int i = 0; i < familys.size(); i++) {
            if (familys.get(i) == family) {
                familys.set(i, family);
                return;
            }
        }
        familys.add(family);
    }


}
