import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;




public class Visualizer extends Application {

    private static int width = 8;
    private static int height = 8;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create GridPane, which will function as the playing board
        GridPane board = new GridPane();

        // Create 2D array of buttons, which functions as the individual cells on the playing board
        Button[][] cells = new Button[width][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j] = new Button();
                board.add(cells[i][j], i, j);
                if ((i + j) % 2 == 0) {
                    cells[i][j].setStyle("-fx-background-color: BURLYWOOD; -fx-border-color: TAN");
                } else {
                    cells[i][j].setStyle("-fx-background-color: BLANCHEDALMOND; -fx-border-color: TAN");
                }
                cells[i][j].prefHeightProperty().bind(Bindings.divide(primaryStage.widthProperty(), 10.0));
                cells[i][j].prefWidthProperty().bind(Bindings.divide(primaryStage.widthProperty(), 10.0));
            }
            board.setAlignment(Pos.CENTER);
        }

        Scene scene = new Scene(board, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}

