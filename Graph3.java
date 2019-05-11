import java.util.*;

public class Graph3 extends Graph {

    private Node n1 = new Node("J", 400, 200, "29FAC4");
    private Node n2 = new Node("K", 250, 400, "29FAC4");
    private Node n3 = new Node("L", 400, 600, "29FAC4");
    private Node n4 = new Node("M", 550, 400, "29FAC4");

    private Graph g = new Graph();

    private List<Node> l1 = g.initNodes(n1);
    private List<Node> l2 = g.initNodes(n2);
    private List<Node> l3 = g.initNodes(n3);
    private List<Node> l4 = g.initNodes(n4);

    public Graph3(GameArena arena) {
        
        g.addEdges(n1, n2, arena, true, "null", 87);
        g.addEdges(n2, n3, arena, true, "null", 87);
        g.addEdges(n3, n4, arena, true, "null", 87);
        g.addEdges(n4, n1, arena, true, "null", 87);

        g.addNodes(arena);

        g.printGraph();
        arena.update();
    }
}