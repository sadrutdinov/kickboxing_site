package com.sai.kickboxing_site.controllers;

import com.sai.kickboxing_site.entities.cost_of_training.TrainingCost;
import com.sai.kickboxing_site.services.TrainingCostService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/training_cost")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class TrainingCostController {


    private TrainingCostService trainingCostService;

    @GetMapping("")
    public String showAllTrainingCost(Model model) {

        List<TrainingCost> allTrainingCost = trainingCostService.getAll();

        model.addAttribute("allTrainingCost", allTrainingCost);

        return "all-TrainingCost";
    }

    @RequestMapping("/addNewTrainingCost")
    public String addNewTrainingCost(Model model) {

        TrainingCost trainingCost = new TrainingCost();
        model.addAttribute("TrainingCost", trainingCost);

        return "TrainingCost-info";
    }

    @RequestMapping("/saveTrainingCost")
    public String saveTrainingCost(@ModelAttribute("TrainingCost") TrainingCost trainingCost) {

        trainingCostService.save(trainingCost);

        return "redirect:/training_cost";
    }

    @RequestMapping("/updateTrainingCost")
    public String updateTrainingCost(@RequestParam("TrainingCostId") int id, Model model) {

        TrainingCost trainingCost = trainingCostService.getTrainingCost(id);

        model.addAttribute("TrainingCost", trainingCost);

        return "TrainingCost-info";
    }

    @RequestMapping("/deleteTrainingCost")
    public String deleteTrainingCost(@RequestParam("TrainingCostId") int id) {

        trainingCostService.deleteById(id);

        return "redirect:/training_cost";
    }
}
