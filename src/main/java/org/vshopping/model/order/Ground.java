package org.vshopping.model.order;

public class Ground implements Shipping{
    private static final double GROUND_COST = 5.00;
    @Override
    public double getCost() {
        return GROUND_COST;
    }
}
