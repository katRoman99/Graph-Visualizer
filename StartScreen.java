public class StartScreen {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int FONT_SIZE = 40;
    private static final int FONT_SIZE2 = 30;
    private static final String FONT_COLOUR = "#ccf4f1";
    private static final String FONT_COLOUR2 = "#a97777";
    private static boolean state = true;
    private static Text welcome = new Text("Your SCC 120 Graph Visualizer", WIDTH/2 - 320, HEIGHT/3,FONT_SIZE, FONT_COLOUR);
    private static Text press_space = new Text("Press space button to continue", WIDTH/2 - 250, HEIGHT - 200, FONT_SIZE2, FONT_COLOUR2);


    public StartScreen(GameArena arena) {

        arena.addText(welcome);
        arena.addText(press_space);
        arena.update();
     
        while (state == true) {
            arena.update();
            if (arena.spacePressed()) {

                arena.removeText(welcome);
                arena.removeText(press_space);
                arena.update();
                state = false;
            }
        }
    }

    public boolean getState() {

        return state;
    }
        //Navigation with a mouse click or with arrow keys?
}