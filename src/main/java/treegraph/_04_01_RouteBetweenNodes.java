package treegraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a directed graph, design an algorithm to find out whether
 * there is a route between two nodes.
 */
class _04_01_RouteBetweenNodes {

    // BFS
    // BFS
    static boolean hasRouteBfs(Graph graph, Node source, Node target) {
        if(source == target) return true;

        Queue<Node> vertexQueue = new LinkedList();

        vertexQueue.add(source);

        while(!vertexQueue.isEmpty()) {

            Node currVertex = vertexQueue.poll();

            if(currVertex.state != State.Visited) {
                for (Node child : currVertex.getAdjacent()) {
                    if (child == target) return true;
                    vertexQueue.add(child);
                }
                currVertex.state = State.Visited;
            }
        }

        return false;
    }
}
