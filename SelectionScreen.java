public class SelectionScreen {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int REC_W = 200;
    private static final int REC_H = 100;
    private static final int FONT_SIZE = 40;
    private static final String FONT_COLOUR = "#ccf4f1";

    private boolean state = true;
    private static Object arena_object;

    private static Text selection1 = new Text("Welcome to the Graph Selection", WIDTH/2 - 315, HEIGHT/4 - 100,FONT_SIZE, FONT_COLOUR);
    private static Text g1 = new Text("Graph 1", WIDTH/5 - 70, HEIGHT/2.5 + 10, FONT_SIZE, FONT_COLOUR);
    private static Text g2 = new Text("Graph 2", WIDTH/5 +  REC_W - 40, HEIGHT/2.5 + 10, FONT_SIZE, FONT_COLOUR);
    private static Text g3 = new Text("Graph 3", WIDTH/5 + 2*REC_W - 10, HEIGHT/2.5 + 10, FONT_SIZE, FONT_COLOUR);
    private static Text g4 = new Text("Graph 4", WIDTH/5 - 70, HEIGHT/1.7 + 10, FONT_SIZE, FONT_COLOUR);
    private static Text g5 = new Text("Graph 5", WIDTH/5 +  REC_W - 40, HEIGHT/1.7 + 10, FONT_SIZE, FONT_COLOUR);
    private static Text exit_txt = new Text("EXIT", WIDTH/1.6 +  REC_W - 60, HEIGHT-45 + 10, FONT_SIZE, "WHITE");

    private Rectangle rec1 = new Rectangle(WIDTH/5+10, HEIGHT/2.5, REC_W, REC_H, "#a97777");
    private Rectangle rec2 = new Rectangle(WIDTH/5 + REC_W+40, HEIGHT/2.5, REC_W, REC_H, "#a97777");
    private Rectangle rec3 = new Rectangle(WIDTH/5 + 2*REC_W+70, HEIGHT/2.5, REC_W, REC_H, "#a97777");
    private Rectangle rec4 = new Rectangle(WIDTH/5+10, HEIGHT/1.7, REC_W, REC_H, "#a97777");
    private Rectangle rec5 = new Rectangle(WIDTH/5 + REC_W+40, HEIGHT/1.7, REC_W, REC_H, "#a97777");
    private Rectangle exit_app = new Rectangle(WIDTH/1.8 + REC_W+40, HEIGHT- 50, 170, 80, "A2B0AD");

    private static boolean mouse = true;

    public SelectionScreen() {

    }

    public void showSelectScreen() {

        GameArena arena = new GameArena(WIDTH, HEIGHT);
        arena_object = arena;
        arena.getFrame().setDefaultCloseOperation(arena.getFrame().DISPOSE_ON_CLOSE);
        this.addObjects(arena);
            
            while (mouse == true) {

                ((GameArena)arena_object).update();

                if ( ((GameArena)arena_object).leftMousePressed() && ((GameArena)arena_object).objectClicked(rec1)) {
                        ((GameArena)arena_object).exit();
                        Graph1 graph1 = new Graph1();
                        graph1.showGraph1();
                        ((GameArena)arena_object).update();
                        //mouse = false;

                        //while(mouse == false)
                }

                else if ( ((GameArena)arena_object).leftMousePressed() && ((GameArena)arena_object).objectClicked(rec2)) {
                        ((GameArena)arena_object).exit();
                        Graph2 graph2 = new Graph2();
                        graph2.showGraph2();
                        ((GameArena)arena_object).update();
                }

                else if ( ((GameArena)arena_object).leftMousePressed() && ((GameArena)arena_object).objectClicked(rec3)) {
                        ((GameArena)arena_object).exit();
                        Graph3 graph3 = new Graph3();
                        graph3.showGraph3();
                        ((GameArena)arena_object).update();
                }

                else if ( ((GameArena)arena_object).leftMousePressed() && ((GameArena)arena_object).objectClicked(rec4)) {
                        ((GameArena)arena_object).exit();
                        Graph4 graph4 = new Graph4();
                        graph4.showGraph4();
                        ((GameArena)arena_object).update();
                }

                else if ( ((GameArena)arena_object).leftMousePressed() && ((GameArena)arena_object).objectClicked(rec5)) {
                        ((GameArena)arena_object).exit();
                        Graph5 graph5 = new Graph5();
                        graph5.showGraph5();
                        ((GameArena)arena_object).update();
                }

                else if ( ((GameArena)arena_object).leftMousePressed() && ((GameArena)arena_object).objectClicked(exit_app)) {
                    state = false;
                    this.closeApp(state);
                }
            }
    }

    public boolean getState() {

        return state;
    }

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

    public void closeSelection() {
        
        ((GameArena)arena_object).exit();
    }

    public GameArena getArena() {
        return (GameArena) arena_object;
    }

    public void closeApp(boolean state) {
        if (state == false) {
            ((GameArena)arena_object).getFrame().setDefaultCloseOperation(((GameArena)arena_object).getFrame().EXIT_ON_CLOSE);
            this.closeSelection();
        }
    }
}