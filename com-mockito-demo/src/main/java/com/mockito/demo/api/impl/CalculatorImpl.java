package com.mockito.demo.api.impl;

import com.mockito.demo.api.Calculator;
import com.mockito.demo.exception.DemoException;

/**
 * Created by CongDanh on 8/18/15.
 */
public class CalculatorImpl implements Calculator {

    private static final String DEMO_MESSAGE_EXCEPTION = "This exception was expected to check Calculator!!!";

    @Override
    public int totalByFirst(int first, int second, int last) {
        switch (first) {
            case 0:
                return second + last;
            case 1:
                return first + second;
            case 2:
                return second + last;
            case 3:
                return first + last;
            default:
                return first + second + last;
        }
    }

    @Override
    public double sum(int products, double cost) throws DemoException {
        if (products <= 0 || cost <= 0) {
            throw new DemoException(DEMO_MESSAGE_EXCEPTION);
        }

        double total = products * cost;
        if (products >= 2 && products < 5) {
            return total - (total * DISCOUNT_2);
        }

        if (products >= 5 && products < 7) {
            return total - (total * DISCOUNT_5);
        }

        if (products >= 7 && products < 10) {
            return total - (total * DISCOUNT_7);
        }
        return total - (total * DISCONT_OVER);
    }
}
