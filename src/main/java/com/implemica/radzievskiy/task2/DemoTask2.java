package com.implemica.radzievskiy.task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DemoTask2 {

    private static final int NUMBER_OF_CITIES = 10000;
    public static final String FILE_PATH = "/Users/pro/Desktop/TestJava/src/main/resources/task2.txt";

    public static void main(String[] args) throws IOException {
        File path = new File(FILE_PATH); // create file object
        BufferedReader br = new BufferedReader(new FileReader(path.getAbsolutePath())); // create buffered reader
        String line = br.readLine();
        int source = Integer.parseInt(line);
        initializer(br, source);    // initialize cities
        br.close(); // close buffered reader
    }

    private static void initializer(BufferedReader br, int source) throws IOException { // method to initialize the graph
        String line;
        for (int testIndex = 0; testIndex < source; testIndex++) {  // build all the graphs
            String[] citiesInd = new String[NUMBER_OF_CITIES];
            line = br.readLine();
            int countCities = Integer.parseInt(line);
            int matrixSize = countCities + 1;
            Task2 matrix = new Task2(matrixSize);
            findCityAndNeighbor(br, citiesInd, countCities, matrix);
            line = br.readLine();
            int routesToFind = Integer.parseInt(line);
            findRoute(br, citiesInd, matrix, routesToFind);
        }
    }

    private static void findRoute(BufferedReader br, String[] citiesInd, Task2 matrix, int routesToFind) throws IOException {
        String line;
        for (int routesIndex = 0; routesIndex < routesToFind; routesIndex++) { // for each to find route
            line = br.readLine();
            String[] cityNames = line.split(" ");
            String start = cityNames[0];
            String destination = cityNames[1];
            List<String> list = new ArrayList<>();

            for (String s : citiesInd) {
                if (s != null) {
                    list.add(s);
                }
            }
            citiesInd = list.toArray(new String[0]);
            int startIndex = 0;
            int destinationIndex = 0;
            for (int i = 0; i < citiesInd.length; i++) // for each to find the index of the initial city
                if (start.equals(citiesInd[i])) {
                    startIndex = i;
                    break;
                }
            for (int i = 0; i < citiesInd.length; i++) {    //for each to find index of the end of the city
                if (destination.equals(citiesInd[i])) {
                    destinationIndex = i;
                    break;
                }
            }
            Integer[] distancesFromSource = matrix.waysOfMinimumCostBetweenPairsOfCities(startIndex);
            int destinationDistance = distancesFromSource[destinationIndex];
            System.out.println(destinationDistance);
        }
    }

    private static void findCityAndNeighbor(BufferedReader br, String[] citiesInd, int countCities, Task2 matrix) throws IOException {
        String line;
        for (int cityIndex = 0; cityIndex < countCities; cityIndex++) { // for each city
            line = br.readLine();
            String cityName = line;
            citiesInd[cityIndex] = cityName;
            line = br.readLine();
            int p = Integer.parseInt(line);

            for (int neighborIndex = 0; neighborIndex < p; neighborIndex++) {   // for each neighbor
                line = br.readLine();
                String[] brokenLine = line.split(" ");
                int cityToConnect = Integer.parseInt(brokenLine[0]);
                int weightOfConnection = Integer.parseInt(brokenLine[1]);
                matrix.setEdge(cityIndex, cityToConnect, weightOfConnection);
            }
        }
    }

}
