package org;

public class Vertex {
    private char label;
    private boolean isVisited;

    public Vertex(char label) {
        this.label = label;
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    @Override
    public String toString() {
        return "Ver{" + label +
                '}';
    }
}
