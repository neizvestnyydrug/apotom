package apotom.model;

public final class Criterion {
    private final String name;
    private final double weight;

    public Criterion(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("Criterion{name='%s', weight=%.2f}", name, weight);
    }
}
