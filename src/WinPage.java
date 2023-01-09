
    import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

    public class WinPage {

        public void winStart(Board game) throws IOException {

            int[] score = game.getScore();
            System.out.println(score[0] + " " + score[1]);
            if (score[0] > score[1]) {
                Stage stage = new Stage();
                start(stage);
                String winner = "White";
                String loser  = "Black";
                setLoser(loser);
                setWinner(winner);

            }else if (score[0] < score[1]) {
                Stage stage = new Stage();
                start(stage);
                String winner = "Black";
                String loser  = "White";
                setWinner(winner);
                setLoser(loser);

            }else{
                Stage stage = new Stage();
                draw(stage);
            }

        }

        @FXML
        public void start(Stage primaryStage) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("Winpage.fxml"));
            Scene scene = new Scene(root);

            label1 = (Label) scene.lookup("#label1");
            label2 = (Label) scene.lookup("#label2");
            primaryStage.setScene(scene);
            primaryStage.show();

        }

        @FXML
        public void draw(Stage primaryStage) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("Draw.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        @FXML
        Label label1;

        @FXML
        public void setWinner(String winner) {
            label1.setText(winner);
        }

        @FXML
        Label label2;

        @FXML
        public void setLoser(String loser) {
            label2.setText(loser);
        }
    @FXML
    Button restart;

    @FXML
    public void restart() throws IOException {
        Stage stage = (Stage) restart.getScene().getWindow();
        stage.close();

        Visualizer visualizer = new Visualizer();
        visualizer.gameStart();
    }

    }


