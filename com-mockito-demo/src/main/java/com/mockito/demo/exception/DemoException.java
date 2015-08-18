package com.mockito.demo.exception;

/**
 * Created by CongDanh on 8/18/15.
 */
public class DemoException extends Exception {

    public DemoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DemoException(String message) {
        super(message);
    }
}
