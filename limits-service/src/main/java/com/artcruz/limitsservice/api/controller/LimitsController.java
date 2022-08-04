package com.artcruz.limitsservice.api.controller;

import com.artcruz.limitsservice.config.Config;
import com.artcruz.limitsservice.model.entity.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private Config config;

    @GetMapping("/limits")
    public Limits retrieveLimits() {
        return new Limits().builder()
                .maximum(config.getMaximum())
                .minimum(config.getMinimum())
                .build();
    }

}
