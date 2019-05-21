/**
 * Main class that acts as an intermediate between the StartScreen and SelectionScreen.
 * Handles the execution of the whole application.
 */

public class MainScreen {

    private static boolean mouse = true;

    public static void main(String[] args) {

        StartScreen start = new StartScreen();

        if (start.getState() == false) {

            SelectionScreen select = new SelectionScreen();
            select.showSelectScreen();
        }
    }
}