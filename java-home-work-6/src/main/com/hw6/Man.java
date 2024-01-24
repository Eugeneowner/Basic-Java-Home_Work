package main.com.hw6;

public final class Man extends Human {
    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Man() {
    }

    public Man(String name, String surname, int year, int iq, String[][] schedule) {
        super(name, surname, year, iq, schedule);
    }

    public void repairCar() {
        System.out.println("лагодити авто");
    }

    @Override
    public void greetPet() {
        System.out.println("Привіт як справи?, " + this.getFamily().getPet().getNickname());
    }
}
