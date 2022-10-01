import java.text.DecimalFormat;

/* Class Dish makes it easier to store information about the various dishes ordered.
* Parameters are:
*  - name: The name of the dish (String)
*  - price: The price of the dish (double)
*  - amt: The amount of the dish ordered (int) */

public class Dish {
    final String name;
    final double price;
    final int amt;
    final double totalPrice;

    DecimalFormat formatter = new DecimalFormat("0.00");

    Dish(String inName, double inPrice, int inAmt) {
        name = inName;
        price = inPrice;
        amt = inAmt;
        totalPrice = price * amt;
    }

    public void printData(int i) {
        System.out.printf("%d - %d order(s) of %s for $%s0 each.\n\n", i, amt, name, price);
    }
}
