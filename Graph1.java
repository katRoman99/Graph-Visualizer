import java.util.*;

public class Graph1 extends Graph {

    public static void main(String[] args) {

        GameArena arena = new GameArena(800, 800, true);

        Node n1 = new Node("A", 200, 200, "29FAC4");
        Node n2 = new Node("B", 350, 200, "29FAC4");
        Node n3 = new Node("C", 200, 400, "29FAC4");
        Node n4 = new Node("D", 350, 400, "29FAC4");

        Graph g = new Graph1();

        List<Node> l1 = g.initNodes(n1);
        List<Node> l2 = g.initNodes(n2);
        List<Node> l3 = g.initNodes(n3);
        List<Node> l4 = g.initNodes(n4);
        
        g.addEdges(n1, n2, arena, false, "null");
        g.addEdges(n1, n3, arena, false, "null");
        g.addEdges(n2, n4, arena, false, "null");
        g.addEdges(n3, n4, arena, false, "null");

        g.addNodes(arena);

        g.printGraph();
        arena.update();
    }
}