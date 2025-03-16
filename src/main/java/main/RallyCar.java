package main;

/**
 * The RallyCar abstract class represents a rally car in the championship.
 * It stores the car's make, model, and horsepower, and provides an abstract method
 * for calculating the car's performance.
 */
public abstract class RallyCar {
    private String make; // the make of the car (e.g., Toyota, Porsche)
    private String model; // the model of the car (e.g., GR Yaris, 911 Dakar)
    private int horsepower; // the horsepower of the car

    /**
     * Constructs a RallyCar object with the specified make, model, and horsepower.
     *
     * @param make       the make of the car
     * @param model      the model of the car
     * @param horsepower the horsepower of the car
     */
    public RallyCar(String make, String model, int horsepower) {
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }

    /**
     * Returns the make of the car.
     *
     * @return the car's make
     */
    public String getMake() {
        return make;
    }

    /**
     * Returns the model of the car.
     *
     * @return the car's model
     */
    public String getModel() {
        return model;
    }

    /**
     * Returns the horsepower of the car.
     *
     * @return the car's horsepower
     */
    public int getHorsepower() {
        return horsepower;
    }

    /**
     * Calculates the performance of the car. This method is abstract and must be
     * implemented by subclasses to provide specific performance calculations.
     *
     * @return the performance rating of the car as a double
     */
    public abstract double calculatePerformance();
}