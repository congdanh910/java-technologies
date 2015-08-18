package com.mockito.demo.api;

import com.mockito.demo.exception.DemoException;

/**
 * Created by CongDanh on 8/18/15.
 */
public interface Calculator {
    public static final double DISCOUNT_2 = 0.1;
    public static final double DISCOUNT_5 = 0.15;
    public static final double DISCOUNT_7 = 0.18;
    public static final double DISCONT_OVER = 0.2;

    public int totalByFirst(int first, int second, int last);

    public double sum(int products, double cost) throws DemoException;
}
