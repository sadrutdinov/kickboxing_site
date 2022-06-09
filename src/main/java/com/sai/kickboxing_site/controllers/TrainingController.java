package com.sai.kickboxing_site.controllers;

import com.sai.kickboxing_site.entities.training_schedule.Training;
import com.sai.kickboxing_site.services.TrainingService;
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
@RequestMapping("/training_schedule")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class TrainingController {


    private TrainingService trainingService;

    @GetMapping("")
    public String showAllTraining(Model model) {

        List<Training> allTraining = trainingService.getAllTraining();

        model.addAttribute("allTraining", allTraining);

        return "all-Training";
    }

    @RequestMapping("/addNewTraining")
    public String addNewTrainingCost(Model model) {

        Training training = new Training();
        model.addAttribute("Training", training);

        return "Training-info";
    }

    @RequestMapping("/saveTraining")
    public String saveTrainingCost(@ModelAttribute("Training") Training Training) {

        trainingService.save(Training);

        return "redirect:/training_schedule";
    }

    @RequestMapping("/updateTraining")
    public String updateTrainingCost(@RequestParam("TrainingId") int id, Model model) {

        Training training = trainingService.getTrainingById(id);

        model.addAttribute("Training", training);

        return "Training-info";
    }

    @RequestMapping("/deleteTraining")
    public String deleteTrainingCost(@RequestParam("TrainingId") int id) {

        trainingService.deleteTrainingById(id);

        return "redirect:/training_schedule";
    }
}
