package com.example.orders.service;

/** Added 134617 to give the incremental path a real diff. */
public final class OrderTotals {
    private OrderTotals() {}
    public static long withTax(long cents, int bps) {
        return cents + (cents * bps) / 10000L;
    }
}
