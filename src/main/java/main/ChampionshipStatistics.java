package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The ChampionshipStatistics class provides utility methods for calculating
 * various statistics related to the rally championship, such as average points
 * per driver, the most successful country, and the total number of races held.
 */
public class ChampionshipStatistics {

    /**
     * Calculates the average points per driver in the championship.
     *
     * @param drivers the list of drivers in the championship
     * @return the average points per driver as a double
     */
    public static double calculateAveragePointsPerDriver(List<Driver> drivers) {
        int totalPoints = 0;

        // sum up the points of all drivers
        for (Driver driver : drivers) {
            totalPoints += driver.getPoints();
        }

        // calculate the average points per driver
        return (double) totalPoints / drivers.size();
    }

    /**
     * Finds the most successful country in the championship based on the total points
     * earned by drivers from each country.
     *
     * @param drivers the list of drivers in the championship
     * @return the name of the most successful country
     */
    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        // map to store the total points for each country
        Map<String, Integer> countriesPoints = new HashMap<>();

        // calculate the total points for each country
        for (Driver driver : drivers) {
            String country = driver.getCountry();
            int points = driver.getPoints();

            // update the total points for the driver's country
            countriesPoints.put(country, countriesPoints.getOrDefault(country, 0) + points);
        }

        String mostSuccessfulCountry = "";
        int mostPoints = -1; // initialize with a value lower than possible points

        // find the country with the most points
        for (Map.Entry<String, Integer> entry : countriesPoints.entrySet()) {
            if (entry.getValue() >= mostPoints) {
                mostPoints = entry.getValue();
                mostSuccessfulCountry = entry.getKey();
            }
        }

        return mostSuccessfulCountry;
    }

    /**
     * Returns the total number of races held in the championship.
     *
     * @return the total number of races held
     */
    public static int getTotalRacesHeld() {
        ChampionshipManager manager = ChampionshipManager.getInstance();
        List<RallyRaceResult> races = manager.getRaces();

        // return the number of races in the list
        return races.size();
    }
}