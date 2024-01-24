package com.hw8.DAO;

import com.hw8.Family;
import com.hw8.Human;
import com.hw8.Pet;

import java.util.List;
import java.util.Set;

public interface FamilyDao {
    List<Family> getAllFamilies();

    Family getFamilyByIndex(int index);

    boolean deleteFamily(int index);

    boolean deleteFamily(Family family);

    void saveFamily(Family family);


}
