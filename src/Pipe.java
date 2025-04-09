import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Pipe {

    private int x;
    private int gapY;
    private Rectangle topPipe;
    private Rectangle bottomPipe;
    private Pane myGamePane;
    private static final int WIDTH = 80;
    private static final double GAP_HEIGHT = 175;
    private static final int SPEED = 4;
    public Pipe(int startX, int gapY, Pane gamePane) {
        this.myGamePane = gamePane;
        this.x = startX;
        this.gapY = gapY;
        this.createPipes();
    }

    private void createPipes() {
        this.topPipe = new Rectangle(WIDTH, gapY);
        this.bottomPipe = new Rectangle(WIDTH, this.gapY + GAP_HEIGHT);

        this.topPipe.setX(this.x);
        this.topPipe.setY(0);
        this.topPipe.setFill(Color.BLACK);

        this.bottomPipe.setX(this.x);
        this.bottomPipe.setY(GAP_HEIGHT + this.gapY);
        this.bottomPipe.setFill(Color.BLACK);

        this.myGamePane.getChildren().addAll(this.topPipe, this.bottomPipe);
    }

    public void update() {
        if (this.isReadyToRespawn()) {
            this.x = 1000;
            this.topPipe.setX(this.x);
            this.bottomPipe.setX(this.x);
        } else {
            this.x = this.x - SPEED;
            this.topPipe.setX(this.x);
            this.bottomPipe.setX(this.x);
        }
    }

    private boolean isReadyToRespawn() {
        if (this.topPipe.getX() < -100) {
            return true;
        }
        return false;
    }
}
