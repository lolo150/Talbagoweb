package fr.talbagoweb.controller;

import fr.talbagoweb.model.Evaluation;
import fr.talbagoweb.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EvaluationController {

    @Autowired
    private EvaluationRepository evaluationRepository;

    @GetMapping("/evaluations")
    public String getAllEvaluations(Model model) {
        List<Evaluation> evaluations = evaluationRepository.findAll();
        model.addAttribute("evaluations", evaluations);
        return "evaluations";
    }
}
