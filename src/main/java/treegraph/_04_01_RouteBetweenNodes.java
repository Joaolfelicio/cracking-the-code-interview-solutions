package treegraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a directed graph, design an algorithm to find out whether
 * there is a route between two nodes.
 */
class _04_01_RouteBetweenNodes {

    private final Digraph digraph;

    _04_01_RouteBetweenNodes(Digraph digraph) {
        this.digraph = digraph;
    }

    // BFS
    boolean hasRoute(int source, int target) {
        if(source == target) return true;

        Queue<Integer> vertexQueue = new LinkedList();

        vertexQueue.add(source);

        while(!vertexQueue.isEmpty()) {

            int currVertex = vertexQueue.poll();

            for (int child : digraph.adjacent(currVertex)) {
                if(child == target) return true;
                vertexQueue.add(child);
            }
        }

        return false;
    }

}
