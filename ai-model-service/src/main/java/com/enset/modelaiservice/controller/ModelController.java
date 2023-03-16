package com.enset.modelaiservice.controller;

import com.enset.modelaiservice.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelController {
    @Autowired
    private ModelService modelService;

    @GetMapping("/predict")
    public float predict(@RequestParam float[] input) {
        return modelService.predict(input);
    }
}