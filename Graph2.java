import java.util.*;

public class Graph2 extends Graph {

        private Node n1 = new Node("E", 400, 100, "29FAC4");
        private Node n2 = new Node("F", 600, 200, "29FAC4");
        private Node n3 = new Node("G", 300, 400, "29FAC4");
        private Node n4 = new Node("H", 500, 400, "29FAC4");
        private Node n5 = new Node("I", 200, 200, "29FAC4");

        private Graph g = new Graph();

        private List<Node> l1 = g.initNodes(n1);
        private List<Node> l2 = g.initNodes(n2);
        private List<Node> l3 = g.initNodes(n3);
        private List<Node> l4 = g.initNodes(n4);
        private List<Node> l5 = g.initNodes(n5);

        public Graph2(GameArena arena) {

            g.addEdges(n1, n2, arena, false, "null", 2);
            g.addEdges(n1, n3, arena, false, "null", 2);
            g.addEdges(n1, n4, arena, false, "null", 2);
            g.addEdges(n1, n5, arena, false, "null", 2);

            g.addEdges(n2, n3, arena, false, "null", 2);
            g.addEdges(n2, n4, arena, false, "null", 2);
            g.addEdges(n2, n5, arena, false, "null", 2);
            
            g.addEdges(n3, n4, arena, false, "null", 2);
            g.addEdges(n3, n5, arena, false, "null", 2);

            g.addEdges(n4, n5, arena, false, "null", 2);

            g.addNodes(arena);

            g.printGraph();
            arena.update();
        }
}