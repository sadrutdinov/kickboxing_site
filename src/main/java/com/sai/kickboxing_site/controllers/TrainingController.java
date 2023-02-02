package com.sai.kickboxing_site.controllers;

import com.sai.kickboxing_site.models.Training;
import com.sai.kickboxing_site.services.TrainingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/training_schedule")
public class TrainingController {

    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping("")
    public String showAllTraining(Model model) {
        model.addAttribute("allTraining", trainingService.getAllTraining());
        return "all-Training";
    }

    @GetMapping("/addNewTraining")
    public String addNewTraining(Model model) {
        model.addAttribute("Training", new Training());
        return "Training-info";
    }

    @RequestMapping("/saveTraining")
    public String saveTraining(@ModelAttribute("Training") Training Training) {
        trainingService.save(Training);
        return "redirect:/training_schedule";
    }

    @GetMapping("/updateTraining")
    public String updateTraining(@RequestParam("TrainingId") int id, Model model) {
        model.addAttribute("Training", trainingService.getTrainingById(id));
        return "Training-info";
    }

    @GetMapping("/deleteTraining")
    public String deleteTraining(@RequestParam("TrainingId") int id) {
        trainingService.deleteTrainingById(id);
        return "redirect:/training_schedule";
    }
}
