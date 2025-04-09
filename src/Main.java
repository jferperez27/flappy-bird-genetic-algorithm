import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        PaneOrganizer organizer = new PaneOrganizer();
        Scene scene = new Scene(organizer.getRoot(), 1000, 700);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Flappy Bird - Genetic Algorithm");
        stage.show();
    }


    public static void main(String[] argv) {
        // launch is a method inherited from Application
        launch(argv);
    }
}
