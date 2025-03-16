package main;

import java.util.List;

/**
 * The RaceResult interface defines the methods required for recording and retrieving
 * race results, including driver positions and points.
 */
public interface RaceResult {

    /**
     * Records the result of a driver in a race, including their position and points earned.
     *
     * @param driver   the driver whose result is being recorded
     * @param position the position the driver finished in the race
     * @param points   the points earned by the driver in the race
     */
    void recordResult(Driver driver, int position, int points);

    /**
     * Returns the points earned by a specific driver in the race.
     *
     * @param driver the driver whose points are being retrieved
     * @return the points earned by the driver in the race
     */
    int getDriverPoints(Driver driver);

    /**
     * Returns a list of drivers sorted by their finishing positions in the race.
     *
     * @return a list of drivers sorted by their positions
     */
    List<Driver> getResults();
}