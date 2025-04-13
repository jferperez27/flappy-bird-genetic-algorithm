import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class PaneOrganizer {

    private Scene scene;
    private BorderPane root;
    private Pane gamePane;
    private ArrayList<Pipe> pipesContainer;
    private Bird bird;
    public PaneOrganizer() {
        this.root = new BorderPane();
        this.scene = new Scene(this.root, 1000, 700);
        this.gamePane = new Pane();
        this.pipesContainer = new ArrayList<>();
        this.setGamePane();
        this.pipesContainer.add(new Pipe(1000-70, 300, this.gamePane));
        this.pipesContainer.add(new Pipe(1500, 300, this.gamePane));
        this.bird = new Bird(this.gamePane);
        this.startAnimation();
        this.startKeyDetect();
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
    public Scene getScene() { return this.scene;}

    private void startAnimation() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                bird.update();
                for (Pipe pipe : pipesContainer) {
                    pipe.update();
                }

            }
        };
        timer.start();
    }

    private void startKeyDetect() {
        this.scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case SPACE : this.bird.flap();
            }
        });
    }
}