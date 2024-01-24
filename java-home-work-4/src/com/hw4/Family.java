package com.hw4;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    static {
        System.out.println("Loading new Class Family");
    }
    {
        System.out.println("Creating new Family Object");
    }
    private Human mother;
    private Human father;
    private Human[] children;

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    private Pet pet;

    public  Family(Human mother, Human father) {
        if (mother == null || father == null) {
            throw new IllegalArgumentException("Both mother and father must be present to create a family.");
        }
        this.mother = mother;
        this.father = father;

        this.mother.setFamily(this);
        this.father.setFamily(this);

        this.children = new Human[0];

    }

    public void addChild(Human child) {
        child.setFamily(this);
        Human[] newChild = Arrays.copyOf(children, children.length + 1);
        newChild[newChild.length - 1] = child;
        children = newChild;
    }
    public boolean deleteChild(Human child) {
        int index = -1;

        for (int i = 0; i < children.length; i++) {
            if (children[i].equals(child)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            int size = children.length -1;
            Human[] newChildren = new Human[size];
            System.arraycopy(children, 0, newChildren, 0, index);
            System.arraycopy(children, index+1, newChildren, index, size - index);
            children = newChildren;

            child.setFamily(null);
            return true;
        }
        return false;
    }

    public int countFamily(){
        return children.length + 2;
    }

    @Override
    public String toString() {
        return "Family{mother='" + this.mother + "', father='" + this.father + "', children=" + Arrays.toString(this.children) + ", pet=" + this.pet + ".";
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return  true;
        if (obj ==null || this.getClass() != obj.getClass()) return false;
        Family family = (Family) obj;
        return this.mother.equals(family.mother) &&
                this.father.equals(family.father) &&
                Arrays.equals(children, family.children) &&
                Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mother, father, pet);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }
}