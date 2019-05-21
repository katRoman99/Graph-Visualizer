import java.util.*;

/**
 * This class builds a more complex directed Graph containing 6 Nodes, creates a seperate GameArena 
 * and displays it on that Arena.
 * 
 * Not suited for building graphs dynamically (yet:) .
 *
 * Based on a Graph class.
 * Instances of the Node class are used here to form the graph.
 * Instances of a ball class act as a visual representation of a Node.
 * This class also makes a use of a GameArena class in which the graph is to be drawn.
 *
 * @see Graph
 * @see Node
 * @see GameArena
 * @see Ball
 *
 */

public class Graph5 extends Graph {

    //Parameters storing such information as a colour of Nodes and data that each of them will store
    private String node_col;
    private String font_col;
    private String n0_data;
    private String n1_data;
    private String n2_data;
    private String n3_data;
    private String n4_data;
    private String n5_data;

    //Holds a colour in which the Nodes are to be highlighted when performing traversals
    private String traversal_col;

    //Lines acting as Arrows for Nodes with self-arcs
    private Line h1 = new Line(619, 526, 628 ,522, 4, "WHITE");
    private Line h2 = new Line(619, 526, 627 ,534, 4, "WHITE");

    //List that holds Nodes which were already visited when performing traversals
    private LinkedList<Node> visited = new LinkedList<Node>();

    //Nodes that are used to form this graph
    private Node n0;
    private Node n1;
    private Node n2;
    private Node n3;
    private Node n4;
    private Node n5;

    //All the edges of particular Nodes in a Text form
    private Text n0_edges;
    private Text n1_edges;
    private Text n2_edges;
    private Text n3_edges;
    private Text n4_edges;
    private Text n5_edges;

    //Boolean indicating the depth-first traversal
    private boolean isDepth = false;

    //Boolean indicating that the user entered a one of the traversal modes
    private boolean traverseON = false;

    //Rectangles for normal options such as info and back button
    private Rectangle exit = new Rectangle(100, 720, 100, 60, "#a97777");
    private Text exit_text = new Text("Back", 75, 725, 20, "ccf4f1");
    private Rectangle graph_info = new Rectangle(670, 720, 150, 60, "#a97777");
    private Text info_text = new Text("Graph Info", 615, 725, 20, "ccf4f1");

    //Additional Rectangles acting as buttons for traversal options
    private Rectangle depth = new Rectangle(280, 720, 150, 60, "#a97777");
    private Rectangle breadth = new Rectangle(480, 720, 150, 60, "#a97777");
    private Text depth_text = new Text("Depth-first\n traversal", 225, 715, 20, "ccf4f1");
    private Text breadth_text = new Text("Breadth-first\n traversal", 420, 715, 20, "ccf4f1");
    private Text general_info = new Text("This is Graph5. \nThis graph is directed and has 6 nodes.", 100, 85, 20, "ccf4f1");

    //Initializing empty lists to store adjacent nodes
    private List<Node> l0;
    private List<Node> l1;
    private List<Node> l2;
    private List<Node> l3;
    private List<Node> l4;
    private List<Node> l5;


    /**
     * Constructor. Creates an instance of this Graph5 class which consists of 6 Nodes and is directed
     * and allows to perform a depth-first and breadth-first traversals.
     * 
     * @param node_col Colour of the Nodes
     * @param font_col Colour of the font in which the information will be displayed
     * @param n0_data Data that Node0 will store
     * @param n1_data Data that Node1 will store
     * @param n2_data Data that Node2 will store
     * @param n3_data Data that Node3 will store
     * @param n4_data Data that Node4 will store
     * @param n5_data Data that Node5 will store
     * @param traversal_col Colour of the Node when traversing through the Graph
     */
    public Graph5(String node_col, String font_col, String n0_data, 
                  String n1_data, String n2_data, String n3_data, 
                  String n4_data, String n5_data, String traversal_col)
    {
        this.node_col = node_col;
        this.font_col = font_col;
        this.n0_data = n0_data;
        this.n1_data = n1_data;
        this.n2_data = n2_data;
        this.n3_data = n3_data;
        this.n4_data = n4_data;
        this.n5_data = n5_data;
        this.traversal_col = traversal_col;
    }

    /**
     * Method creating a GameArena specifically for this Graph5 class.
     * Creates both a visual and internal representation of a Graph
     * by adding edges to vertices and populating the adjacency list.
     */
    public void showGraph5() {

        GameArena arena_graph5 = new GameArena(800, 800);
        arena_graph5.getFrame().setDefaultCloseOperation(arena_graph5.getFrame().DISPOSE_ON_CLOSE);

        //Populating Nodes with necessary data such as String, coordinates and colour
        n0 = new Node(n0_data, 400, 170, node_col);
        n1 = new Node(n1_data, 200, 200, node_col);
        n2 = new Node(n2_data, 600, 200, node_col);
        n3 = new Node(n3_data, 200, 500, node_col);
        n4 = new Node(n4_data, 400, 470, node_col);
        n5 = new Node(n5_data, 600, 500, node_col);

        l0 = this.initNodes(n0);
        l1 = this.initNodes(n1);
        l2 = this.initNodes(n2);
        l3 = this.initNodes(n3);
        l4 = this.initNodes(n4);
        l5 = this.initNodes(n5);

        //Populating the adjacency list
        this.addEdges(n0, n1, arena_graph5, true, "null", 85.0);
        this.addEdges(n0, n2, arena_graph5, true, "null", 85.0);
        this.addEdges(n1, n3, arena_graph5, true, "null", 91.0);
        this.addEdges(n2, n0, arena_graph5, true, "null", 85.0);
        this.addEdges(n2, n4, arena_graph5, true, "null", 91.0);
        this.addEdges(n4, n3, arena_graph5, true, "null", 85.0);
        this.addEdges(n4, n1, arena_graph5, true, "null", 91.0);
        this.addEdges(n4, n5, arena_graph5, true, "null", 85.0);
        this.addEdges(n5, n5, arena_graph5, true, "right", 100.0);

        n0_edges = new Text(this.getConnections(n0), 80, 600, 20, font_col);
        n1_edges = new Text(this.getConnections(n1), 80, 600, 20, font_col);
        n2_edges = new Text(this.getConnections(n2), 80, 600, 20, font_col);
        n3_edges = new Text("This is node" + n3.getData() + ": <no connection with other nodes>.", 80, 600, 20, font_col);
        n4_edges = new Text(this.getConnections(n4), 80, 600, 20, font_col);
        n5_edges = new Text(this.getConnections(n5), 80, 600, 20, font_col);

        this.addNodes(arena_graph5);

        //Adding traversal options "buttons"
        this.addTraversalOptions(arena_graph5);

        // Adding basic options "buttons" such as information and back button
        this.addOptions(arena_graph5, exit, exit_text, graph_info, info_text);

        this.printGraph();

        //Adding Arrows (Lines) for Vertices with self-arcs
        arena_graph5.addLine(h1);
        arena_graph5.addLine(h2);
        arena_graph5.update();

        //Checking whether any Node or button has been clicked and invoking an appropriate action upon this event.
        while (true) {
            arena_graph5.update();

            if (arena_graph5.leftMousePressed() && arena_graph5.objectClicked(exit)) {
                arena_graph5.exit();
                this.closeGraph();
            }
            else if (arena_graph5.leftMousePressed() && arena_graph5.objectClicked(graph_info)) {
                this.removeOptions(arena_graph5);
                arena_graph5.addText(general_info);
            }

            if (arena_graph5.leftMousePressed() && arena_graph5.objectClicked(n0)) {
                this.removeOptions(arena_graph5);
                arena_graph5.addText(n0_edges);
            }

            else if (arena_graph5.leftMousePressed() && arena_graph5.objectClicked(n1)) {
                this.removeOptions(arena_graph5);
                arena_graph5.addText(n1_edges);
            }

            else if (arena_graph5.leftMousePressed() && arena_graph5.objectClicked(n2)) {
                this.removeOptions(arena_graph5);
                arena_graph5.addText(n2_edges);
            }

            else if (arena_graph5.leftMousePressed() && arena_graph5.objectClicked(n3)) {
                this.removeOptions(arena_graph5);
                arena_graph5.addText(n3_edges);
            }

            else if (arena_graph5.leftMousePressed() && arena_graph5.objectClicked(n4)) {
                this.removeOptions(arena_graph5);
                arena_graph5.addText(n4_edges);
            }

            else if (arena_graph5.leftMousePressed() && arena_graph5.objectClicked(n5)) {
                this.removeOptions(arena_graph5);
                arena_graph5.addText(n5_edges);
            }

            else if (arena_graph5.leftMousePressed() && arena_graph5.objectClicked(depth)) {
                traverseON = true;
                isDepth = true;
                this.removeOptions(arena_graph5);
                arena_graph5.removeRectangle(graph_info);
                arena_graph5.removeText(info_text);
                this.removeTraversalOptions(arena_graph5);
                this.traverse(arena_graph5);
                this.addOptions(arena_graph5, exit, exit_text, graph_info, info_text);
                this.addTraversalOptions(arena_graph5);
            }

            else if (arena_graph5.leftMousePressed() && arena_graph5.objectClicked(breadth)) {
                traverseON = true;
                isDepth = false;
                this.removeOptions(arena_graph5);
                arena_graph5.removeRectangle(graph_info);
                arena_graph5.removeText(info_text);
                this.removeTraversalOptions(arena_graph5);
                this.traverse(arena_graph5);
                this.addOptions(arena_graph5, exit, exit_text, graph_info, info_text);
                this.addTraversalOptions(arena_graph5);
            }
        }
    }

    /**
     * A method that removes all the Text information displayed on the screen when necessary.
     * 
     * @param arena Arena on which the information is displayed and is to be removed from
     */
    public void removeOptions(GameArena arena) 
    {
        arena.removeText(n0_edges);
        arena.removeText(n1_edges);
        arena.removeText(n2_edges);
        arena.removeText(n3_edges);
        arena.removeText(n4_edges);
        arena.removeText(n5_edges);
        arena.removeText(general_info);
    }

    /**
     * Adds the options buttons typical of traversals
     * 
     * @param arena Arena to which the "buttons" are to be added
     */
    public void addTraversalOptions(GameArena arena) {
        arena.addRectangle(breadth);
        arena.addText(breadth_text);
        arena.addRectangle(depth);
        arena.addText(depth_text);
    }

     /**
     * Removes the options buttons typical of traversals
     * 
     * @param arena Arena from which the "buttons" are to be removed
     */
    public void removeTraversalOptions(GameArena arena) {
        arena.removeRectangle(breadth);
        arena.removeText(breadth_text);
        arena.removeRectangle(depth);
        arena.removeText(depth_text);
    }

    /**
     * A method that checks if Nodes/ back button is clicked when in traversal mode.
     * Also determines which traversal to take.
     * <b>Note: </b> Uses a visited LinkedList to determine which Nodes were already visited.
     * 
     * @param arena Arena that needs to be updated when Nodes are animated during traversals
     */
    public void traverse(GameArena arena) {
        arena.update();

        while(traverseON) {
            arena.update();

            if (arena.leftMousePressed() && arena.objectClicked(n0)) {
                if (isDepth) {
                    this.depthTraversal(n0, visited);
                    this.printDepth(visited, arena, traversal_col);
                }

                else {
                    this.breadthTraversal(n0, visited);
                    this.printBreadth(visited, arena, traversal_col);
                }
            }

            else if (arena.leftMousePressed() && arena.objectClicked(n1)) {
                if (isDepth) {
                    this.depthTraversal(n1, visited);
                    this.printDepth(visited, arena, traversal_col);
                }

                else {
                    this.breadthTraversal(n1, visited);
                    this.printBreadth(visited, arena, traversal_col);
                }
            }

            else if (arena.leftMousePressed() && arena.objectClicked(n2)) {
                if (isDepth == true) {
                    this.depthTraversal(n2, visited);
                    this.printDepth(visited, arena, traversal_col);
                }

                else {
                    this.breadthTraversal(n2, visited);
                    this.printBreadth(visited, arena, traversal_col);
                }
            }

            else if (arena.leftMousePressed() && arena.objectClicked(n3)) {
                if (isDepth == true) {
                    this.depthTraversal(n3, visited);
                    this.printDepth(visited, arena, traversal_col);
                }

                else {
                    this.breadthTraversal(n3, visited);
                    this.printBreadth(visited, arena, traversal_col);
                }
            }

            else if (arena.leftMousePressed() && arena.objectClicked(n4)) {
                if (isDepth == true) {
                    this.depthTraversal(n4, visited);
                    this.printDepth(visited, arena, traversal_col);
                }

                else {
                    this.breadthTraversal(n4, visited);
                    this.printBreadth(visited, arena, traversal_col);
                }
            }

            else if (arena.leftMousePressed() && arena.objectClicked(n5)) {
                if (isDepth == true) {
                    this.depthTraversal(n5, visited);
                    this.printDepth(visited, arena, traversal_col);
                }

                else {
                    this.breadthTraversal(n5, visited);
                    this.printBreadth(visited, arena, traversal_col);
                }
            }

            else if (arena.leftMousePressed() && arena.objectClicked(exit)) {
                isDepth = false;
                traverseON = false;
            }

            //At the end reset the colour to its original state
            this.resetColour(visited,arena, node_col);
            visited.clear();
        }
        return;
    }
}