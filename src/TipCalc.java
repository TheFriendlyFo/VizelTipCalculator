import java.util.ArrayList;

public class TipCalc {
    private final int numPeople;
    private final int tip;
    private final ArrayList<Dish> dishes;
    double totalBefore;

    TipCalc(int numPeople, int tip) {
        this.numPeople = numPeople;
        this.tip = tip;
        this.totalBefore = 0.0;
        dishes = new ArrayList<>();
    }

    public void addDish(String name, double price, int amt) {
        dishes.add(new Dish(name, price, amt));
        totalBefore += price * amt;
    }

    // Getters
    public double getTotalBefore() {return totalBefore;}
    public int getTip() {return tip;}
    public ArrayList<Dish> getDishes() {return dishes;}

    // Bill calculators:
    public double totalTip() {return tip * totalBefore / 100;}
    public double totalBill() {return totalTip() + totalBefore;}
    public double billPer() {return totalBefore / numPeople;}
    public double tipPer() {return totalTip() / numPeople;}
    public double totalPer() {return totalBill() / numPeople;}
    public void remove(int i) {dishes.remove(i);}
}
