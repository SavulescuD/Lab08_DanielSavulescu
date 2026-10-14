package lab08_danielsavulescu.lab08_danielsavulescu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author 2540408 - Daniel Savulescu
 * 
 * GitHub repository: https://github.com/SavulescuD/Lab08_DanielSavulescu.git
 */
public class PainterController implements Initializable {

    @FXML
    private RadioButton blackPaint;
    @FXML
    private ToggleGroup colorToggleGroup;
    @FXML
    private RadioButton redPaint;
    @FXML
    private RadioButton greenPaint;
    @FXML
    private RadioButton bluePaint;
    @FXML
    private RadioButton smallSize;
    @FXML
    private ToggleGroup sizeToggleGroup;
    @FXML
    private RadioButton mediumSize;
    @FXML
    private RadioButton largeSize;
    @FXML
    private Button undoButton;
    @FXML
    private Button clearButton;
    @FXML
    private Pane drawingAreaPane;
    
    private PenSize radius = PenSize.MEDIUM;
    private Paint brushColor = Color.BLACK;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        blackPaint.setUserData(Color.BLACK);
        redPaint.setUserData(Color.RED);
        greenPaint.setUserData(Color.GREEN);
        bluePaint.setUserData(Color.BLUE);
        smallSize.setUserData(PenSize.SMALL);
        mediumSize.setUserData(PenSize.MEDIUM);
        largeSize.setUserData(PenSize.LARGE);
        
    }    
    
    /**
     * handles when a color radio button is selected
     * @param event the event when a color radio button is pressed
     */
    @FXML
    private void colorRadioButtonSelected(ActionEvent event) {
        brushColor = (Color) colorToggleGroup.getSelectedToggle().getUserData();
    }
    
    /**
     * handles when a size radio button is selected
     * @param event the event when a size radio button is pressed
     */
    @FXML
    private void sizeRadioButtonSelected(ActionEvent event) {
        radius = (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
    }
    
    /**
     * undoes the last action
     * @param event the event when the undo button is pressed
     */
    @FXML
    private void undoButtonPressed(ActionEvent event) {
        int num = drawingAreaPane.getChildren().size();
        
        if (num > 0) {
            drawingAreaPane.getChildren().remove(num - 1);
        }
    }
    
    /**
     * clears the whole drawing area
     * @param event the event when the clear button is pressed
     */
    @FXML
    private void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }
    
    /**
     * draws on the pane when the mouse is dragged
     * @param event the event when the mouse is dragged
     */
    @FXML
    private void drawingAreaMouseDragged(MouseEvent event) {
        Circle circle = new Circle(event.getX(), event.getY(), radius.getRadius(), brushColor);
        drawingAreaPane.getChildren().add(circle);
    }

    
    private enum PenSize {
        SMALL(2),
        MEDIUM(4),
        LARGE(6);
        
        private final int radius;
        
        PenSize(int radius) {this.radius = radius;}
        
        public int getRadius() {return radius;}
    };
}
