package domain.my_implementation;

import domain.my_implementation._Graph;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class _GraphTest {

    @Test
    void givenGraph_whenAddAVertex_thenReturnEmptyArray() {
        String v1 = "Vertex 1";
        _Graph graph = new _Graph();
        graph.addVertex(v1);
        graph.printGraph();
        assertThat(graph.getAdjacencyMap().get(v1)).isEmpty();
    }

    @Test
    void givenAGraphWithTwoVertex_whenAddAEdge_thenReturnTrue() {
        String v1 = "Vertex 1";
        String v2 = "Vertex 2";
        _Graph graph = new _Graph();
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.printGraph();

        assertTrue(graph.addEdge(v1, v2));
        graph.printGraph();
    }

    @Test
    void givenAGraphWithOneVertex_whenAddAEdge_thenReturnFalse() {
        String v1 = "Vertex 1";
        String v2 = "Vertex 2";
        _Graph graph = new _Graph();
        graph.addVertex(v1);
        graph.printGraph();

        assertFalse(graph.addEdge(v1, v2));
        graph.printGraph();
    }

    @Test
    void givenAGraphWithEdges_whenRemoveEdge_thenReturnTrue() {
        String v1 = "Vertex 1";
        String v2 = "Vertex 2";
        String v3 = "Vertex 3";
        _Graph graph = new _Graph();
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.printGraph();

        graph.addEdge(v1, v2);
        graph.addEdge(v1, v3);
        graph.addEdge(v2, v3);
        graph.printGraph();

        assertTrue(graph.removeEdge(v1, v2));
        graph.printGraph();
    }

    @Test
    void givenAGraphWithoutEdge_whenRemoveTheEdge_thenReturnFalse() {
        String v1 = "Vertex 1";
        String v2 = "Vertex 2";
        String v3 = "Vertex 3";
        _Graph graph = new _Graph();
        graph.addVertex(v1);
        graph.addVertex(v3);
        graph.printGraph();

        graph.addEdge(v1, v3);
        graph.printGraph();

        assertFalse(graph.removeEdge(v1, v2));
        graph.printGraph();
    }

    @Test
    void givenAGraph_whenRemoveTheVertex_thenReturnTrue() {
        String v1 = "Vertex 1";
        String v2 = "Vertex 2";
        String v3 = "Vertex 3";
        String v4 = "Vertex 4";
        String v5 = "Vertex 5";
        String v6 = "Vertex 6";
        _Graph graph = new _Graph();
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addVertex(v6);
        graph.printGraph();

        graph.addEdge(v1, v2);
        graph.addEdge(v1, v3);
        graph.addEdge(v1, v4);
        graph.addEdge(v2, v4);
        graph.addEdge(v3, v4);
        graph.printGraph();

        assertTrue(graph.removeVertex(v4));
        assertFalse(graph.getAdjacencyMap().get(v1).contains(v4));
        assertFalse(graph.getAdjacencyMap().get(v2).contains(v4));
        assertFalse(graph.getAdjacencyMap().get(v3).contains(v4));
        assertNull(graph.getAdjacencyMap().get(v4));
        graph.printGraph();
    }
}