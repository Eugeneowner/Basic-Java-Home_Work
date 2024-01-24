package main.com.hw6;

public class DomesticCat extends Pet implements Foul {
    public DomesticCat(Species species, String nickname) {
        super(species, nickname);
    }

    public DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    public DomesticCat() {
    }

    @Override
    public void respond() {
        System.out.println("Привіт, хазяїн. Я - " + this.getNickname() + ". Я скучив!");
    }
    @Override
    public void foul() {
        System.out.println("Потрібно добре замести сліди...");
    }
}
