package org;

import java.util.*;

public class DirectedGraph {
    private final int MAX_SIZE = 10;
    private Vertex vertices[] = new Vertex[MAX_SIZE];
    int adjMatrix[][] = new int[MAX_SIZE][MAX_SIZE];
    private int size;

    public boolean addVertex(char label) {
        if (size < MAX_SIZE) {
            vertices[size++] = new Vertex(label);
            return true;
        }
        return false;
    }

    public boolean addEdge(int start, int finish) {
        if (start < size && finish < size && start > -1 && finish > -1) {
            adjMatrix[start][finish] = 1;
            return true;
        }
        return false;
    }

    public void searchDepth(int current) {
        System.out.println("I-" + current + ", V-" + vertices[current].getLabel());
        vertices[current].setVisited(true);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int num;
        while ((num = getAbjVertex(current)) != -1) {
            deque.add(num);
        }
        while (!deque.isEmpty()) {
            searchDepth(deque.poll());
        }
    }
    public void topologySort(int current) {
        Stack<Integer> vertexesFromTheEnd = new Stack<>();
        topologySortPrepare(current, vertexesFromTheEnd);
        Vertex[] vertexNew = new Vertex[MAX_SIZE];
        for (int i = 0; i < size; i++) {
            vertexNew[i] = vertices[vertexesFromTheEnd.pop()];
        }
        vertices = vertexNew;
    }

    private void topologySortPrepare(int current,  Stack<Integer> vertexesFromTheEnd) {
        vertices[current].setVisited(true);
        Deque<Integer> indiesVisibleVertex = new ArrayDeque<>();
        int num;
        while ((num = getAbjVertex(current)) != -1) {
            indiesVisibleVertex.add(num);
        }
        while (!indiesVisibleVertex.isEmpty()) {
            topologySortPrepare(indiesVisibleVertex.pollFirst(), vertexesFromTheEnd);
        }
        //Якщо йти нема куди – занести номер поточної вершини в стек
        vertexesFromTheEnd.add(current);
    }

    public int getAbjVertex(int start) {
        if (start > -1 && start < size) {
            for (int i = 0; i < size; i++) {
                if (adjMatrix[start][i] == 1 && !vertices[i].isVisited()) {
                    vertices[i].setVisited(true);
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "DirectedGraph{" +
                " vertices=" + Arrays.toString(vertices) +
                '}';
    }
}
