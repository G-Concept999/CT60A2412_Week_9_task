package main;

import java.util.ArrayList;
import java.util.List;

/**
 * The ChampionshipManager class is a singleton that manages the rally championship.
 * It keeps track of drivers, races, and championship standings.
 */
public class ChampionshipManager {
    private static ChampionshipManager instance; // singleton instance
    private List<Driver> drivers; // list of registered drivers
    private List<RallyRaceResult> races; // list of race results
    private static int totalDrivers; // total number of registered drivers
    private static int totalRaces; // total number of recorded races

    /**
     * Private constructor to enforce singleton pattern.
     * Initializes the lists for drivers and races.
     */
    private ChampionshipManager() {
        drivers = new ArrayList<Driver>();
        races = new ArrayList<RallyRaceResult>();
    }

    /**
     * Returns the singleton instance of ChampionshipManager.
     * If the instance does not exist, it creates one.
     *
     * @return the singleton instance of ChampionshipManager
     */
    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    /**
     * Returns the list of registered drivers.
     *
     * @return the list of drivers
     */
    public List<Driver> getDrivers() {
        return drivers;
    }

    /**
     * Returns the list of race results.
     *
     * @return the list of race results
     */
    public List<RallyRaceResult> getRaces() {
        return races;
    }

    /**
     * Returns the total number of registered drivers.
     *
     * @return the total number of drivers
     */
    public static int getTotalDrivers() {
        return totalDrivers;
    }

    /**
     * Registers a driver in the championship.
     *
     * @param driver the driver to register
     */
    public void registerDriver(Driver driver) {
        drivers.add(driver);
        totalDrivers++; // increment the total number of drivers
    }

    /**
     * Adds a race result to the championship.
     *
     * @param result the race result to add
     */
    public void addRaceResult(RallyRaceResult result) {
        races.add(result);
    }

    /**
     * Returns the championship standings sorted by driver points in descending order.
     *
     * @return a list of drivers sorted by their points
     */
    public List<Driver> getDriverStandings() {
        List<Driver> driverStandings = new ArrayList<>(drivers);
        // sort drivers by points in descending order
        driverStandings.sort((d1, d2) -> Integer.compare(d2.getPoints(), d1.getPoints()));
        return driverStandings;
    }

    /**
     * Returns the current championship leader (the driver with the most points).
     *
     * @return the leading driver
     */
    public static Driver getLeadingDriver() {
        ChampionshipManager manager = ChampionshipManager.getInstance();
        List<Driver> drivers = manager.getDrivers();

        Driver leadingDriver = null;
        int mostPoints = -1; // initialize with a value lower than possible points

        // find the driver with the most points
        for (Driver driver : drivers) {
            if (driver.getPoints() > mostPoints) {
                mostPoints = driver.getPoints();
                leadingDriver = driver;
            }
        }

        return leadingDriver;
    }

    /**
     * Returns the total championship points accumulated by all drivers.
     *
     * @return the total championship points
     */
    public static int getTotalChampionshipPoints() {
        ChampionshipManager manager = ChampionshipManager.getInstance();
        List<Driver> drivers = manager.getDrivers();

        int totalChampionshipPoints = 0;

        // sum up the points of all drivers
        for (Driver driver : drivers) {
            totalChampionshipPoints += driver.getPoints();
        }

        return totalChampionshipPoints;
    }
}