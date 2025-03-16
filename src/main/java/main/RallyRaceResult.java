package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The RallyRaceResult class implements the RaceResult interface and represents
 * the results of a rally race. It stores the race name, location, and the results
 * of drivers, including their positions and points.
 */
public class RallyRaceResult implements RaceResult {
    private String raceName; // the name of the race
    private String location; // the location of the race
    private Map<Driver, Integer> results; // map to store driver results (driver -> position)

    /**
     * Constructs a RallyRaceResult object with the specified race name and location.
     *
     * @param raceName the name of the race
     * @param location the location of the race
     */
    public RallyRaceResult(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
        this.results = new HashMap<>();
    }

    /**
     * Returns the name of the race.
     *
     * @return the race name
     */
    public String getRaceName() {
        return raceName;
    }

    /**
     * Returns the location of the race.
     *
     * @return the race location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Records the result of a driver in the race, including their position and points.
     * The driver's total points are updated, and their position is stored in the results map.
     *
     * @param driver   the driver whose result is being recorded
     * @param position the position the driver finished in the race
     * @param points   the points earned by the driver in the race
     */
    @Override
    public void recordResult(Driver driver, int position, int points) {
        driver.addPoints(points); // add points to the driver's total
        results.put(driver, position); // store the driver's position in the results map
    }

    /**
     * Returns the points earned by a specific driver in the race.
     *
     * @param driver the driver whose points are being retrieved
     * @return the points earned by the driver in the race
     */
    @Override
    public int getDriverPoints(Driver driver) {
        return results.get(driver); // retrieve the driver's points from the results map
    }

    /**
     * Returns a list of drivers sorted by their finishing positions in the race.
     *
     * @return a list of drivers sorted by their positions
     */
    @Override
    public List<Driver> getResults() {
        // convert the results map entries to a list
        List<Map.Entry<Driver, Integer>> resultsEntryList = new ArrayList<>(results.entrySet());

        // sort the list by driver positions
        resultsEntryList.sort(Map.Entry.comparingByValue());

        // create a list of drivers sorted by their positions
        List<Driver> sortedDrivers = new ArrayList<>();
        for (Map.Entry<Driver, Integer> entry : resultsEntryList) {
            sortedDrivers.add(entry.getKey());
        }

        return sortedDrivers;
    }
}