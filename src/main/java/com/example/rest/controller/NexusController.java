package com.example.rest.controller;

import com.example.rest.model.nexus.NexusAssetResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nexus")
public class NexusController {

    @GetMapping("/listAssets")
    public NexusAssetResponse getAssets() {
        return new NexusAssetResponse();
    }
}
