package com.flightsGraphs;

//4 UŽDUOTIS:

//Duotas lėktuvų skrydžių sąrašas: miestas, miestas, kaina.
//Rasti pigiausią skrydžio iš vieno duoto miesto į kitą duotą miestą maršrutą ir jo kainą.
//Numatyti atvejį, kad toks maršrutas neegzistuoja. (grafo realizacija paremta kaimynystės matrica)

//16 nodes

//LSP: 2110576

//DEADLINE: 05.24


public class Flights {

    public static void main(String[] args) {
        Graph graph = new Graph(16);
        setUpGraph(graph);
        graph.displayRoute(0, 2);

        graph.printAllFlights();
        //graph.printMatrix();

    }

    public static void setUpGraph(Graph graph) {

        graph.addNode(new Node("Vilnius"));
        graph.addNode(new Node("Amsterdam"));
        graph.addNode(new Node("London"));
        graph.addNode(new Node("Rome"));
        graph.addNode(new Node("Madrid"));
        graph.addNode(new Node("Lisbon"));
        graph.addNode(new Node("Tallinn"));
        graph.addNode(new Node("Oslo"));
        graph.addNode(new Node("Riga"));
        graph.addNode(new Node("Berlin"));
        graph.addNode(new Node("Stockholm"));
        graph.addNode(new Node("Prague"));
        graph.addNode(new Node("Budapest"));
        graph.addNode(new Node("Vienna"));
        graph.addNode(new Node("Helsinki"));
        graph.addNode(new Node("California"));


        graph.addEdge(new Edge(0, 1, 50.89));
        graph.addEdge(new Edge(1, 2, 30.60));
        graph.addEdge(new Edge(3, 2, 12.50));
        graph.addEdge(new Edge(7, 6, 140.5));
        graph.addEdge(new Edge(0, 9, 78.70));
        graph.addEdge(new Edge(1, 9, 6.7));
        graph.addEdge(new Edge(5, 4, 10.45));
        graph.addEdge(new Edge(2, 5, 56.8));
        graph.addEdge(new Edge(1, 3, 70.00));
        graph.addEdge(new Edge(1, 5, 46.99));
//        graph.addEdge(new Edge(7,11, 23.66));
        graph.addEdge(new Edge(6, 14, 45.7));
        graph.addEdge(new Edge(1, 6, 30.00));
        graph.addEdge(new Edge(8, 7, 140.5));
        graph.addEdge(new Edge(10, 9, 78.9));
        graph.addEdge(new Edge(10, 12, 15.89));
        graph.addEdge(new Edge(10, 6, 140.80));
        graph.addEdge(new Edge(8, 3, 370.5));
        graph.addEdge(new Edge(8, 5, 70.00));
        graph.addEdge(new Edge(5, 0, 240.78));
//        graph.addEdge(new Edge(11,3, 7.90));
        graph.addEdge(new Edge(14, 13, 45.09));
        graph.addEdge(new Edge(6, 15, 110.87));
        graph.addEdge(new Edge(4, 15, 113.17));
        graph.addEdge(new Edge(3, 4, 210.45));
        graph.addEdge(new Edge(7, 4, 140.00));
        graph.addEdge(new Edge(15, 13, 56.99));
        graph.addEdge(new Edge(2, 8, 80.90));
        graph.addEdge(new Edge(7, 0, 40.70));

    }
}
