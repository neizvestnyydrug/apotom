package apotom.controller;

import apotom.model.Criterion;
import apotom.model.IRatable;
import apotom.service.RecommendationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/apotom")
    public List<IRatable> getRecommendations(
            @RequestParam(required = false, defaultValue = "5") int count) {

        Criterion[] userCriteria = {
                new Criterion("Карьерный рост", 0.5),
                new Criterion("Наука", 0.3),
                new Criterion("Атмосфера", 0.2)
        };

        return recommendationService.getRecommendations(userCriteria, count);
    }
}
