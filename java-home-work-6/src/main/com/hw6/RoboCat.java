package main.com.hw6;

public class RoboCat extends Pet {
    public RoboCat(Species species, String nickname) {
        super(species, nickname);
    }

    public RoboCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    public RoboCat() {
    }

    @Override
    public void respond()
    {
        System.out.println("Привіт, хазяїн. Я - " + this.getNickname() + ". Я скучив!");
    }
}
