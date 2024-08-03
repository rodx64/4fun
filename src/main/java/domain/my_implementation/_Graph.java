package domain.my_implementation;

import java.util.ArrayList;
import java.util.HashMap;

public class _Graph {

    private HashMap<String, ArrayList<String>> adjacencyMap = new HashMap();

    public boolean addVertex(String vertex) {
        if (adjacencyMap.get(vertex) == null) {
            adjacencyMap.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if (adjacencyMap.get(vertex1) != null && adjacencyMap.get(vertex2) != null) {
            adjacencyMap.get(vertex1).add(vertex2);
            adjacencyMap.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if (adjacencyMap.get(vertex1) != null && adjacencyMap.get(vertex2) != null) {
            adjacencyMap.get(vertex1).remove(vertex2);
            adjacencyMap.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex) {
        ArrayList<String> vertexL = adjacencyMap.get(vertex);
        if (vertexL == null) return false;
        for (String vx : vertexL) {
            adjacencyMap.get(vx).remove(vertex);    // Remove the vertex relations
        }
        adjacencyMap.remove(vertex);                // finally, remove the vertex
        return true;
    }

    public void printGraph() {
        System.out.println(adjacencyMap);
    }

    public HashMap<String, ArrayList<String>> getAdjacencyMap() {
        return adjacencyMap;
    }


}
