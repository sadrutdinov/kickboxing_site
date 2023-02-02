package com.sai.kickboxing_site.controllers;

import com.sai.kickboxing_site.models.TrainingCost;
import com.sai.kickboxing_site.services.TrainingCostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/training_cost")
public class TrainingCostController {

    private final TrainingCostService trainingCostService;

    public TrainingCostController(TrainingCostService trainingCostService) {
        this.trainingCostService = trainingCostService;
    }

    @GetMapping("")
    public String showAllTrainingCost(Model model) {
        model.addAttribute("allTrainingCost", trainingCostService.getAll());
        return "all-TrainingCost";
    }

    @GetMapping("/addNewTrainingCost")
    public String addNewTrainingCost(Model model) {
        model.addAttribute("trainingCost", new TrainingCost());
        return "TrainingCost-info";
    }

    @RequestMapping("/saveTrainingCost")
    public String saveTrainingCost(@ModelAttribute("trainingCost") TrainingCost trainingCost) {
        trainingCostService.save(trainingCost);
        return "redirect:/training_cost";
    }

    @GetMapping("/updateTrainingCost")
    public String updateTrainingCost(@RequestParam("TrainingCostId") int id, Model model) {
        model.addAttribute("trainingCost", trainingCostService.getTrainingCostById(id));
        return "TrainingCost-info";
    }

    @GetMapping("/deleteTrainingCost")
    public String deleteTrainingCost(@RequestParam("TrainingCostId") int id) {
        trainingCostService.deleteTrainingCostById(id);
        return "redirect:/training_cost";
    }
}
