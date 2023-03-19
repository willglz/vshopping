package org.vshopping.model.data;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class DataSource<T> {
    @Getter
    private List<T> dataSource;

    public DataSource(List<T> dataSource) {
        this.dataSource = new ArrayList<>();
    }
}
