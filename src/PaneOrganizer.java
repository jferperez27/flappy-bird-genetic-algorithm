import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class PaneOrganizer {

    private BorderPane root;
    private Pane gamePane;
    private ArrayList<Pipe> pipesContainer;
    private Bird bird;
    public PaneOrganizer() {
        this.root = new BorderPane();
        this.gamePane = new Pane();
        this.pipesContainer = new ArrayList<>();
        this.setGamePane();
        this.pipesContainer.add(new Pipe(1000-70, 300, this.gamePane));
        this.pipesContainer.add(new Pipe(1500, 300, this.gamePane));
        this.startAnimation();
    }

    private void setGamePane() {
        this.root.setCenter(this.gamePane);
        //To better visualize gamePane, will be redacted.
        BackgroundFill fill = new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY);
        Background back = new Background(fill);
        this.gamePane.setBackground(back);
    }

    public BorderPane getRoot() {
        return this.root;
    }

    private void startAnimation() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for (Pipe pipe : pipesContainer) {
                    pipe.update();
                }
            }
        };
        timer.start();
    }
}