package main.com.hw5;

public enum Species {
    DACHSHUND(false, 4, true),
    GERMAN_SHEPHERD(false, 4, true),
    BULLDOG(false, 4, true),
    GOLDEN_RETRIEVER(false, 4, true),
    POODLE(false, 4, true),
    BEAGLE(false, 4, true),
    SIBERIAN_HUSKY(false, 4, true),
    CHIHUAHUA(false, 4, true),
    BOXER(false, 4, true);

    public boolean canFly;
    public int numberOfLegs;
    public boolean hasFur;

    Species(boolean canFly, int numberOfLegs, boolean hasFur){
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public boolean isHasFur() {
        return hasFur;
    }

    public void setHasFur(boolean hasFur) {
        this.hasFur = hasFur;
    }



}
