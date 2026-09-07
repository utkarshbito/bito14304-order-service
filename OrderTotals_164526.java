package com.example.orders.service;

/** Added 164526 to give the incremental path a real diff. */
public final class OrderTotals {
    private OrderTotals() {}
    public static long withTax(long cents, int bps) {
        return cents + (cents * bps) / 10000L;
    }
}
