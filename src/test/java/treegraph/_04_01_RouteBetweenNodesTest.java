package treegraph;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static treegraph._04_01_RouteBetweenNodes.hasRouteBfs;

public class _04_01_RouteBetweenNodesTest {

    public static Graph createNewGraph()
    {
        Graph g = new Graph();
        Node[] temp = new Node[6];

        temp[0] = new Node("a", 3);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);
        temp[3] = new Node("d", 1);
        temp[4] = new Node("e", 1);
        temp[5] = new Node("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);
        for (int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }
        return g;
    }

    public static Graph createNewGraphWithCycle()
    {
        Graph g = new Graph();
        Node[] temp = new Node[3];

        temp[0] = new Node("a", 3);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);

        temp[0].addAdjacent(temp[1]);
        temp[1].addAdjacent(temp[2]);
        temp[2].addAdjacent(temp[0]);

        for (int i = 0; i < 3; i++) {
            g.addNode(temp[i]);
        }
        return g;
    }

    @Test
    public void withTwoVertex() {
        Graph g = createNewGraph();
        Node[] n = g.getNodes();
        assertTrue(hasRouteBfs(g, n[0], n[5]));

        Graph g1 = createNewGraph();
        Node[] n1 = g1.getNodes();
        assertTrue(hasRouteBfs(g1, n1[3], n1[5]));

        Graph g2 = createNewGraph();
        Node[] n2 = g2.getNodes();
        assertFalse(hasRouteBfs(g2, n2[3], n2[0]));
    }

    @Test
    public void withCycle() {
        Graph g = createNewGraphWithCycle();
        Node[] n = g.getNodes();
        assertTrue(hasRouteBfs(g, n[0], n[1]));

        Graph g1 = createNewGraph();
        Node[] n1 = g1.getNodes();
        assertTrue(hasRouteBfs(g1, n1[0], n1[2]));
    }

}