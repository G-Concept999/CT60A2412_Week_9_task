package main;

/**
 * The AsphaltCar class represents a rally car designed for asphalt surfaces.
 * It extends the RallyCar class and includes additional properties such as downforce.
 * It also provides a specific implementation for calculating performance on asphalt.
 */
public class AsphaltCar extends RallyCar {
    private double downforce; // the downforce of the car, which affects its performance on asphalt

    /**
     * Constructs an AsphaltCar object with the specified make, model, horsepower, and downforce.
     *
     * @param make       the make of the car
     * @param model      the model of the car
     * @param horsepower the horsepower of the car
     * @param downforce  the downforce of the car
     */
    public AsphaltCar(String make, String model, int horsepower, double downforce) {
        super(make, model, horsepower);
        this.downforce = downforce;
    }

    /**
     * Returns the downforce of the car.
     *
     * @return the car's downforce
     */
    public double getDownforce() {
        return downforce;
    }

    /**
     * Calculates the performance of the car on asphalt surfaces.
     * Asphalt cars have a 10% performance boost based on their horsepower.
     * The result is formatted to 1 decimal place.
     *
     * @return the performance rating of the car as a double, formatted to 1 decimal place
     */
    @Override
    public double calculatePerformance() {
        // asphalt cars have a 5% performance boost
        double performance = getHorsepower() * 1.05;

        // format the performance to 1 decimal place
        return Double.parseDouble(String.format("%.1f", performance));
    }
}