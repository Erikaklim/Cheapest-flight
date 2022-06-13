package com.flightsGraphs;

import java.util.ArrayList;
import com.flightsGraphs.Node;

public class Graph {

    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;
    private double[][] matrix;
    private boolean[] visited;
    private double[] prices;
    private int [] parents;


    public Graph(int size){
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        matrix = new double[size][size];
        visited = new boolean[size];
        prices = new double[size];
        parents = new int[size];
    }

    public void addNode(Node node){
        nodes.add(node);
    }


    //src - row, dst - column
    public void addEdge(Edge edge){
        matrix[edge.source][edge.destination] = edge.price;
        matrix[edge.destination][edge.source] = edge.price;
        edges.add(edge);

    }

    private void dijkstraAlgorithm(double[][] matrix, int src){
        parents[src] = -1;

        for(int i = 0; i < nodes.size(); i++){
            visited[i] = false;
            prices[i] = Double.MAX_VALUE;
        }

        prices[src] = 0.0;
        for( int i = 0; i < nodes.size(); i++){
            int u = findMinIndex(prices, visited);
            if(u == -1){
                return;
            }
            visited[u] = true;

            for(int v = 0; v < nodes.size(); v++){
                if(!visited[v] && matrix[u][v] != 0 &&
                        (prices[u] + matrix[u][v] < prices[v])) {
                    parents[v] = u;
                    prices[v] = prices[u] + matrix[u][v];
                }
            }
        }
    }

    private int findMinIndex(double[] prices, boolean[] visited){
        double lowestPrice = Double.MAX_VALUE;
        int minIndex = -1;

        for(int i = 0; i < nodes.size(); i++){
            if(!visited[i] && prices[i] < lowestPrice){
                lowestPrice = prices[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void displayRoute(int src, int dest){
        dijkstraAlgorithm(matrix, src);

        if(prices[dest] == Double.MAX_VALUE){
            System.out.println("Route: " + nodes.get(src).city + " -> " + nodes.get(dest).city + " doesn't exist");
            return;
        }

        System.out.println("Cheapest route:");
        System.out.println("• " + nodes.get(src).city + " -> " + nodes.get(dest).city);
        System.out.println("• Price: " + String.format("%.2f", prices[dest]));
        System.out.println("Full route: ");
        printPath(dest);

    }

    private void printPath(int currentNode){
        if(currentNode == - 1){
            return;
        }
        printPath(parents[currentNode]);
        System.out.println("• " + nodes.get(currentNode).city);
    }


    public void printMatrix(){
        System.out.print("       ");
        for(Node node : nodes){
            System.out.print(node.city + " ");
        }
        System.out.println();

        for(int i = 0; i < matrix.length; i++){ //rows
            System.out.print(nodes.get(i).city + " ");
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " |  ");
            }
            System.out.println();
        }

    }

    public void printAllFlights(){
        double price = 0;
        for(int i = 0; i < matrix.length; i ++){
            for (int j = 0; j < matrix[i].length; j++){
                for(Edge e : edges){
                    if (e.destination == i && e.source == j || e.destination == j && e.source == i){
                        price = e.price;
                        System.out.println(nodes.get(i).city + " -> " + nodes.get(j).city +
                                " | " + price);
                    }
                }

            }
        }
    }
}
