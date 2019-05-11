public class SelectionScreen {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int REC_W = 200;
    private static final int REC_H = 100;
    private static final int FONT_SIZE = 40;
    private static final String FONT_COLOUR = "#ccf4f1";

    private boolean state = true;
    private Object object;

    private static Text selection1 = new Text("Welcome to the Graph Selection", WIDTH/2 - 315, HEIGHT/4 - 100,FONT_SIZE, FONT_COLOUR);
    private static Text g1 = new Text("Graph 1", WIDTH/5 - 70, HEIGHT/2.5 + 10, FONT_SIZE, FONT_COLOUR);
    private static Text g2 = new Text("Graph 2", WIDTH/5 +  REC_W - 40, HEIGHT/2.5 + 10, FONT_SIZE, FONT_COLOUR);
    private static Text g3 = new Text("Graph 3", WIDTH/5 + 2*REC_W - 10, HEIGHT/2.5 + 10, FONT_SIZE, FONT_COLOUR);
    private static Text g4 = new Text("Graph 4", WIDTH/5 - 70, HEIGHT/1.7 + 10, FONT_SIZE, FONT_COLOUR);
    private static Text g5 = new Text("Graph 5", WIDTH/5 +  REC_W - 40, HEIGHT/1.7 + 10, FONT_SIZE, FONT_COLOUR);

    private Rectangle rec1 = new Rectangle(WIDTH/5+10, HEIGHT/2.5, REC_W, REC_H, "#a97777");
    private Rectangle rec2 = new Rectangle(WIDTH/5 + REC_W+40, HEIGHT/2.5, REC_W, REC_H, "#a97777");
    private Rectangle rec3 = new Rectangle(WIDTH/5 + 2*REC_W+70, HEIGHT/2.5, REC_W, REC_H, "#a97777");
    private Rectangle rec4 = new Rectangle(WIDTH/5+10, HEIGHT/1.7, REC_W, REC_H, "#a97777");
    private Rectangle rec5 = new Rectangle(WIDTH/5 + REC_W+40, HEIGHT/1.7, REC_W, REC_H, "#a97777");

    private static boolean mouse = true;

    public SelectionScreen(GameArena arena) {

        this.addObjects(arena);

        while(mouse == true) {

            arena.update();

            if (arena.leftMousePressed()) {

                if (arena.objectClicked(rec1)) {
                    this.removeObjects(arena);
                    Graph1 graph = new Graph1(arena);
                    mouse = false;
                }
                else if (arena.objectClicked(rec2)) {
                    this.removeObjects(arena);
                    Graph2 graph = new Graph2(arena);
                    mouse = false;
                }
                else if (arena.objectClicked(rec3)) {
                    this.removeObjects(arena);
                    Graph3 graph = new Graph3(arena);
                    mouse = false;
                }
                else if (arena.objectClicked(rec4)) {
                    this.removeObjects(arena);
                    Graph4 graph = new Graph4(arena);
                    mouse = false;
                }
                else if (arena.objectClicked(rec5)) {
                    this.removeObjects(arena);
                    Graph5 graph = new Graph5(arena);
                    mouse = false;
                }
            }
            /*else if (arena.rightMousePressed() && mouse == false) {

                if (object instanceof Graph1 || object instanceof Graph2 || object instanceof Graph3 || object instanceof Graph4 || object instanceof Graph5) {
                    object.removeGraph(arena);
                }
                this.addObjects(arena);
                mouse = true;
                arena.update();
            }*/
        }
    }

    public boolean getState() {

        return state;
    }

    public void removeObjects(GameArena arena) {

        arena.removeRectangle(rec1);
        arena.removeRectangle(rec2);
        arena.removeRectangle(rec3);
        arena.removeRectangle(rec4);
        arena.removeRectangle(rec5);
        arena.removeText(selection1);
        arena.removeText(g1);
        arena.removeText(g2);
        arena.removeText(g3);
        arena.removeText(g4);
        arena.removeText(g5);
        arena.update();
    }

    public void addObjects(GameArena arena) {

        arena.addText(selection1);
        
        arena.addRectangle(rec1);
        arena.addRectangle(rec2);
        arena.addRectangle(rec3);
        arena.addRectangle(rec4);
        arena.addRectangle(rec5);
        arena.addText(g1);
        arena.addText(g2);
        arena.addText(g3);
        arena.addText(g4);
        arena.addText(g5);
        arena.update();
    }
}