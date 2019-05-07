import java.util.*;

public class Graph4 extends Graph {

    public static void main(String[] args) {

        GameArena arena = new GameArena(800, 800, true);

        Node n1 = new Node("J", 400, 200, "29FAC4");
        Node n2 = new Node("K", 250, 400, "29FAC4");
        Node n3 = new Node("L", 400, 600, "29FAC4");
        Node n4 = new Node("M", 550, 400, "29FAC4");

        Graph g = new Graph4();

        List<Node> l1 = g.initNodes(n1);
        List<Node> l2 = g.initNodes(n2);
        List<Node> l3 = g.initNodes(n3);
        List<Node> l4 = g.initNodes(n4);
        
        g.addEdges(n1, n2, arena, true, "null");
        g.addEdges(n2, n3, arena, true, "null");
        g.addEdges(n2, n2, arena, true, "left");
        g.addEdges(n4, n4, arena, true, "right");
        g.addEdges(n3, n4, arena, true, "null");
        g.addEdges(n4, n1, arena, true, "null");
        g.addEdges(n1, n4, arena, true, "null");

        g.addNodes(arena);

        g.printGraph();
        arena.update();
    }

}