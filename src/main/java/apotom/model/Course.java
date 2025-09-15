package apotom.model;

public class Course implements IRatable, IDescribable {
    private final String name;
    private final String description;
    private final String platform;
    private double practicalSkillsScore;

    public Course(String name, String description, String platform,
                  double practicalSkillsScore) {
        this.name = name;
        this.description = description;
        this.platform = platform;
        this.practicalSkillsScore = practicalSkillsScore;
    }

    @Override
    public double calculateFinalRating(Criterion[] criteria) {
        double finalRating = 0;
        for (Criterion criterion : criteria) {
            if ("Практические навыки".equals(criterion.getName())) {
                finalRating += practicalSkillsScore * criterion.getWeight();
            }
        }
        return finalRating;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public String getPlatform() {
        return platform;
    }
}
