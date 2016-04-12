package ist.es.refactorings;

import java.util.ArrayList;
import java.util.List;

public class ExtractMethodExample {

    /**
     * Orders issued by a given client, initialized somewhere
     */
    private final List<Order> orders = new ArrayList<Order>();

    /**
     * @param outstanding
     * @return
     */
    private double computeDivida(double outstanding) {
        // calculate outstanding
        for (final Order o : orders) {
            outstanding += o.getAmount();
        }
        return outstanding;
    }

    /**
     * @param clientName
     * @param outstanding
     */
    private void imprimiteTotal(String clientName, double outstanding) {
        //print debt and details
        System.out.println("name:" + clientName);
        System.out.println("amount" + outstanding);
    }

    /**
     * 
     */
    private void printHeader() {
        System.out.println("************************");
        System.out.println("**** Customer Owes *****");
        System.out.println("************************");
    }

    /**
     * Prints the amount owned by a given client.
     * 
     * @param clientName the client name
     */
    void printOwing(String clientName) {
        double outstanding = 0.0;

        /*
         * Try the "Extract Method" refactoring on Eclipse selecting a 
         * block of code and pressing   
         */

        // print banner
        printHeader();

        outstanding = computeDivida(outstanding);

        imprimiteTotal(clientName, outstanding);
    }
};

class Order {
    final int amount;
    final String orderName;

    public Order(String orderName, int amount) {
        this.orderName = orderName;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
