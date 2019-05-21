/**
 * This class builds a StartScreen as an introduction to the application when executed.
 * Uses a GameArena class to create a window on which objects will be displayed.
 * Text class is used as well to display any textual information.
 * 
 * Created to be displayed before the SelectionScreen as a user welcome.
 *
 * @see SelectionScreen
 * @see Text
 * @see GameArena
 *
 */

public class StartScreen {

    //Variables indicating basic information needed to create a GameArena instance as well as Text
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int FONT_SIZE = 40;
    private static final int FONT_SIZE2 = 30;
    private static final String FONT_COLOUR = "#ccf4f1";
    private static final String FONT_COLOUR2 = "#a97777";


    private GameArena start_arena = new GameArena(WIDTH, HEIGHT);

    private boolean state = true;
    private Text welcome = new Text("Your SCC 120 Graph Visualizer", WIDTH/2 - 320, HEIGHT/3,FONT_SIZE, FONT_COLOUR);
    private Text press_space = new Text("Press space button to continue", WIDTH/2 - 250, HEIGHT - 200, FONT_SIZE2, FONT_COLOUR2);

    /**
     * Constructor. Takes no parameters, adds all the necessary components to greet and introduce the user to the program
     */
    public StartScreen() {

        start_arena.getFrame().setDefaultCloseOperation(start_arena.getFrame().HIDE_ON_CLOSE);
        start_arena.addText(welcome);
        start_arena.addText(press_space);
        start_arena.update();
     
        while (state == true) {
            start_arena.update();

            //When space is pressed close this StartScreen (used to switch to the SelectionScreen)
            if (start_arena.spacePressed()) {

                start_arena.exit();
                state = false;
            }
        }
    }

    /**
     * Method that obtains a state of this StartScreen.
     * 
     * @return true when StartScreen is active, false when is closed.
     */
    public boolean getState() {
        return state;
    }
}