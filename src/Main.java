import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {
//    Displays an inputted order nicely:
    public static void dispOrder(TipCalc order) {
        System.out.println("\nYou have ordered:\n");
        ArrayList<Dish> dishes = order.getDishes();

        for (int i=0; i<dishes.size(); i++) {
            dishes.get(i).printData(i + 1);
        }

        System.out.printf("In total your order comes out to $%s0.\n", order.getTotalBefore());
    }

    public static void main(String[] args) {
        // Lists to store the dishes in the order:
        TipCalc calc;
        DecimalFormat formatter = new DecimalFormat("0.00");
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of people to split the bill: ");
        int numPeople = input.nextInt();
        System.out.print("Enter tip percent (Whole number): %");
        int tipPercent = input.nextInt();

        calc = new TipCalc(numPeople, tipPercent);

        boolean ordering = true;
        String selection;

        System.out.println("\nNote: It is mandatory to read all text in a French accent.\n\n");
        System.out.println("Bonjour mesdames et messieurs. Welcome to our fine restaurant.");

        while (ordering) {
            // Menu for ordering:
            System.out.println("\nHow may I help you?\n");
            System.out.println("Options: ");
            System.out.println("1. I would like to add a dish to my order.");
            System.out.println("2. Could you please repeat my order to me?");
            System.out.println("3. I have changed my mind. I would like to remove one of my dishes.");
            System.out.println("4. I believe that will be all. Please send the order to the chef.\n");
            System.out.print("Selection: ");

//          Get user selection
            selection = input.nextLine();


            switch (selection) {
                // Adds a dish to the order. The dish's name and quantity is chosen by the user, and the price is random:
                case "1" -> {
                    String dishName;

                    // Generates a random price for the dish between 4 and 75:
                    double dishPrice = (int) Math.max(Math.random() * 75, 4);
                    int dishAmt;

                    // This section gets the data for the new dish:
                    System.out.print("\nCould you please tell me the name of the dish you wish to order: ");
                    dishName = input.nextLine();
                    System.out.printf("\nThat will be $%s0. I hope that will be acceptable.\n", dishPrice);
                    System.out.print("\nHow many platters would you like to order: ");
                    dishAmt = input.nextInt();
                    System.out.println("Excellent choice.");

                    calc.addDish(dishName, dishPrice, dishAmt);
                    input.nextLine();
                    input.nextLine();
                }
                case "2" -> {
                    // If option 2 is chosen, the order is shown to the user.
                    dispOrder(calc);
                    input.nextLine();
                }
                case "3" -> {
                    // If option 3 is chosen, the user is prompted to remove an item from their order.
                    dispOrder(calc);
                    System.out.print("\nWhich item would you like me to take off of the list? (Num): ");
                    calc.remove(input.nextInt() - 1);
                    input.nextLine();
                    System.out.println("\n\nUnderstandable, it will be swiftly removed.");
                    input.nextLine();
                }
                case "4" -> {
                    // Ends the loop after displaying the order one last time:
                    System.out.println("\nI shall quickly go over your order once more.");
                    dispOrder(calc);
                    System.out.println("It will be ready soon.");
                    ordering = false;
                }
                default -> System.out.println("\n\nI am terribly sorry, I did not understand what you said.\n");
            }
        }

        System.out.println("\n\n------------------------\n");
        System.out.println("Much happy eating later...");
        System.out.println("\n------------------------\n\n");


        System.out.println("\n>------------------<");
        dispOrder(calc);

        System.out.println("\nTotal bill: $" + formatter.format(calc.totalBill()));
        System.out.println("Total tip: $" + formatter.format(calc.totalTip()));
        System.out.println("Bill per person: $" + formatter.format(calc.billPer()));
        System.out.println("Tip per person: $" + formatter.format(calc.tipPer()));
        System.out.println("\n>------------------<\n");
    }
}