package com.example.colorchooser;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.Property;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.converter.NumberStringConverter;

public class HelloController {
    @FXML
    private Slider redSlider;
    @FXML
    private Slider greenSlider;
    @FXML
    private Slider blueSlider;
    @FXML
    private Slider alphaSlider;
    @FXML
    private TextField redAmount;
    @FXML
    private TextField greenAmount;
    @FXML
    private TextField blueAmount;
    @FXML
    private TextField alphaAmount;
    @FXML
    private Rectangle rectangle;

    private int redValue=0;
    private int greenValue=0;
    private int blueValue=0;
    private double alphaValue=0.0;

    public void initialize(){
        redAmount.textProperty().bind(redSlider.valueProperty().asString("%.0f"));
        greenAmount.textProperty().bind(greenSlider.valueProperty().asString("%.0f"));
        blueAmount.textProperty().bind(blueSlider.valueProperty().asString("%.0f"));
        alphaAmount.textProperty().bind(alphaSlider.valueProperty().asString("%.2f"));
        redSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                        redValue=newValue.intValue();
                        rectangle.setFill(Color.rgb(redValue,greenValue,blueValue,alphaValue));
                    }
                }
        );
        greenSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                        greenValue=newValue.intValue();
                        rectangle.setFill(Color.rgb(redValue,greenValue,blueValue,alphaValue));
                    }
                }
        );
        blueSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                        blueValue=newValue.intValue();
                        rectangle.setFill(Color.rgb(redValue,greenValue,blueValue,alphaValue));
                    }
                }
        );
        alphaSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                        alphaValue=newValue.doubleValue();
                        rectangle.setFill(Color.rgb(redValue,greenValue,blueValue,alphaValue));
                    }
                }
        );
    }

}