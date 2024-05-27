package hust.soict.dsai.javafx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    @FXML
    private RadioButton penRadioButton;
    @FXML
    private RadioButton eraserRadioButton;
    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Color color = Color.WHITE;
        int size = 0;
        if (penRadioButton.isSelected()) {
            color = Color.BLACK;
            size = 4;
        }
        else if (eraserRadioButton.isSelected()) {
            color = Color.WHITE;
            size = 8;
        }

        Circle newCircle = new Circle(event.getX(), event.getY(), size, color);
        drawingAreaPane.getChildren().add(newCircle);
    }

}

