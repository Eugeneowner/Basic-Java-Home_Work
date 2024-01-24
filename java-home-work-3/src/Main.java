import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scannerIn = new Scanner(System.in);
        String[][] scedule = new String[7][2];
        scedule[0][0] = "Sunday";
        scedule[0][1] = "Do home work";
        scedule[1][0] = "Monday";
        scedule[1][1] = "Go to courses";
        scedule[2][0] = "Tuesday";
        scedule[2][1] = "Meet with friends";
        scedule[3][0] = "Wednesday";
        scedule[3][1] = "Work on programming project home work";
        scedule[4][0] = "Thursday";
        scedule[4][1] = "Visit to gym";
        scedule[5][0] = "Friday";
        scedule[5][1] = "Study on programming";
        scedule[6][0] = "Saturday";
        scedule[6][1] = "Relax and have fun";
        while (true) {
            System.out.println("Please, input the day of the week:");
            String day = scannerIn.nextLine().toLowerCase();
            String[] changeDay = day.split(" ");
            if (changeDay.length == 2) {
                String command = changeDay[0];
                String weekDay = changeDay[1];
                switch (command) {
                    case ("exit"):
                        return;

                    default:
                        System.out.println("Sorry, I don't understand you, please try again.");
                        break;
                    case ("change"):
                    case ("reschedule"): {
                        switch (weekDay) {
                            case "sunday":
                                System.out.println("Please, input new tasks for " + scedule[0][0] + ".");
                                String changeSunday = scannerIn.nextLine().toLowerCase();
                                scedule[0][1] = changeSunday;
                                break;
                            case "monday":
                                System.out.println("Please, input new tasks for " + scedule[1][0] + ".");
                                String changeMonday = scannerIn.nextLine().toLowerCase();
                                scedule[1][1] = changeMonday;
                                break;
                            case "tuesday":
                                System.out.println("Please, input new tasks for " + scedule[2][0] + ".");
                                String changeTuesday = scannerIn.nextLine().toLowerCase();
                                scedule[2][1] = changeTuesday;
                                break;
                            case "wednesday":
                                System.out.println("Please, input new tasks for " + scedule[3][0] + ".");
                                String changeWednesday = scannerIn.nextLine().toLowerCase();
                                scedule[3][1] = changeWednesday;
                                break;
                            case "thursday":
                                System.out.println("Please, input new tasks for " + scedule[4][0] + ".");
                                String changeThursday = scannerIn.nextLine().toLowerCase();
                                scedule[4][1] = changeThursday;
                                break;
                            case "friday":
                                System.out.println("Please, input new tasks for " + scedule[5][0] + ".");
                                String changeFriday = scannerIn.nextLine().toLowerCase();
                                scedule[5][1] = changeFriday;
                                break;
                            case "saturday":
                                System.out.println("Please, input new tasks for " + scedule[6][0] + ".");
                                String changeSaturday = scannerIn.nextLine().toLowerCase();
                                scedule[6][1] = changeSaturday;
                                break;
                            case "exit":
                                return;
                            default:
                                System.out.println("Sorry, I don't understand you, please try again.");
                                break;
                        }
                    }
                }

            } else {
                switch (day.trim()) {
                    case ("sunday"):
                        System.out.println("Your tasks for " + scedule[0][0] + " : " + scedule[0][1]);
                        break;
                    case ("monday"):
                        System.out.println("Your tasks for " + scedule[1][0] + " : " + scedule[1][1]);
                        break;
                    case ("tuesday"):
                        System.out.println("Your tasks for " + scedule[2][0] + " : " + scedule[2][1]);
                        break;
                    case ("wednesday"):
                        System.out.println("Your tasks for " + scedule[3][0] + " : " + scedule[3][1]);
                        break;
                    case ("thursday"):
                        System.out.println("Your tasks for " + scedule[4][0] + " : " + scedule[4][1]);
                        break;
                    case ("friday"):
                        System.out.println("Your tasks for " + scedule[5][0] + " : " + scedule[5][1]);
                        break;
                    case ("saturday"):
                        System.out.println("Your tasks for " + scedule[6][0] + " : " + scedule[6][1]);
                        break;
                    case ("exit"):
                        return;
                    default:
                        System.out.println("Sorry, I don't understand you, please try again.");
                        break;
                }
            }
        }
    }
}