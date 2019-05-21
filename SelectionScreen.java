/**
 * This class builds a SelectionScreen from which a user can pick a particular Graph to
 * be displayed. Modelled to be executed after the StartScreen class which introduces
 * the user to the GraphVisualizer program.
 * 
 * Uses a GameArena class to create a window on which objects will be displayed.
 * Text class is used as well to display any textual information.
 *
 * @see StartScreen
 * @see Text
 * @see GameArena
 * @see Graph
 * @see Graph1
 * @see Graph2
 * @see Graph3
 * @see Graph4
 * @see Graph5
 *
 */

public class SelectionScreen {

    //Variables indicating basic information needed to create a GameArena instance as well as Text
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int FONT_SIZE = 40;
    private static final int FONT_SIZE2 = 30;
    private static final String FONT_COLOUR = "#ccf4f1";
    private static final String FONT_COLOUR2 = "#a97777";
    private static final int REC_W = 200;
    private static final int REC_H = 100;


    private boolean state = true;

    //Stores the GameArena instance
    private Object arena_object;

    //Insatnce variables acting as a sort of Menu
    private Text selection1 = new Text("Welcome to the Graph Selection", WIDTH/2 - 315, HEIGHT/4 - 100,FONT_SIZE, FONT_COLOUR);
    private Text g1 = new Text("Graph 1", WIDTH/5 - 70, HEIGHT/2.5 + 10, FONT_SIZE, FONT_COLOUR);
    private Text g2 = new Text("Graph 2", WIDTH/5 +  REC_W - 40, HEIGHT/2.5 + 10, FONT_SIZE, FONT_COLOUR);
    private Text g3 = new Text("Graph 3", WIDTH/5 + 2*REC_W - 10, HEIGHT/2.5 + 10, FONT_SIZE, FONT_COLOUR);
    private Text g4 = new Text("Graph 4", WIDTH/5 - 70, HEIGHT/1.7 + 10, FONT_SIZE, FONT_COLOUR);
    private Text g5 = new Text("Graph 5", WIDTH/5 +  REC_W - 40, HEIGHT/1.7 + 10, FONT_SIZE, FONT_COLOUR);
    private Text exit_txt = new Text("EXIT", WIDTH/1.6 +  REC_W - 60, HEIGHT-45 + 10, FONT_SIZE, "WHITE");

    private Rectangle rec1 = new Rectangle(WIDTH/5+10, HEIGHT/2.5, REC_W, REC_H, "#a97777");
    private Rectangle rec2 = new Rectangle(WIDTH/5 + REC_W+40, HEIGHT/2.5, REC_W, REC_H, "#a97777");
    private Rectangle rec3 = new Rectangle(WIDTH/5 + 2*REC_W+70, HEIGHT/2.5, REC_W, REC_H, "#a97777");
    private Rectangle rec4 = new Rectangle(WIDTH/5+10, HEIGHT/1.7, REC_W, REC_H, "#a97777");
    private Rectangle rec5 = new Rectangle(WIDTH/5 + REC_W+40, HEIGHT/1.7, REC_W, REC_H, "#a97777");
    private Rectangle exit_app = new Rectangle(WIDTH/1.8 + REC_W+40, HEIGHT- 50, 170, 80, "A2B0AD");


    /**
     * Constructor. Takes no parameters, waits for the showSelectScreen() method
     * to be invoked.
     */
    public SelectionScreen() {
    }

    /**
     * Method creating a SelectionScreen from which a user can navigate to
     * different Graphs. Creates instances of particular Graphs when
     * an appropriate button (Rectangle) is clicked.
     */
    public void showSelectScreen() {

        GameArena arena = new GameArena(WIDTH, HEIGHT);
        arena_object = arena;
        arena.getFrame().setDefaultCloseOperation(arena.getFrame().DISPOSE_ON_CLOSE);
        this.addObjects(arena);
            
            while (true) {

                ((GameArena)arena_object).update();

                if ( ((GameArena)arena_object).leftMousePressed() && ((GameArena)arena_object).objectClicked(rec1)) {
                        ((GameArena)arena_object).exit();
                        Graph1 graph1 = new Graph1("8C04E5", "#F0FFFF", "A", "B", "C", "D");
                        graph1.showGraph1();
                        ((GameArena)arena_object).update();

                }

                else if ( ((GameArena)arena_object).leftMousePressed() && ((GameArena)arena_object).objectClicked(rec2)) {
                        ((GameArena)arena_object).exit();
                        Graph2 graph2 = new Graph2("E5DD04" , "#F0FFF0", "E", "F", "G", "H", "I");
                        graph2.showGraph2();
                        ((GameArena)arena_object).update();
                }

                else if ( ((GameArena)arena_object).leftMousePressed() && ((GameArena)arena_object).objectClicked(rec3)) {
                        ((GameArena)arena_object).exit();
                        Graph3 graph3 = new Graph3("2D04E5", "#00FA9A", "J", "K", "L", "M");
                        graph3.showGraph3();
                        ((GameArena)arena_object).update();
                }

                else if ( ((GameArena)arena_object).leftMousePressed() && ((GameArena)arena_object).objectClicked(rec4)) {
                        ((GameArena)arena_object).exit();
                        Graph4 graph4 = new Graph4("E50478", "#E6E6FA", "J", "K", "L", "M");
                        graph4.showGraph4();
                        ((GameArena)arena_object).update();
                }

                else if ( ((GameArena)arena_object).leftMousePressed() && ((GameArena)arena_object).objectClicked(rec5)) {
                        ((GameArena)arena_object).exit();
                        Graph5 graph5 = new Graph5("AQUA", "#FFEFD5", "0", "1", "2", "3", "4", "5", "PINK");
                        graph5.showGraph5();
                        ((GameArena)arena_object).update();
                }

                else if ( ((GameArena)arena_object).leftMousePressed() && ((GameArena)arena_object).objectClicked(exit_app)) {
                    state = false;
                    this.closeApp(state);
                }
            }
    }

    /**
     * Method that obtains a state of this SelectionScreen.
     * 
     * @return true when SelectionScreen is active, false when is closed.
     */
    public boolean getState() {
        return state;
    }

    /**
     * Adds all the components which act as Menu to the specified GameArena.
     * 
     * @param arena Arena to which navigation components are to be added.
     */
    public void addObjects(GameArena arena) {

        arena.addText(selection1);
        
        arena.addRectangle(rec1);
        arena.addRectangle(rec2);
        arena.addRectangle(rec3);
        arena.addRectangle(rec4);
        arena.addRectangle(rec5);
        arena.addRectangle(exit_app);
        arena.addText(g1);
        arena.addText(g2);
        arena.addText(g3);
        arena.addText(g4);
        arena.addText(g5);
        arena.addText(exit_txt);
        arena.update();
    }

    /**
     * Used to close this SelectionScreen upon termination of the application
     * or displaying a particular Graph.
     */
    public void closeSelection() {
        ((GameArena)arena_object).exit();
    }

    /**
     * Obtains the GameArena that this SelectionScreen uses to display menu
     * components.
     * 
     * @return arena_object
     */
    public GameArena getArena() {
        return (GameArena) arena_object;
    }

    /**
     * Fetching the state of this SelectionScreen to determine whether the
     * termination of the whole application should be performed.
     * 
     * @param state State of the SelectionScreen, true for active, false for termination.
     */
    public void closeApp(boolean state) {
        if (state == false) {
            ((GameArena)arena_object).getFrame().setDefaultCloseOperation(((GameArena)arena_object).getFrame().EXIT_ON_CLOSE);
            this.closeSelection();
        }
    }
}