package com.finwise.controller;

import com.finwise.service.PredictionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/predictions")
@RequiredArgsConstructor
public class PredictionController {

    private final PredictionService predictionService;


    @GetMapping("/generate/{familyProfileId}")
    public ResponseEntity<String> generatePredictionsForUser(@PathVariable Long familyProfileId) {
        predictionService.generateAndSaveOptimizedPredictions(familyProfileId);
        return ResponseEntity.ok("Predictions generated and stored successfully.");
    }
}
