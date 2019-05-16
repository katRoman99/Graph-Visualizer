import java.util.*;

public class Graph2 extends Graph {

    private Node o1 = new Node("E", 400, 100, "29FAC4");
    private Node o2 = new Node("F", 600, 200, "29FAC4");
    private Node o3 = new Node("G", 300, 400, "29FAC4");
    private Node o4 = new Node("H", 500, 400, "29FAC4");
    private Node o5 = new Node("I", 200, 200, "29FAC4");

    private static boolean exit_pressed = false;
    private static Rectangle exit = new Rectangle(100, 650, 100, 60, "#a97777");
    private static Rectangle black = new Rectangle(0, 0, 800, 800, "BLACK");
    private static Text exit_text = new Text("Back", 75, 655, 20, "#ccf4f1");

    private List<Node> l1 = this.initNodes(o1);
    private List<Node> l2 = this.initNodes(o2);
    private List<Node> l3 = this.initNodes(o3);
    private List<Node> l4 = this.initNodes(o4);
    private List<Node> l5 = this.initNodes(o5);

    public Graph2() {
    }

    public void showGraph2() {

        GameArena arena_graph2 = new GameArena(800, 800);
        arena_graph2.getFrame().setDefaultCloseOperation(arena_graph2.getFrame().DISPOSE_ON_CLOSE);

        this.addEdges(o1, o2, arena_graph2, false, "null", 2);
        this.addEdges(o1, o3, arena_graph2, false, "null", 2);
        this.addEdges(o1, o4, arena_graph2, false, "null", 2);
        this.addEdges(o1, o5, arena_graph2, false, "null", 2);

        this.addEdges(o2, o3, arena_graph2, false, "null", 2);
        this.addEdges(o2, o4, arena_graph2, false, "null", 2);
        this.addEdges(o2, o5, arena_graph2, false, "null", 2);
            
        this.addEdges(o3, o4, arena_graph2, false, "null", 2);
        this.addEdges(o3, o5, arena_graph2, false, "null", 2);

        this.addEdges(o4, o5, arena_graph2, false, "null", 2);

        this.printGraph();

        this.addNodes(arena_graph2);

        arena_graph2.addRectangle(exit);
        arena_graph2.addText(exit_text);

        arena_graph2.update();

        while (exit_pressed == false) {
            arena_graph2.update();

            if (arena_graph2.leftMousePressed() && arena_graph2.objectClicked(exit)) {
                arena_graph2.exit();
                this.closeGraph();
            }

        }
    }
}