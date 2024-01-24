package main.com.hw7;

import java.util.*;


public class Family implements HumanCreator {
    static {
        System.out.println("Loading new Class Family");
    }

    {
        System.out.println("Creating new Family Object");
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    private Set<Pet> pets;
    private Human mother;
    private Human father;
    private List<Human> children;

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

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
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
        this.pets = new HashSet<>();
        this.children = new ArrayList<>();

    }

    public void addPet(Pet pet) {
    pets.add(pet);
    }

    public void addChild(Human child) {
        children.add(child);
        child.setFamily(this);
    }

    public boolean deleteChild(Human child) {
        return children.remove(child);

    }


    public boolean deleteChild(int index) {
        return children.remove(index) == null ? false : true;

    }

    public int getChildIndex(Human child) {
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).equals(child)) {
                return i;
            }
        }
        return -1;
    }

    public int countFamily() {
        return children.size() + 2;
    }
    public Pet findOnePet(Pet onePet) {
        if (pets != null) {
            for (Pet pet : pets) {
                if (pet.equals(onePet)) {
                    return pet;
                }
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return "Family{mother='" + this.mother + "', father='" + this.father + "', children=" + this.children + ", pet=" + this.pets + "." ;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Family family = (Family) obj;
        return this.mother.equals(family.mother) && this.father.equals(family.father) && children.equals(family.children) && Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mother, father, pet);
        result = 31 * result + children.hashCode();
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