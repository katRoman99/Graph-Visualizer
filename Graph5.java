import java.util.*;

public class Graph5 extends Graph {

    private Line h1 = new Line(619, 526, 628 ,522, 4, "WHITE");
    private Line h2 = new Line(619, 526, 627 ,534, 4, "WHITE");

    private Node n1 = new Node("0", 400, 170, "29FAC4");
    private Node n2 = new Node("1", 200, 200, "29FAC4");
    private Node n3 = new Node("2", 600, 200, "29FAC4");
    private Node n4 = new Node("3", 200, 500, "29FAC4");
    private Node n5 = new Node("4", 400, 470, "29FAC4");
    private Node n6 = new Node("5", 600, 500, "29FAC4");

    private static boolean exit_pressed = false;
    private static Rectangle exit = new Rectangle(100, 720, 100, 60, "#a97777");
    private static Text exit_text = new Text("Back", 75, 725, 20, "#ccf4f1");
    private static Rectangle graph_info = new Rectangle(670, 720, 150, 60, "#a97777");
    private static Rectangle breadth = new Rectangle(280, 720, 150, 60, "#a97777");
    private static Rectangle depth = new Rectangle(480, 720, 150, 60, "#a97777");
    private static Text info_text = new Text("Graph Info", 615, 725, 20, "#ccf4f1");
    private static Text breadth_text = new Text("Depth-first\n traversal", 225, 715, 20, "#ccf4f1");
    private static Text depth_text = new Text("Breadth-first\n traversal", 420, 715, 20, "#ccf4f1");
    private static Text info = new Text("This is Graph5. \nThis graph is directed and has 6 nodes.", 100, 85, 20, "#ccf4f1");

    private List<Node> l1 = this.initNodes(n1);
    private List<Node> l2 = this.initNodes(n2);
    private List<Node> l3 = this.initNodes(n3);
    private List<Node> l4 = this.initNodes(n4);
    private List<Node> l5 = this.initNodes(n5);
    private List<Node> l6 = this.initNodes(n6);

    public Graph5() {
    }

    public void showGraph5() {

        GameArena arena_graph5 = new GameArena(800, 800);
        arena_graph5.getFrame().setDefaultCloseOperation(arena_graph5.getFrame().DISPOSE_ON_CLOSE);


        this.addEdges(n1, n2, arena_graph5, true, "null", 85.0);
        this.addEdges(n1, n3, arena_graph5, true, "null", 85.0);
        this.addEdges(n2, n4, arena_graph5, true, "null", 91.0);
        this.addEdges(n3, n1, arena_graph5, true, "null", 85.0);
        this.addEdges(n3, n5, arena_graph5, true, "null", 91.0);
        this.addEdges(n5, n4, arena_graph5, true, "null", 85.0);
        this.addEdges(n5, n2, arena_graph5, true, "null", 91.0);
        this.addEdges(n5, n6, arena_graph5, true, "null", 85.0);
        this.addEdges(n6, n6, arena_graph5, true, "right", 100.0);

        this.addNodes(arena_graph5);

        Text txt1 = new Text(this.getConnections(n1), 80, 600, 20, "#ccf4f1");
        Text txt2 = new Text(this.getConnections(n2), 80, 600, 20, "#ccf4f1");
        Text txt3 = new Text(this.getConnections(n3), 80, 600, 20, "#ccf4f1");
        Text txt4 = new Text("This is node" + n4.getData() + ": <no connection with other nodes>.", 80, 600, 20, "#ccf4f1");
        Text txt5 = new Text(this.getConnections(n5), 80, 600, 20, "#ccf4f1");
        Text txt6 = new Text(this.getConnections(n6), 80, 600, 20, "#ccf4f1");

        arena_graph5.addRectangle(exit);
        arena_graph5.addText(exit_text);
        arena_graph5.addRectangle(graph_info);
        arena_graph5.addText(info_text);
        arena_graph5.addRectangle(breadth);
        arena_graph5.addText(breadth_text);
        arena_graph5.addRectangle(depth);
        arena_graph5.addText(depth_text);

        this.printGraph();
        arena_graph5.addLine(h1);
        arena_graph5.addLine(h2);
        arena_graph5.update();

        while (exit_pressed == false) {
            arena_graph5.update();

            if (arena_graph5.leftMousePressed() && arena_graph5.objectClicked(exit)) {
                arena_graph5.exit();
                this.closeGraph();
            }
            else if (arena_graph5.leftMousePressed() && arena_graph5.objectClicked(graph_info)) {
                this.removeItems(arena_graph5, txt1, txt2, txt3, txt4, txt5, txt6,info);
                arena_graph5.addText(info);
            }
            else if (arena_graph5.leftMousePressed() && arena_graph5.objectClicked(n1)) {
                this.removeItems(arena_graph5, txt1, txt2, txt3, txt4, txt5, txt6,info);
                arena_graph5.addText(txt1);
            }

            else if (arena_graph5.leftMousePressed() && arena_graph5.objectClicked(n2)) {
                this.removeItems(arena_graph5, txt1, txt2, txt3, txt4, txt5, txt6,info);
                arena_graph5.addText(txt2);
            }

            else if (arena_graph5.leftMousePressed() && arena_graph5.objectClicked(n3)) {
                this.removeItems(arena_graph5, txt1, txt2, txt3, txt4, txt5, txt6,info);
                arena_graph5.addText(txt3);
            }

            else if (arena_graph5.leftMousePressed() && arena_graph5.objectClicked(n4)) {
                this.removeItems(arena_graph5, txt1, txt2, txt3, txt4, txt5, txt6,info);
                arena_graph5.addText(txt4);
            }

            else if (arena_graph5.leftMousePressed() && arena_graph5.objectClicked(n5)) {
                this.removeItems(arena_graph5, txt1, txt2, txt3, txt4, txt5, txt6,info);
                arena_graph5.addText(txt5);
            }

            else if (arena_graph5.leftMousePressed() && arena_graph5.objectClicked(n6)) {
                this.removeItems(arena_graph5, txt1, txt2, txt3, txt4, txt5, txt6, info);
                arena_graph5.addText(txt6);
            }
        }
    }

    public void removeItems(GameArena arena, Text t1, Text t2, Text t3, Text t4, Text t5, Text t6, Text i) {

        arena.removeText(t1);
        arena.removeText(t2);
        arena.removeText(t3);
        arena.removeText(t4);
        arena.removeText(t5);
        arena.removeText(t6);
        arena.removeText(i);
    }
}