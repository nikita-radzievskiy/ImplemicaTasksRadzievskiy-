package com.implemica.radzievskiy.task2;

import static java.lang.Math.min;
import static java.util.Arrays.fill;

public class Task2 {

    private final int INFINITY = 10001;
    private int[][] cost;

    public Task2(int vertices) {
        cost = new int[vertices][vertices];
    }

    public void setEdge(int i, int j, int weight) {
        cost[i][j] = weight;
    }


    private int getCost(int i, int j) { // method to get the cost of the edge between i and j
        if (i == j) {              // if i and j are the same vertex
            return 0;
        }
        if (cost[i][j] == 0) {  // if there is no edge between i and j
            return INFINITY;
        }
        return cost[i][j];     // return the cost of the edge
    }

    private int getUntaggedVertex(Integer[] result, boolean[] visited) {    // method to get the next vertex to visit
        int best = -1;
        for (int i = 0; i < cost.length; i++) { // Sort out the vertices
            if (!visited[i] && ((best < 0) || (result[i] < result[best]))) { // Select the closest untagged vertex
                best = i;
            }
        }
        return best;
    }

    public Integer[] waysOfMinimumCostBetweenPairsOfCities(int startIndex) {  // method to find the minimum cost between pairs of cities
        boolean[] visited = new boolean[cost.length];   // array of visited vertices
        Integer[] result = new Integer[cost.length];    // array of results
        fill(result, INFINITY); // fill the array with INFINITY
        result[startIndex] = startIndex;    // set the start vertex to 0

        for (int[] aCost : cost) {  // for each row in the matrix
            int city = getUntaggedVertex(result, visited);  // get the next vertex to visit
            visited[city] = true;   // mark the vertex as visited
            for (int j = 0; j < cost.length; j++) { // for each column in the matrix
                result[j] = min(result[j], result[city] + getCost(city, j));    // update the result array
            }
        }
        return result;  // return the result array
    }

}