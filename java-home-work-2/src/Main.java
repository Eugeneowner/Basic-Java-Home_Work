import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] gameBoard = {
                {'0', '1', '2', '3', '4', '5'},
                {'1', '-', '-', '-', '-', '-'},
                {'2', '-', '-', '-', '-', '-'},
                {'3', '-', '-', '-', '-', '-'},
                {'4', '-', '-', '-', '-', '-'},
                {'5', '-', '-', '-', '-', '-'}
        };

        Random random = new Random();
        int targetRow = random.nextInt(3) + 1;
        int targetColumn = random.nextInt(3) + 1;
        boolean isHorizontal = random.nextBoolean();

        System.out.println("All Set. Get ready to rumble!");

        Scanner scanner = new Scanner(System.in);

        int hitsCounter = 0;

        while (true) {
            displayGameBoard(gameBoard);

            int guessRow = getValidInput("Enter the row (1-5): ", scanner);
            int guessColumn = getValidInput("Enter the column (1-5): ", scanner);

            if (!isAlreadyHit(guessRow, guessColumn, gameBoard) &&
                    checkHit(guessRow, guessColumn, targetRow, targetColumn, isHorizontal)) {
                System.out.println("Hit!");
                markTarget(gameBoard, targetRow, targetColumn, isHorizontal, hitsCounter);
                hitsCounter++;

                if (hitsCounter == 3) {
                    System.out.println("You have won!");
                    displayGameBoard(gameBoard);
                    break;
                }
            } else {
                System.out.println("Missed! Try again.");
                gameBoard[guessRow][guessColumn] = '*';
            }
        }

        scanner.close();
    }

    private static boolean isAlreadyHit(int guessRow, int guessColumn, char[][] gameBoard) {
        return gameBoard[guessRow][guessColumn] == 'x' || gameBoard[guessRow][guessColumn] == 'o';
    }

    private static void markTarget(char[][] gameBoard, int targetRow, int targetColumn, boolean isHorizontal, int hitsCounter) {
        if (isHorizontal) {
            gameBoard[targetRow][targetColumn + hitsCounter] = 'x';
        } else {
            gameBoard[targetRow + hitsCounter][targetColumn] = 'x';
        }
    }

    private static boolean checkHit(int guessRow, int guessColumn, int targetRow, int targetColumn, boolean isHorizontal) {
        return isHorizontal ?
                guessRow == targetRow && guessColumn >= targetColumn && guessColumn < targetColumn + 3 :
                guessRow >= targetRow && guessRow < targetRow + 3 && guessColumn == targetColumn;
    }

    private static void displayGameBoard(char[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int getValidInput(String message, Scanner scanner) {
        int input;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= 1 && input <= 5) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
        return input;
    }
}
