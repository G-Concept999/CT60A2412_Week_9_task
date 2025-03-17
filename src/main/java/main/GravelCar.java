package main;

/**
 * The GravelCar class represents a rally car designed for gravel surfaces.
 * It extends the RallyCar class and includes additional properties such as suspension travel.
 * It also provides a specific implementation for calculating performance on gravel.
 */
public class GravelCar extends RallyCar {
    private double suspensionTravel; // the suspension travel of the car, which affects its performance on gravel

    /**
     * Constructs a GravelCar object with the specified make, model, horsepower, and suspension travel.
     *
     * @param make             the make of the car
     * @param model            the model of the car
     * @param horsepower       the horsepower of the car
     * @param suspensionTravel the suspension travel of the car
     */
    public GravelCar(String make, String model, int horsepower, double suspensionTravel) {
        super(make, model, horsepower);
        this.suspensionTravel = suspensionTravel;
    }

    /**
     * Returns the suspension travel of the car.
     *
     * @return the car's suspension travel
     */
    public double getSuspensionTravel() {
        return suspensionTravel;
    }

    /**
     * Calculates the performance of the car on gravel surfaces.
     * Gravel cars have a 15% performance reduction based on their horsepower.
     * The result is formatted to 1 decimal place.
     *
     * @return the performance rating of the car as a double, formatted to 1 decimal place
     */
    @Override
    public double calculatePerformance() {
        // gravel cars have a 13% performance reduction
        double performance = getHorsepower() * 0.87;

        // format the performance to 1 decimal place
        return Double.parseDouble(String.format("%.1f", performance));
    }
}