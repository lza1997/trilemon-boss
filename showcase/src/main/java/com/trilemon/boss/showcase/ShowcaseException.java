package com.trilemon.boss.showcase;

/**
 * @author kevin
 */
public class ShowcaseException extends Exception {
    public ShowcaseException(String message) {
        super(message);
    }
    public ShowcaseException(String message, Throwable cause) {
        super(message, cause);
    }
    public ShowcaseException(Throwable cause) {
        super(cause);
    }
}
