import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Let the game begin!");
        System.out.println("Please enter your name:");

        String name = scanner.nextLine();

        int[] guesses = new int[100]; 


        String[][] yearsAndEvents = {
                {"1914", "World War I began"},
                {"1939", "World War II began"}
        };

        String[] choices = new String[yearsAndEvents.length];
        int index = 0;
        int guessCount = 0; 
        int answers = 0;



        while (answers < yearsAndEvents.length) {
            int indexRandom = random.nextInt(yearsAndEvents.length);

            String story = yearsAndEvents[indexRandom][1];

            for (String yearsAnsw : choices) {
                if (Objects.equals(yearsAnsw, story)) {
                    break;
                } else {
                    int yearAnswer = Integer.parseInt(yearsAndEvents[indexRandom][0]);
                    System.out.println("When did the " + story + "begin?");


                    while (!scanner.hasNextInt()) {
                        System.out.println("Please enter a valid number.");
                        scanner.next();
                        System.out.println("Year?");
                    }

                    int guess = scanner.nextInt();
                    guesses[guessCount] = guess; 
                    guessCount++;

                    if (guess == yearAnswer) {
                        System.out.println("Correct!");
                        answers++;
                    } else if (guess < yearAnswer) {
                        System.out.println("Your number is too small. Please, try again.");
                        continue;
                    } else {
                        System.out.println("Your number is too big. Please, try again.");
                        continue;

                    }
                    choices[index] = story;
                    index++;

                    break;
                }
            }
        }

        System.out.println("Congratulations," + name + "You answered all questions.");
        System.out.println("Your numbers: ");
        for (int i = 0; i < guessCount; i++) {
            System.out.print(guesses[i] + "\n");
        }

        scanner.close();
    }
}
