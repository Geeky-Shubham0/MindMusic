import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Label stateLabel = new Label("Brain state: Unknown");

    @Override
    public void start(Stage primaryStage) {
        Button detectButton = new Button("🧠 Detect Brain State");
        Button playButton = new Button("🎧 Play Spotify Music");

        detectButton.setOnAction(e -> {
            String state = BrainStateDetector.detectState();
            stateLabel.setText("Brain state: " + state);
        });

        playButton.setOnAction(e -> {
            String currentState = stateLabel.getText().replace("Brain state: ", "");
            SpotifyMusicPlayer.play(currentState);
        });

        VBox root = new VBox(15, stateLabel, detectButton, playButton);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("AI-Driven Music App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
