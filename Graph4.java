import java.util.*;

public class Graph4 extends Graph {

    private Line h1 = new Line(231, 426, 224, 422, 4, "WHITE");
    private Line h2 = new Line(231, 426, 223, 434, 4, "WHITE");
    private Line h3 = new Line(569, 426, 576, 422, 4, "WHITE");
    private Line h4 = new Line(569, 426, 575, 434, 4, "WHITE");

    private Node n1 = new Node("J", 400, 200, "29FAC4");
    private Node n2 = new Node("K", 250, 400, "29FAC4");
    private Node n3 = new Node("L", 400, 600, "29FAC4");
    private Node n4 = new Node("M", 550, 400, "29FAC4");

    private Graph g = new Graph();

    private List<Node> l1 = g.initNodes(n1);
    private List<Node> l2 = g.initNodes(n2);
    private List<Node> l3 = g.initNodes(n3);
    private List<Node> l4 = g.initNodes(n4);

    public Graph4(GameArena arena) {

        g.addEdges(n1, n2, arena, true, "null", 87);
        g.addEdges(n2, n3, arena, true, "null", 87);
        g.addEdges(n2, n2, arena, true, "left", 100);
        g.addEdges(n4, n4, arena, true, "right", 100);
        g.addEdges(n3, n4, arena, true, "null", 87);
        g.addEdges(n4, n1, arena, true, "null", 87);
        g.addEdges(n1, n4, arena, true, "null", 87);

        g.addNodes(arena);

        g.printGraph();
        arena.addLine(h1);
        arena.addLine(h2);
        arena.addLine(h3);
        arena.addLine(h4);
        arena.update();
    }

}