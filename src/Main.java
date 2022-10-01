import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {
    public static void dispOrder(ArrayList<Dish> order) {
        double totalPrice = 0;

        System.out.println("\nYour order consists of the following:\n");

        for (int i=0; i<order.size(); i++) {
            Dish dish = order.get(i);
            totalPrice += dish.totalPrice;
            dish.printData(i + 1);
        }

        System.out.printf("In total your order comes out to $%s0.\n", totalPrice);
    }

    public static void main(String[] args) {
        // Lists to store the dishes in the order:
        ArrayList<Dish> order = new ArrayList<>();
        DecimalFormat formatter = new DecimalFormat("0.00");
        Scanner input = new Scanner(System.in);

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

            selection = input.nextLine();


            switch (selection) {
                // Adds a dish to the order. The dish's name and quantity is chosen by the user, and the price is random:
                case "1":
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
                    System.out.printf("\nAlright, that will be %d order(s) of %s for $%s0 each.\n", dishAmt, dishName, dishPrice);

                    order.add(new Dish(dishName, dishPrice, dishAmt));

                    input.nextLine();
                    input.nextLine();

                    break;
                case "2":
                    // If option 2 is chosen, the order is shown to the user.
                    dispOrder(order);
                    input.nextLine();
                    break;
                case "3":
                    // If option 3 is chosen, the user is prompted to remove an item from their order.
                    dispOrder(order);
                    System.out.print("\nWhich item would you like me to take off of the list? (Num): ");
                    order.remove(input.nextInt()-1);
                    input.nextLine();

                    System.out.println("\n\nUnderstandable, it will be swiftly removed.");
                    input.nextLine();
                    break;
                case "4":
                    dispOrder(order);
                    ordering = false;
                    break;

                default:
                    System.out.println("I am terribly sorry, I did not understand what you said. Could you repeat that?");
                    break;
            }
        }
    }
}