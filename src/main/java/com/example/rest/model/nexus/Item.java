package com.example.rest.model.nexus;

import lombok.Data;

@Data
public class Item {

    private String downloadUrl;
    private String path;
    private String id;
    private String repository;
    private String format;
    private CheckSum checksum;

    public Item() {
        this.checksum = new CheckSum();
    }

}
