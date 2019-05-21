import java.util.*; 
  
/**
 * This class provides a simple foundation for building undirected and directed graphs 
 * when the numbers of vertices and edges are known as well as the general outline of
 * the graph.
 * 
 * Not suited for building graphs dynamically (yet:) .
 *
 * Instances of the Node class are used here to form the graph.
 * Instances of a ball class act as a visual representation of a Node.
 * This class also makes a use of a GameArena class in which the graph is to be drawn.
 *
 * @see Node
 * @see GameArena
 * @see Ball
 *
 * @author Katarzyna Romaniuk
 */

public class Graph  
{ 
    //Maps a particular Node to a corresponding list of adjacent Nodes (representation of an adjacency list)
    private Map<Node, List<Node>> adjNodes = new HashMap<Node, List<Node>>();

    private Ball b1;
    private Ball ring;

    /**
     * A method creating an empty list and mapping it to the source Node so that
     * it can holds adjacent nodes in the future.
     * 
     * @param source Node to mapped to the adjacency list
     * @return a list in which adjacent nodes will be stored
     */
    public List<Node> initNodes(Node source) {
        List<Node> list = new LinkedList<Node>();
        adjNodes.put(source, list);
        return list;
    }
    
    /**
     * Adds an edge between two Nodes using either an arrow or a simple line depending 
     * whether the connection is directed or not.
     * 
     * Makes a use of a Line class for an undirected connection and of an Arrow class for 
     * a directed one.
     * 
     * @see Arrow
     * @see Line
     * 
     * <b>Note: </b> If the connection is to be directed and a self-arc drawn, uses 2 Balls
     * to represent that arc (one inside another).
     * 
     * @param source Node from which the connection is coming out
     * @param mapped Node to be mapped to that initiating the connection
     * @param arena Arena that the Lines/Arrows/Balls (Nodes) are to be added to
     * @param directed Stating whether the connection should be directed or undirected
     * @param side If the connection is directed and a self-arc is to be drawn, this parameter indicates on which side
     * that arc should be
     * @param pos Position of the arrow along the line if the connection is directed (can hold a random value if undirected)
     * 
     */
    public void addEdges(Node source, Node mapped, GameArena arena, boolean directed, String side, double pos) 
    { 
        //Checking whether the connection goes from a node to the exact same node
        if (directed == true && source == mapped) {

            //Draw a self-arc on the right
            if (side.equals("right")) {

                List<Node> l = adjNodes.get(source);
                l.add(mapped);

                //Self arc, smaller ball inside a bigger one to give an impression of a perfectly curved line
                b1 = new Ball(source.ball.getXPosition()+30, source.ball.getYPosition(), 30, "WHITE");
                ring = new Ball(source.ball.getXPosition()+30, source.ball.getYPosition(), 26, "BLACK");

                arena.addBall(b1);
                arena.addBall(ring);
            }

            //Draw a self-arc on the left
            else if (side.equals("left")) {

                List<Node> l = adjNodes.get(source);
                l.add(mapped);

                b1 = new Ball(source.ball.getXPosition()-30, source.ball.getYPosition(), 30, "WHITE");
                ring = new Ball(source.ball.getXPosition()-30, source.ball.getYPosition(), 26, "BLACK");                

                arena.addBall(b1);
                arena.addBall(ring);
            }

            //Draw a self-arc above the node
            else if (side.equals("up")) {

                List<Node> l = adjNodes.get(source);
                l.add(mapped);

                b1 = new Ball(source.ball.getXPosition(), source.ball.getYPosition() +30, 30, "WHITE");
                ring = new Ball(source.ball.getXPosition(), source.ball.getYPosition()+30, 26, "BLACK");

                arena.addBall(b1);
                arena.addBall(ring);
            }

            //Draw a self-arc below the node
            else if (side.equals("down")) {

                List<Node> l = adjNodes.get(source);
                l.add(mapped);

                b1 = new Ball(source.ball.getXPosition(), source.ball.getYPosition()-30, 30, "WHITE");
                ring = new Ball(source.ball.getXPosition(), source.ball.getYPosition()-30, 26, "BLACK");

                arena.addBall(b1);
                arena.addBall(ring);
            }
        }

        //Checking if the connection is still directed but a node is not self-connected
        else if (directed == true && source != mapped) {

            List<Node> l = adjNodes.get(source);
            l.add(mapped);

            //Using an Arrow class as this will be a straight line
            Arrow arrow = new Arrow(source.ball.getXPosition(), source.ball.getYPosition(), mapped.ball.getXPosition(),  mapped.ball.getYPosition(), 4, "WHITE", arena);
            arrow.setArrowHeadPosition(pos);
            source.arr = arrow;
        }

        else if (directed == false) {

            List<Node> l = adjNodes.get(source);
            l.add(mapped);

            List<Node> l2 = adjNodes.get(mapped);
            l2.add(source);

            //Using a Line class to connect both Nodes
            Line line = new Line(source.ball.getXPosition(), source.ball.getYPosition(), mapped.ball.getXPosition(), mapped.ball.getYPosition(), 4, "WHITE");
            arena.addLine(line);
            source.ln = line;
        }
    }

    /**
     * Adding nodes visually on a GameArena object
     * 
     * @param arena Arena on which the Nodes will be displayed
     */
    public void addNodes(GameArena arena) {

        for (Node n: adjNodes.keySet()) {

            arena.addBall(n.ball);
            arena.addText(n.text);
        }
    }

    /**
     * Method that obtains all the adjacent Nodes to the one provided as a parameter and displays them
     * in the form of a String
     * 
     * @param n Node which adjacency list is to be displayed
     * 
     * @return String containing adjacent Nodes
     */
    public String getConnections(Node n) {
        List<String> node = new LinkedList<String>();
        String s = "This is node " + n.label + ", it has connections with the following nodes:\n";

        for (Node k : adjNodes.get(n))
            node.add(k.label);

        for(String b : node) {
            String str = "["+b+"] ";
            s = s+str; 
        }
        return s;
    }


    /**
     * Adds Rectangles which act as buttons as well as a Text on them indicating an action after a "button" is pressed.
     * 
     * @param arena Arena on which the Rectangles and Texts are to be displayed
     * @param exit A Rectangle indicating a "back" button
     * @param exit_text A Text indicating an action
     * @param graph_info A Rectangle that when pressed will show general info about a graph
     * @param info_text A text holding the general info about a graph
     * 
     */
    public void addOptions(GameArena arena, Rectangle exit, Text exit_text, Rectangle graph_info, Text info_text) {

        arena.addRectangle(exit);
        arena.addText(exit_text);
        arena.addRectangle(graph_info);
        arena.addText(info_text);
    }


    /**
     * A method which removes all Text representations of the Nodes' edges as well as the general info about
     * a graph.
     * 
     * <b>Note: </b> Exclusive only to Graph1, Graph3 and Graph4 classes as they hold the same number of Nodes.
     * 
     * @see Graph1
     * @see Graph3
     * @see Graph4 
     * 
     * @param arena Arena from which the elements are to be removed
     * @param n1_edges Text representation of the edges of the Node1
     * @param n2_edges Text representation of the edges of the Node2
     * @param n3_edges Text representation of the edges of the Node3
     * @param n4_edges Text representation of the edges of the Node4
     * @param general_info Text holding a general graph description
     */
    public void removeItems134(GameArena arena, Text n1_edges, Text n2_edges, Text n3_edges, Text n4_edges, Text general_info) {

        arena.removeText(n1_edges);
        arena.removeText(n2_edges);
        arena.removeText(n3_edges);
        arena.removeText(n4_edges);
        arena.removeText(general_info);
    }

    /**
     * Prints the Graph in the command line as adjacency lists of the Nodes
     */
    public void printGraph() {
        for (Node n : adjNodes.keySet()) {
            System.out.print("<" + n.label + ">");
            for (Node k : adjNodes.get(n)) 
                System.out.print(" ===> " + k.label);
            System.out.println("\n");
        }
        System.out.println("\n\n");
    }

    /**
     * Allows to return to the selection screen after a particular Graph screen has been closed.
     */
    public void closeGraph() {
        adjNodes.clear();
        SelectionScreen select = new SelectionScreen();
        select.showSelectScreen();
    }

    /**
     * Allows to perform a depth-first traversal on a Graph based on the Node that we start from.
     * 
     * @param n Node as a starting point
     * @param list List to hold the result of the traversal (Nodes in a proper order)
     */
    public void depthTraversal(Node n, LinkedList<Node> list) {

        list.add(n);
        for (Node k: adjNodes.get(n)) {
            if (!list.contains(k))
                depthTraversal(k, list);
        }
    }

    /**
     * Method that highlights visited Nodes in a consecutive manner allowing to visualise
     * the depth-first traversal, also prints the order to the command line.
     * 
     * @param list List holding the order of visited nodes after the invokation of
     * a depthTraversal() method
     * @param arena Arena on which the highlighting is to be performed
     * @param traversal_colour The colour in which consecutive Nodes will be highlighted
     */
    public void printDepth(LinkedList<Node> list, GameArena arena, String traversal_colour) {
        System.out.println("The depth-first traversal order when starting from the node " + list.get(0).label + ":\n");
        for (Node n: list) {
            System.out.print("["+n.label+"] ");
            n.getBall().setColour(traversal_colour);
            for (int j=0; j<70; j++)
                arena.update();
        }
        System.out.println("\n\n");
    }


    /**
     * A method that performs a breadth-first traversal on a graph depending on the Node
     * that we start from.
     * 
     * @param n Node acting as a starting point
     * @param list List that the order of visited Nodes is stored in
     */
    public void breadthTraversal(Node n, LinkedList<Node> list) {
        LinkedList<Node> queue = new LinkedList<Node>();
        list.add(n);
        queue.add(n);

        while (queue.size() > 0) {
            Node k = queue.removeFirst();

            for (Node m: adjNodes.get(k)) {
                if(!list.contains(m)) {
                    list.add(m);
                    queue.add(m);
                }
            }
        }
    }


    /**
     * Same as printDepth() but used to print and highlight a breadth-first traversal.
     *
     * @param list List holding the order of visited nodes after the invokation of
     * a breadthTraversal() method
     * @param arena Arena on which the highlighting is to be performed
     * @param traversal_colour The colour in which consecutive Nodes will be highlighted
     */
     public void printBreadth(LinkedList<Node> list, GameArena arena, String traversal_colour) {
        System.out.println("The breadth-first traversal order when starting from the node " + list.get(0).label + ":\n");
        for (Node n: list) {
            System.out.print("["+n.label+"] ");
            n.getBall().setColour(traversal_colour);
            for (int j=0; j<70; j++)
                arena.update();
        }
        System.out.println("\n\n");
    }


    /**
     * A method that resets the colour of the Nodes to what it was before an invokation of the
     * depthTraversal() / breadthTraversal() methods.
     * 
     * @param list Nodes which colours were changed
     * @param arena Arena that the Nodes are displayed on
     * @param colour String storing a colour in which the Nodes are to be displayed
     */
    public void resetColour(LinkedList<Node> list, GameArena arena, String colour) {
        for (Node n: list)
            n.getBall().setColour(colour);
        arena.update();
    }
}