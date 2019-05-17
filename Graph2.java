import java.util.*;

public class Graph2 extends Graph {

    private Node n1 = new Node("E", 400, 100, "29FAC4");
    private Node n2 = new Node("F", 600, 200, "29FAC4");
    private Node n3 = new Node("G", 300, 400, "29FAC4");
    private Node n4 = new Node("H", 500, 400, "29FAC4");
    private Node n5 = new Node("I", 200, 200, "29FAC4");

    private static boolean exit_pressed = false;
    private static Rectangle exit = new Rectangle(100, 720, 100, 60, "#a97777");
    private static Text exit_text = new Text("Back", 75, 725, 20, "#ccf4f1");
    private static Rectangle graph_info = new Rectangle(670, 720, 150, 60, "#a97777");
    private static Text info_text = new Text("Graph Info", 615, 725, 20, "#ccf4f1");
    private static Text info = new Text("This is Graph2. \nThis graph is undirected and has 5 nodes.", 100, 600, 20, "#ccf4f1");

    private List<Node> l1 = this.initNodes(n1);
    private List<Node> l2 = this.initNodes(n2);
    private List<Node> l3 = this.initNodes(n3);
    private List<Node> l4 = this.initNodes(n4);
    private List<Node> l5 = this.initNodes(n5);

    public Graph2() {
    }

    public void showGraph2() {

        GameArena arena_graph2 = new GameArena(800, 800);
        arena_graph2.getFrame().setDefaultCloseOperation(arena_graph2.getFrame().DISPOSE_ON_CLOSE);

        this.addEdges(n1, n2, arena_graph2, false, "null", 2);
        this.addEdges(n1, n3, arena_graph2, false, "null", 2);
        this.addEdges(n1, n4, arena_graph2, false, "null", 2);
        this.addEdges(n1, n5, arena_graph2, false, "null", 2);

        this.addEdges(n2, n3, arena_graph2, false, "null", 2);
        this.addEdges(n2, n4, arena_graph2, false, "null", 2);
        this.addEdges(n2, n5, arena_graph2, false, "null", 2);
            
        this.addEdges(n3, n4, arena_graph2, false, "null", 2);
        this.addEdges(n3, n5, arena_graph2, false, "null", 2);

        this.addEdges(n4, n5, arena_graph2, false, "null", 2);

        this.printGraph();

        this.addNodes(arena_graph2);

        Text txt1 = new Text(this.getConnections(n1), 80, 600, 20, "#ccf4f1");
        Text txt2 = new Text(this.getConnections(n2), 80, 600, 20, "#ccf4f1");
        Text txt3 = new Text(this.getConnections(n3), 80, 600, 20, "#ccf4f1");
        Text txt4 = new Text(this.getConnections(n4), 80, 600, 20, "#ccf4f1");
        Text txt5 = new Text(this.getConnections(n5), 80, 600, 20, "#ccf4f1");

        arena_graph2.addRectangle(exit);
        arena_graph2.addText(exit_text);
        arena_graph2.addRectangle(graph_info);
        arena_graph2.addText(info_text);

        arena_graph2.update();

        while (exit_pressed == false) {

            arena_graph2.update();

            if (arena_graph2.leftMousePressed() && arena_graph2.objectClicked(exit)) {
                arena_graph2.exit();
                this.closeGraph();
            }
            else if (arena_graph2.leftMousePressed() && arena_graph2.objectClicked(graph_info)) {
                this.removeItems(arena_graph2, txt1, txt2, txt3, txt4, txt5, info);
                arena_graph2.addText(info);
            }

            else if (arena_graph2.leftMousePressed() && arena_graph2.objectClicked(n1)) {
                this.removeItems(arena_graph2, txt1, txt2, txt3, txt4, txt5, info);
                arena_graph2.addText(txt1);
            }

            else if (arena_graph2.leftMousePressed() && arena_graph2.objectClicked(n2)) {
                this.removeItems(arena_graph2, txt1, txt2, txt3, txt4, txt5, info);
                arena_graph2.addText(txt2);
            }

            else if (arena_graph2.leftMousePressed() && arena_graph2.objectClicked(n3)) {
                this.removeItems(arena_graph2, txt1, txt2, txt3, txt4, txt5, info);
                arena_graph2.addText(txt3);
            }

            else if (arena_graph2.leftMousePressed() && arena_graph2.objectClicked(n4)) {
                this.removeItems(arena_graph2, txt1, txt2, txt3, txt4, txt5, info);
                arena_graph2.addText(txt4);
            }

            else if (arena_graph2.leftMousePressed() && arena_graph2.objectClicked(n5)) {
                this.removeItems(arena_graph2, txt1, txt2, txt3, txt4, txt5, info);
                arena_graph2.addText(txt5);
            }
        }
    }

    public void removeItems(GameArena arena, Text t1, Text t2, Text t3, Text t4, Text t5, Text i) {

        arena.removeText(t1);
        arena.removeText(t2);
        arena.removeText(t3);
        arena.removeText(t4);
        arena.removeText(t5);
        arena.removeText(i);
    }
}