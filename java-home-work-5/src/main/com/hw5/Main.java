package main.com.hw5;

public class Main {
    public static void main(String[] args) {
        String[] habits = {"sleep", "eat"};
        String[][] schedule = {
                {DayOfWeek.MONDAY.name(), "Learn programing java"},
                {DayOfWeek.TUESDAY.name(), "Doctor's visit"},
                {DayOfWeek.WEDNESDAY.name(), "Spending time with family"},
                {DayOfWeek.THURSDAY.name(), "A trip to the store for a shopping spree"},
                {DayOfWeek.FRIDAY.name(), "A corporate call in"},
                {DayOfWeek.SATURDAY.name(), "Going to the shooting range with your friends"},
                {DayOfWeek.SUNDAY.name(), "A trip to my parents' house"}

        };
        Human father = new Human("Eugen", "Lobok", 1986, 100, schedule);
        System.out.println(father);
        Human mather = new Human("Tatiayna", "Lobok", 1995, 100, schedule);
        System.out.println(mather);

        Family family = new Family(mather, father);

        Human child1 = new Human("Danya", "Lobok", 2021, 100, schedule);
        System.out.println(child1);

        Human child2 = new Human("David", "Lobok", 2015, 100, schedule);
        System.out.println(child2);

        Human child3 = new Human("Dima", "Dima", 2020, 100, schedule);
        System.out.println(child3);

        Human child4 = new Human("Dimaaaaa", "Dimaaaaa", 2020, 100, schedule);
        System.out.println(child4);

        family.addChild(child1);
        family.addChild(child2);
        family.addChild(child3);
        family.addChild(child4);
        family.deleteChild(child3);
        family.deleteChild(family.getChildIndex(child4));

        Pet pet = new Pet(Species.BEAGLE, "Pet", 3, 49, habits);
        family.setPet(pet);

        System.out.println(family);

        for (int i = 0; i < 10000001; i++) {
            Human human = new Human();
        }
    }
}
