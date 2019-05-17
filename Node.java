public class Node {
    
        String label;
        Ball ball;
        Text text;
        String colour;
        Line ln;
        Arrow arr;
        double XPosition;
        double YPosition;

        public Node(String label, double x, double y, String colour) {
            this.label = label;
            this.ball = new Ball(x, y, 30, colour);
            this.text = new Text(label, x-5, y+5, 20, "BLACK");
            this.XPosition = x;
            this.YPosition = y;
        }

        public double getXPosition() {
            return XPosition;
        }

        public double getYPosition() {
            return YPosition;
        }

        public String getData() {
            return label;
        }

        public Ball getBall() {
            return ball;
        }
    }