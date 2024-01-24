package main.com.hw7;

import java.util.Map;

public final class Woman extends Human {
    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Woman() {
    }

    public Woman(String name, String surname, int year, int iq, Map<DayOfWeek,String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    public void makeup() {
        System.out.println("підфарбуватися");
    }

    @Override
    public void greetPet() {
        System.out.println("Привіт як справи?, " + this.getFamily().getPet().getNickname());
    }
}
