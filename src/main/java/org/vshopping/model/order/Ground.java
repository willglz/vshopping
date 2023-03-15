package org.vshopping.model.order;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Ground implements Shipping{
    private static final double GROUND_COST = 5.00;
    @Override
    public double getCost() {
        return GROUND_COST;
    }
}
