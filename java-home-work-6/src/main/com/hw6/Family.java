package main.com.hw6;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;


public class Family implements HumanCreator {
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

    public Family(Human mother, Human father) {
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
            int size = children.length - 1;
            Human[] newChildren = new Human[size];
            System.arraycopy(children, 0, newChildren, 0, index);
            System.arraycopy(children, index + 1, newChildren, index, size - index);
            children = newChildren;

            child.setFamily(null);
            return true;
        }
        return false;
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.length) return false;
        Human child = this.children[index];
        Human[] newChildren = new Human[this.children.length - 1];
        System.arraycopy(this.children, 0, newChildren, 0, index);
        System.arraycopy(this.children, index + 1, newChildren, index, this.children.length - 1 - index);
        children = newChildren;
        child.setFamily(null);
        return true;
    }

    public int getChildIndex(Human child) {
        for (int i = 0; i < children.length; i++) {
            if (children[i].equals(child)) {
                return i;
            }
        }
        return -1;
    }

    public int countFamily() {
        return children.length + 2;
    }

    @Override
    public String toString() {
        return "Family{mother='" + this.mother + "', father='" + this.father + "', children=" + Arrays.toString(this.children) + ", pet=" + this.pet + ".";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Family family = (Family) obj;
        return this.mother.equals(family.mother) && this.father.equals(family.father) && Arrays.equals(children, family.children) && Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mother, father, pet);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Deleting from class Family object " + this);
        } finally {
            super.finalize();
        }
    }

    @Override
    public void bornChild(Human child) {
        Random random = new Random();
        int num = random.nextInt(0, 2);
        int nameIndex = random.nextInt(Names.values().length);
        int iq = (this.father.getIq() + this.mother.getIq()) / 2;
        if (num == 0) {
            Man man = new Man();
            man.setFamily(this);
            man.setSurname(this.father.getSurname());
            man.setName(String.valueOf(Names.values()[nameIndex]));
            man.setIq(iq);
            this.addChild(man);
        } else {
            Woman woman = new Woman();
            woman.setFamily(this);
            woman.setSurname(this.father.getSurname());
            woman.setName(String.valueOf(Names.values()[nameIndex]));
            woman.setIq(iq);
            this.addChild(woman);
        }

    }
}