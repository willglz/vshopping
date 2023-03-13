package org.vshopping.model.order;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class OrderDS {
    @Getter
    private static List<Order> dataSource;

    static {
        dataSource = new ArrayList<>();
    }
}
