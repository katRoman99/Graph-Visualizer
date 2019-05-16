import java.util.*;

public class Graph1 extends Graph {
    
    private Graph g = new Graph();
    private static boolean exit_pressed = false;
    private static Rectangle exit = new Rectangle(100, 650, 100, 60, "#a97777");
    private static Text exit_text = new Text("Back", 75, 655, 20, "#ccf4f1");

    private Node n1 = new Node("A", 200, 200, "29FAC4");
    private Node n2 = new Node("B", 350, 200, "29FAC4");
    private Node n3 = new Node("C", 200, 400, "29FAC4");
    private Node n4 = new Node("D", 350, 400, "29FAC4");

    private List<Node> l1 = g.initNodes(n1);
    private List<Node> l2 = g.initNodes(n2);
    private List<Node> l3 = g.initNodes(n3);
    private List<Node> l4 = g.initNodes(n4);

    public Graph1() {
            
    }

    public void showGraph1() {

        GameArena arena_graph1 = new GameArena(800, 800);
        arena_graph1.getFrame().setDefaultCloseOperation(arena_graph1.getFrame().DISPOSE_ON_CLOSE);

        g.addEdges(n1, n2, arena_graph1, false, "null", 2);
        g.addEdges(n1, n3, arena_graph1, false, "null", 2);
        g.addEdges(n2, n4, arena_graph1, false, "null", 2);
        g.addEdges(n3, n4, arena_graph1, false, "null", 2);

        g.printGraph();

        g.addNodes(arena_graph1);
        arena_graph1.addRectangle(exit);
        arena_graph1.addText(exit_text);
        arena_graph1.update();

        while (exit_pressed == false) {
            arena_graph1.update();

            if (arena_graph1.leftMousePressed() && arena_graph1.objectClicked(exit)) {
                g.removeNodes(arena_graph1);
                arena_graph1.update();
                arena_graph1.exit();
                this.closeGraph();
            }
        }
    }
}