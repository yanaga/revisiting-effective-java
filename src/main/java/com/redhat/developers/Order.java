package com.redhat.developers;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order {

    private final Date date;

    private final List<OrderItem> items;

    private Order(Date date, List<OrderItem> items) {
        this.date = date;
        this.items = items;
    }

    public static Order of(Date date, List<OrderItem> items) {
        Objects.requireNonNull(date);
        return new Order(new Date(date.getTime()), new ArrayList<>(items));
    }

    public Date getDate() {
        return new Date(date.getTime());
    }

    public void addItem(OrderItem item) {

    }

    public List<OrderItem> getItems() {
        return ImmutableList.copyOf(items);
    }

}
