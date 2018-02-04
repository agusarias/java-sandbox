package Problems;

import org.a2.sandbox.DataStructures.Graph.Graph;
import org.a2.sandbox.DataStructures.Graph.Node;
import org.a2.sandbox.Problems.NodesPath.Solution;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NodesPathTest {

    @Test
    public void testFound() {
        // GIVEN
        Solution solution = new Solution();

        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");
        Node node6 = new Node("6");
        Node node7 = new Node("7");
        Node node8 = new Node("8");
        node1.children.add(node3); // 1 -> 3
        node1.children.add(node2); // 1 -> 2
        node2.children.add(node6); // 2 -> 6
        node3.children.add(node5); // 3 -> 5
        node3.children.add(node4); // 3 -> 4
        node6.children.add(node7); // 6 -> 7
        node7.children.add(node8); // 7 -> 8

        Graph graph = new Graph();
        graph.nodes.add(node1);

        // WHEN
        boolean result = solution.solve(node1, node8);

        // THEN
        assertTrue(result);
    }

    @Test
    public void testFoundWithCycle() {
        // GIVEN
        Solution solution = new Solution();

        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");
        Node node6 = new Node("6");
        Node node7 = new Node("7");
        Node node8 = new Node("8");
        node1.children.add(node3); // 1 -> 3
        node1.children.add(node2); // 1 -> 2
        node2.children.add(node1); // 2 -> 1 cycle
        node2.children.add(node6); // 2 -> 6
        node3.children.add(node5); // 3 -> 5
        node3.children.add(node4); // 3 -> 4
        node4.children.add(node1); // 4 -> 1 cycle
        node6.children.add(node7); // 6 -> 7
        node7.children.add(node8); // 7 -> 8

        Graph graph = new Graph();
        graph.nodes.add(node1);

        // WHEN
        boolean result = solution.solve(node1, node8);

        // THEN
        assertTrue(result);
    }


    @Test
    public void testFoundWithCycleDepthFirst() {
        // GIVEN
        Solution solution = new Solution();

        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");
        Node node6 = new Node("6");
        Node node7 = new Node("7");
        Node node8 = new Node("8");
        node1.children.add(node3); // 1 -> 3
        node1.children.add(node2); // 1 -> 2
        node2.children.add(node1); // 2 -> 1 cycle
        node2.children.add(node6); // 2 -> 6
        node3.children.add(node5); // 3 -> 5
        node3.children.add(node4); // 3 -> 4
        node4.children.add(node1); // 4 -> 1 cycle
        node6.children.add(node7); // 6 -> 7
        node7.children.add(node8); // 7 -> 8

        Graph graph = new Graph();
        graph.nodes.add(node1);

        // WHEN
        boolean result = solution.depthFirstSearch(node1, node8);

        // THEN
        assertTrue(result);
    }
}
