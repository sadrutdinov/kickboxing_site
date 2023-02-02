package com.sai.kickboxing_site.controllers;

import com.sai.kickboxing_site.services.TrainingCostService;
import com.sai.kickboxing_site.services.TrainingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class SiteController {

    private final TrainingCostService trainingCostService;
    private final TrainingService trainingService;

    public SiteController(TrainingCostService trainingCostService, TrainingService trainingService) {
        this.trainingCostService = trainingCostService;
        this.trainingService = trainingService;
    }

    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("allTrainingCost", trainingCostService.getAll());
        model.addAttribute("allTraining", trainingService.getAllTraining());
        return "index";
    }
}
