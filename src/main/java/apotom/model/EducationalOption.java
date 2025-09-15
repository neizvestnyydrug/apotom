package apotom.model;

public abstract class EducationalOption implements IRatable, IDescribable {
    private final String name;
    private final String description;
    private double baseRating;

    public EducationalOption(String name, String description, double baseRating) {
        this.name = name;
        this.description = description;
        this.baseRating = baseRating;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public double getBaseRating() {
        return baseRating;
    }

    public void setBaseRating(double baseRating) {
        this.baseRating = baseRating;
    }
}
