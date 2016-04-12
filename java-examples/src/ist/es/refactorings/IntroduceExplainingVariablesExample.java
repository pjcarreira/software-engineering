package ist.es.refactorings;

public class IntroduceExplainingVariablesExample {

    private static final int DISCOUNT_ITEM_QTY_LIMIT = 500;
    int quantity;
    double itemPrice;

    /**
     * An implementation of <code>getPrice</code> to be refactored.
     * <p>
     * Still very confusing.
     */
    double getPrice() {
        // price is base price - quantity discount + shipping
        return quantity * itemPrice - Math.max(0, quantity - 500) * itemPrice * 0.05
                + Math.min(quantity * itemPrice * 0.1, 100.0);
    }

    /*
     * Refactoring sequence using 'introduce variable'. In Eclipse press ALT + SHIFT + L.  
     */

    /**
     * The initial <code>getPrice</code> to be refactored.
     * <p>
     * Still confusing.
     */
    double getPrice0() {
        // price is base price - quantity discount + shipping
        return quantity * itemPrice - Math.max(0, quantity - 500) * itemPrice * 0.05
                + Math.min(quantity * itemPrice * 0.1, 100.0);
    }

    /**
     * First refactoring of <code>getPrice</code>.
     * <p>
     * Adds <code>basePrice</code> variable. 
     */
    double getPrice1() {
        // price is base price - quantity discount + shipping
        final double basePrice = quantity * itemPrice;
        return basePrice - Math.max(0, quantity - 500) * itemPrice * 0.05
                + Math.min(quantity * itemPrice * 0.1, 100.0);
    }

    /**
     * Second refactoring of <code>getPrice</code>.
     * <p>
     * Adds <code>quantityDiscount</code> variable. 
     */
    double getPrice2() {
        // price is base price - quantity discount + shipping
        final double basePrice = quantity * itemPrice;
        final double quantityDiscount = Math.max(0, quantity - 500) * itemPrice * 0.05;
        return basePrice - quantityDiscount + Math.min(basePrice * 0.1, 100.0);
    }

    /**
     * Third refactoring of <code>getPrice</code>.
     * <p>
     * Adds <code>shipping</code> variable. 
     */
    double getPrice3() {
        final double basePrice = quantity * itemPrice;
        final double quantityDiscount = Math.max(0, quantity - 500) * itemPrice * 0.05;
        final double shipping = Math.min(basePrice * 0.1, 100.0);
        return basePrice - quantityDiscount + shipping;
    }
    
    /*
     * To use extact constant: select a constant, press 
     * ALT + SHIFT + S and the select "Extract Constant" 
     */
    
    /**
     * Final refactoring of <code>getPrice</code>.
     * <p>
     * Adds <code>DISCOUNT_ITEM_QTY_LIMIT</code> constant. 
     */
    double getPrice4() {
        final double basePrice = quantity * itemPrice;
        final double quantityDiscount = Math.max(0, quantity - DISCOUNT_ITEM_QTY_LIMIT) * itemPrice * 0.05;
        final double shipping = Math.min(basePrice * 0.1, 100.0);
        return basePrice - quantityDiscount + shipping;
    }

}
