package apotom.model;

public class University extends EducationalOption {
    private final String location;
    private double careerGrowthScore;
    private double scienceScore;
    private double atmosphereScore;

    public University(String name, String description, double baseRating,
                      String location, double careerGrowthScore,
                      double scienceScore, double atmosphereScore) {
        super(name, description, baseRating);
        this.location = location;
        this.careerGrowthScore = careerGrowthScore;
        this.scienceScore = scienceScore;
        this.atmosphereScore = atmosphereScore;
    }

    @Override
    public double calculateFinalRating(Criterion[] criteria) {
        double finalRating = getBaseRating();
        for (Criterion criterion : criteria) {
            switch (criterion.getName()) {
                case "Карьерный рост":
                    finalRating += careerGrowthScore * criterion.getWeight();
                    break;
                case "Наука":
                    finalRating += scienceScore * criterion.getWeight();
                    break;
                case "Атмосфера":
                    finalRating += atmosphereScore * criterion.getWeight();
                    break;
            }
        }
        return finalRating;
    }

    public String getLocation() {
        return location;
    }
}
