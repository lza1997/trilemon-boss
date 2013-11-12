package com.trilemon.boss.shelf;

/**
 * @author kevin
 */
public class ShelfException extends Exception {
    public ShelfException(String message) {
        super(message);
    }
    public ShelfException(String message, Throwable cause) {
        super(message, cause);
    }
    public ShelfException(Throwable cause) {
        super(cause);
    }
}
