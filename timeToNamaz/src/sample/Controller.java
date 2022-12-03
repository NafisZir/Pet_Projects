package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class Controller {
    @FXML
    private Button timeButton;

    @FXML
    private Label labelFajr;

    @FXML
    private Label labelEndFajr;

    @FXML
    private Label labelZuhr;

    @FXML
    private Label labelAsr;

    @FXML
    private Label labelAsrKhanafi;

    @FXML
    private Label labelMagrib;

    @FXML
    private Label labelIsha;

    @FXML
    private Label labelMidnight;

    @FXML
    private Label labelThirdPartNight;

    public void setTime() throws IOException {
        Parser time = new Parser();
        labelFajr.setText(time.getTimeFajr());
        labelEndFajr.setText(time.getTimeEndFajr());
        labelZuhr.setText(time.getTimeZuhr());
        labelAsr.setText(time.getTimeAsr());
        labelAsrKhanafi.setText(time.getTimeAsrKhanafi());
        labelMagrib.setText(time.getTimeMagrib());
        labelIsha.setText(time.getTimeIsha());
        labelMidnight.setText(time.getTimeMidNight());
        labelThirdPartNight.setText(time.getTimeThirdPartNight());
    }

}
