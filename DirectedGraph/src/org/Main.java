package org;


public class Main {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();

        for (int i = 0; i < 4; i++) {
            graph.addVertex((char)('0' + i));
        }
        graph.addEdge(0, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);

        System.out.println(graph);
        graph.topologySort(0);

        System.out.println(graph);
    }
}
