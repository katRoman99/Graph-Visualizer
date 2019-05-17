import java.util.*;

public class Graph1 extends Graph {

    private static boolean exit_pressed = false;
    private static Rectangle exit = new Rectangle(100, 720, 100, 60, "#a97777");
    private static Rectangle graph_info = new Rectangle(670, 720, 150, 60, "#a97777");
    private static Text exit_text = new Text("Back", 75, 725, 20, "#ccf4f1");
    private static Text info_text = new Text("Graph Info", 615, 725, 20, "#ccf4f1");
    private static Text info = new Text("This is Graph1. \nThis graph is undirected and has 4 nodes.", 100, 600, 20, "#ccf4f1");

    private Node n1 = new Node("A", 200, 200, "29FAC4");
    private Node n2 = new Node("B", 350, 200, "29FAC4");
    private Node n3 = new Node("C", 200, 400, "29FAC4");
    private Node n4 = new Node("D", 350, 400, "29FAC4");

    private List<Node> l1 = this.initNodes(n1);
    private List<Node> l2 = this.initNodes(n2);
    private List<Node> l3 = this.initNodes(n3);
    private List<Node> l4 = this.initNodes(n4);

    public Graph1() {  
    }

    public void showGraph1() {

        GameArena arena_graph1 = new GameArena(800, 800);
        arena_graph1.getFrame().setDefaultCloseOperation(arena_graph1.getFrame().DISPOSE_ON_CLOSE);

        this.addEdges(n1, n2, arena_graph1, false, "null", 2);
        this.addEdges(n1, n3, arena_graph1, false, "null", 2);
        this.addEdges(n2, n4, arena_graph1, false, "null", 2);
        this.addEdges(n3, n4, arena_graph1, false, "null", 2);

        this.printGraph();

        this.addNodes(arena_graph1);

        Text txt1 = new Text(this.getConnections(n1), 80, 600, 20, "#ccf4f1");
        Text txt2 = new Text(this.getConnections(n2), 80, 600, 20, "#ccf4f1");
        Text txt3 = new Text(this.getConnections(n3), 80, 600, 20, "#ccf4f1");
        Text txt4 = new Text(this.getConnections(n4), 80, 600, 20, "#ccf4f1");


        arena_graph1.addRectangle(exit);
        arena_graph1.addRectangle(graph_info);
        arena_graph1.addText(exit_text);
        arena_graph1.addText(info_text);
        arena_graph1.update();

        while (exit_pressed == false) {
            
            arena_graph1.update();

            if (arena_graph1.leftMousePressed() && arena_graph1.objectClicked(exit)) {
                arena_graph1.exit();
                this.closeGraph();
            }

            else if (arena_graph1.leftMousePressed() && arena_graph1.objectClicked(graph_info)) {
                this.removeItems(arena_graph1, txt1, txt2, txt3, txt4, info);
                arena_graph1.addText(info);
            }

            else if (arena_graph1.leftMousePressed() && arena_graph1.objectClicked(n1)) {
                this.removeItems(arena_graph1, txt1, txt2, txt3, txt4, info);
                arena_graph1.addText(txt1);
            }

            else if (arena_graph1.leftMousePressed() && arena_graph1.objectClicked(n2)) {
                this.removeItems(arena_graph1, txt1, txt2, txt3, txt4, info);
                arena_graph1.addText(txt2);
            }

            else if (arena_graph1.leftMousePressed() && arena_graph1.objectClicked(n3)) {
                this.removeItems(arena_graph1, txt1, txt2, txt3, txt4, info);
                arena_graph1.addText(txt3);
            }

            else if (arena_graph1.leftMousePressed() && arena_graph1.objectClicked(n4)) {
                this.removeItems(arena_graph1, txt1, txt2, txt3, txt4, info);
                arena_graph1.addText(txt4);
            }
        }
    }

    public void removeItems(GameArena arena, Text t1, Text t2, Text t3, Text t4, Text i) {

        arena.removeText(t1);
        arena.removeText(t2);
        arena.removeText(t3);
        arena.removeText(t4);
        arena.removeText(i);
    }
}