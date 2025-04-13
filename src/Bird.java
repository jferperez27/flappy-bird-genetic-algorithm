import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bird {

    private Circle birdBody;
    private Pane gamePane;
    private double y;
    private double velocity;
    private static final double RADIUS = 15;
    private static final double GRAVITY = 0.6;
    private static final double FLAP_STRENGTH = -10;
    public Bird(Pane gamePane) {
        this.gamePane = gamePane;
        this.velocity = 0;
        this.y = 300;
        this.birdBody = new Circle(20, Color.YELLOW);
        this.gamePane.getChildren().add(this.birdBody);
        this.birdBody.setCenterY(this.y);
        this.birdBody.setCenterX(100);
    }

    public void update() {
        velocity += GRAVITY;
        y += velocity;
        birdBody.setCenterY(y);
    }

    public void flap() {
        this.velocity = FLAP_STRENGTH;
    }

}
