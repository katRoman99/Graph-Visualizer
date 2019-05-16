public class MainScreen {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int REC_W = 200;
    private static final int REC_H = 100;
    private static final int FONT_SIZE = 40;

    private static Object arena_object;

    private static Rectangle rec1 = new Rectangle(WIDTH/5+10, HEIGHT/2.5, REC_W, REC_H, "#a97777");
    private static Rectangle rec2 = new Rectangle(WIDTH/5 + REC_W+40, HEIGHT/2.5, REC_W, REC_H, "#a97777");
    private static Rectangle rec3 = new Rectangle(WIDTH/5 + 2*REC_W+70, HEIGHT/2.5, REC_W, REC_H, "#a97777");
    private static Rectangle rec4 = new Rectangle(WIDTH/5+10, HEIGHT/1.7, REC_W, REC_H, "#a97777");
    private static Rectangle rec5 = new Rectangle(WIDTH/5 + REC_W+40, HEIGHT/1.7, REC_W, REC_H, "#a97777");

    private static boolean mouse = true;

    public static void main(String[] args) {

        StartScreen start = new StartScreen();

        if (start.getState() == false) {

            SelectionScreen select = new SelectionScreen();
            select.showSelectScreen();
        }
    }
}