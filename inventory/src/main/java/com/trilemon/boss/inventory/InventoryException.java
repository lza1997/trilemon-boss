package com.trilemon.boss.inventory;

/**
 * @author kevin
 */
public class InventoryException extends Exception {

    public InventoryException(String msg) {
        super(msg);
    }

    public InventoryException(String msg,Exception e) {
        super(msg,e);
    }

    public InventoryException(Exception e) {
        super(e);
    }
}
