package com.trilemon.top.boss360.shelf.service;

import org.springframework.stereotype.Service;

/**
 * @author kevin
 */
@Service
public class ApplicationService {

    public String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
