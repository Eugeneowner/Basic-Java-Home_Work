package com.hw4;

public class Main {
    public static void main(String[] args) {
        String[] habits = {"sleep", "eat"};

        Human father = new Human("Eugen", "Lobok", 1986);
        System.out.println(father);
        Human mather = new Human("Tatiayna", "Lobok", 1995 );
        System.out.println(mather);

        Family family = new Family(mather, father);

        Human child1 = new Human("Danya", "Lobok", 2021);
        System.out.println(child1);

        Human child2 = new Human("David", "Lobok", 2015);
        System.out.println(child2);

        Human child3 = new Human("Dima", "Dima", 2020);
        System.out.println(child3);

        family.addChild(child1);
        family.addChild(child2);
        family.addChild(child3);
        family.deleteChild(child3);

        Pet pet = new Pet("Pet", "Pet", 3, 49, habits);
        family.setPet(pet);

        System.out.println(family);
    }
}
