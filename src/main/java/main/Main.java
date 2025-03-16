package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Main class is the entry point of the Rally Championship Management System.
 * It simulates races, registers drivers, and displays championship standings, statistics, and race results.
 */
public class Main {

    /**
     * The main method initializes the championship, registers drivers, simulates races, and displays results.
     *
     */
    public static void main(String[] args) {
        // get the singleton instance of ChampionshipManager
        ChampionshipManager manager = ChampionshipManager.getInstance();

        // create cars for the drivers
        AsphaltCar asphaltCar = new AsphaltCar("Toyota", "GR Yaris", 493, 150);
        GravelCar gravelCar = new GravelCar("Porsche", "911 Dakar", 473, 191);

        // create drivers and assign them cars
        Driver d1 = new Driver("Sébastien Ogier", "France", asphaltCar);
        Driver d2 = new Driver("Kalle Rovanperä", "Finland", gravelCar);
        Driver d3 = new Driver("Ott Tänak", "Estonia", gravelCar);
        Driver d4 = new Driver("Thierry Neuville", "Belgium", asphaltCar);

        // register drivers with the championship manager
        manager.registerDriver(d1);
        manager.registerDriver(d2);
        manager.registerDriver(d3);
        manager.registerDriver(d4);

        // simulate Rally Finland race
        RallyRaceResult race1 = new RallyRaceResult("Rally Finland", "Jyväskylä");
        Map<Driver, Integer> race1Points = new HashMap<>();
        race1Points.put(d1, 25); // 1st place, 25 points
        race1Points.put(d3, 18); // 2nd place, 18 points
        race1Points.put(d2, 15); // 3rd place, 15 points
        race1Points.put(d4, 12); // 4th place, 12 points

        // record results for Rally Finland
        race1.recordResult(d1, 1, 25);
        race1.recordResult(d2, 3, 15);
        race1.recordResult(d3, 2, 18);
        race1.recordResult(d4, 4, 12);
        manager.addRaceResult(race1);

        // simulate Monte Carlo Rally race
        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        Map<Driver, Integer> race2Points = new HashMap<>();
        race2Points.put(d2, 25);
        race2Points.put(d4, 18);
        race2Points.put(d1, 15);
        race2Points.put(d3, 12);

        // record results for Monte Carlo Rally
        race2.recordResult(d1, 3, 15);
        race2.recordResult(d2, 1, 25);
        race2.recordResult(d3, 4, 12);
        race2.recordResult(d4, 2, 18);
        manager.addRaceResult(race2);

        // create a map to store points for each race
        Map<RallyRaceResult, Map<Driver, Integer>> racePointsMap = new HashMap<>();
        racePointsMap.put(race1, race1Points);
        racePointsMap.put(race2, race2Points);

        // display championship rankings, leader, statistics, race results, and car performance ratings
        displayChampionshipRankings(manager.getDriverStandings());
        displayChampionshipLeader(ChampionshipManager.getLeadingDriver());
        displayChampionshipStatistics(manager.getDrivers());
        displayRaceResults(racePointsMap);
        displayCarPerformanceRatings(gravelCar, asphaltCar);
    }

    /**
     * Displays the championship rankings in order of driver points.
     *
     * @param driversRankings a list of drivers sorted by their championship points
     */
    public static void displayChampionshipRankings(List<Driver> driversRankings) {
        int position = 1;
        for (Driver driver : driversRankings) {
            System.out.printf("%d. %s\n", position, driver);
            position++;
        }
        System.out.println();
    }

    /**
     * Displays the current championship leader.
     *
     * @param championshipLeader the driver with the most points in the championship
     */
    public static void displayChampionshipLeader(Driver championshipLeader) {
        System.out.println("===== CHAMPIONSHIP LEADER =====");
        System.out.printf("%s with %d points\n", championshipLeader.getName(), championshipLeader.getPoints());
        System.out.println();
    }

    /**
     * Displays championship statistics, including total drivers, total races, average points per driver,
     * most successful country, and total championship points.
     *
     * @param drivers a list of all drivers in the championship
     */
    public static void displayChampionshipStatistics(List<Driver> drivers) {
        System.out.println("===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total drivers: " + ChampionshipManager.getTotalDrivers());
        System.out.println("Total races: " + ChampionshipStatistics.getTotalRacesHeld());
        System.out.println("Average Points Per Driver: " + ChampionshipStatistics.calculateAveragePointsPerDriver(drivers));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(drivers));
        System.out.println("Total Championship Points: " + ChampionshipManager.getTotalChampionshipPoints());
        System.out.println();
    }

    /**
     * Displays the results of all races, including driver positions and race-specific points.
     *
     * @param racePointsMap a map containing race results and driver points for each race
     */
    public static void displayRaceResults(Map<RallyRaceResult, Map<Driver, Integer>> racePointsMap) {
        // create a list of races from the racePointsMap keys
        List<RallyRaceResult> racesResults = new ArrayList<>(racePointsMap.keySet());

        System.out.println("===== RACE RESULTS ====");
        for (RallyRaceResult race : racesResults) {
            System.out.println("Race: " + race.getRaceName() + " (" + race.getLocation() + ")");

            // get the sorted list of drivers based on their positions
            List<Driver> sortedDrivers = race.getResults();

            // get the points map for this specific race
            Map<Driver, Integer> pointsForRace = racePointsMap.get(race);

            // display each driver's position and race-specific points
            for (int i = 0; i < sortedDrivers.size(); i++) {
                Driver driver = sortedDrivers.get(i);
                int position = i + 1;
                int racePoints = pointsForRace.getOrDefault(driver, 0); // get race-specific points
                System.out.println("\tPosition " + position + ": " + driver.getName() + " - " + racePoints + " points");
            }

            System.out.println(); // add a blank line between races for better readability
        }
    }

    /**
     * Displays the performance ratings of gravel and asphalt cars.
     *
     * @param car1 the gravel car to evaluate
     * @param car2 the asphalt car to evaluate
     */
    public static void displayCarPerformanceRatings(GravelCar car1, AsphaltCar car2) {
        System.out.println("===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + car1.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + car2.calculatePerformance());
    }
}
