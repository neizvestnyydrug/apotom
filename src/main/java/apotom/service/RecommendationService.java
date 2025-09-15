package apotom.service;

import apotom.model.Course;
import apotom.model.Criterion;
import apotom.model.IRatable;
import apotom.model.University;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class RecommendationService {

    private List<IRatable> allEducationalOptions;

    public RecommendationService() {
        this.allEducationalOptions = new ArrayList<>();

        // Добавляем университеты
        allEducationalOptions.add(new University(
                "МФТИ", "Московский Физтех", 4.8, "Москва",
                95.0, 90.0, 80.0));
        allEducationalOptions.add(new University(
                "ВШЭ", "Высшая Школа Экономики", 4.5, "Москва",
                85.0, 70.0, 85.0));

        // Добавляем курсы
        allEducationalOptions.add(new Course(
                "Machine Learning", "Курс по машинному обучению",
                "Coursera", 90.0));
    }

    public List<IRatable> getRecommendations(Criterion[] userCriteria, int count) {
        // Сортируем по рейтингу, рассчитанному по критериям пользователя
        allEducationalOptions.sort(Comparator.comparingDouble(
                option -> -option.calculateFinalRating(userCriteria)));

        // Возвращаем топ-N рекомендаций
        return allEducationalOptions.subList(0,
                Math.min(count, allEducationalOptions.size()));
    }
}
