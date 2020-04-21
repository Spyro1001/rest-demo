package com.example.rest.model.nexus;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NexusAssetResponse {

    private List<Item> items;
    private String continuationToken;

    public NexusAssetResponse() {
        this.items = new ArrayList<>();
        this.items.add(new Item());
        this.items.add(new Item());
    }

}
