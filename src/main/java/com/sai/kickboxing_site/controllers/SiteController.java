package com.sai.kickboxing_site.controllers;

import com.sai.kickboxing_site.entities.cost_of_training.TrainingCost;
import com.sai.kickboxing_site.entities.training_schedule.Training;
import com.sai.kickboxing_site.services.TrainingCostService;
import com.sai.kickboxing_site.services.TrainingService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;
import java.util.Comparator;
import java.util.List;


@Controller
@Slf4j
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SiteController {

    private TrainingCostService trainingCostService;
    private TrainingService trainingService;

    @GetMapping("/")
    public String showIndex(Model model, @RequestHeader HttpHeaders headers, HttpServletRequest httpServletRequest) {

        log.info("new guest");
        log.info("REQUEST: Host: " + httpServletRequest.getRemoteAddr() + ", URI: " + httpServletRequest.getRequestURI() + ", Headers: " + headers);

        List<TrainingCost> allTrainingCost = trainingCostService.getAll();
        allTrainingCost.sort(Comparator.comparing(TrainingCost::getDescription).reversed().thenComparing(TrainingCost::getPrice));

        List<Training> allTraining = trainingService.getAllTraining();
        allTraining.sort(Comparator.comparing(Training::getName).reversed());

        model.addAttribute("allTrainingCost", allTrainingCost);
        model.addAttribute("allTraining", allTraining);

        return "index";
    }
}
