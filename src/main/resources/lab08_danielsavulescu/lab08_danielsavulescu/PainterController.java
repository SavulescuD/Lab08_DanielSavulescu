/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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

/**
 * FXML Controller class
 *
 * @author 2540408 - Daniel Savulescu
 * 
 * GitHub repository: https://github.com/SavulescuD/Lab08_DanielSavulescu.git
 */
public abstract class PainterController implements Initializable {

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
    
    public void initialize() {
        blackPaint.setUserData(Color.BLACK);
        redPaint.setUserData(Color.RED);
        greenPaint.setUserData(Color.GREEN);
        bluePaint.setUserData(Color.BLUE);
        smallSize.setUserData(PenSize.SMALL);
        mediumSize.setUserData(PenSize.MEDIUM);
        largeSize.setUserData(PenSize.LARGE);
        
    }    

    @FXML
    private void colorRadioButtonSelected(ActionEvent event) {
    }

    @FXML
    private void sizeRadioButtonSelected(ActionEvent event) {
    }

    @FXML
    private void undoButtonPressed(ActionEvent event) {
    }

    @FXML
    private void clearButtonPressed(ActionEvent event) {
    }

    @FXML
    private void drawingAreaMouseDragged(MouseEvent event) {
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
