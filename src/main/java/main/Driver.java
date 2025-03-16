package main;

/**
 * The Driver class represents a rally driver in the championship.
 * It stores the driver's name, country, points, and the car they are driving.
 */
public class Driver {
    private String name; // the name of the driver
    private String country; // the country the driver represents
    private int points; // the total points earned by the driver
    private RallyCar car; // the car the driver is driving

    /**
     * Constructs a Driver object with the specified name, country, and car.
     *
     * @param name    the name of the driver
     * @param country the country the driver represents
     * @param car     the car the driver is driving
     */
    public Driver(String name, String country, RallyCar car) {
        this.name = name;
        this.country = country;
        this.car = car;
        this.points = 0; // initialize points to 0
    }

    /**
     * Returns the name of the driver.
     *
     * @return the driver's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the country the driver represents.
     *
     * @return the driver's country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Returns the total points earned by the driver.
     *
     * @return the driver's total points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Returns the car the driver is driving.
     *
     * @return the driver's car
     */
    public RallyCar getCar() {
        return car;
    }

    /**
     * Sets the car the driver is driving.
     *
     * @param car the car to assign to the driver
     */
    public void setCar(RallyCar car) {
        this.car = car;
    }

    /**
     * Adds points to the driver's total points.
     *
     * @param points the points to add to the driver's total
     */
    public void addPoints(int points) {
        this.points += points; // add the points to the driver's total
    }

    /**
     * Returns a string representation of the driver, including their name, country, and points.
     *
     * @return a string representation of the driver
     */
    @Override
    public String toString() {
        return String.format("%s (%s): %d points", name, country, points);
    }
}