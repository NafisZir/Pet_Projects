package sample;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    // Переменные, чтобы знать, что выбрал пользователь: доллар или рубль
    private byte rubFlag = 0;
    private byte usdFlag = 0;
    // Число, которое ввёл пользователь
    private float value;
    // значение валюты из класса Parser
    private float usd;
    private float rub;
    // Результат. Уже конвертированное значение валюты
    private float result;

    @FXML
    private TextField textField;

    @FXML
    private Label labelDialog;

    // Метод обработки кнопки "RUB"
    @FXML
    public void funcRUB(){
        labelDialog.setText("Вы выбрали Рубль. Наберите число\n и нажмите 'Конвертировать'");
        rubFlag = 1;
        usdFlag = 0;
        // Очищаем поле ввода от предыдущего ввода
        textField.setText("");
    }

    // Метод обработки кнопки "USD"
    @FXML
    public void funcUSD(){
        labelDialog.setText("Вы выбрали Доллар. Наберите число\n и нажмите 'Конвертировать'");
        usdFlag = 1;
        rubFlag = 0;
        textField.setText("");
    }

    // Метод обработки кнопки "Конвертирвать"
    @FXML
    public void funcConvert() throws IOException {
        // Получаем строку из поля
        String text = textField.getText();
        if(text.equals("")) {
            labelDialog.setText("Наберите число!");
        }
        else {
            // Переменная для того, чтобы при некорректном вводе не сработала функция calculation
            byte key = 0;
            try{
                value = Float.parseFloat(text);
            } catch (Exception e){
                labelDialog.setText("Некорректный ввод!");
                key = 1;
            }

            if (key == 0) result = calculation(value);

            String currencyName = " долларов.";
            if(rubFlag == 0) currencyName = " рублей.";
            if(result != 0)  labelDialog.setText("Результат " + result + currencyName);
        }
    }

    // Метод конвертирует валюту
    public float calculation(float value) throws IOException {
        Parser price = new Parser();
        if(usdFlag == 1){
            usd = price.getUsdPrice();
            return usd*value;
        }
        if (rubFlag == 1){
            rub = price.getRubPrice();
            return rub*value;
        }
        else{
            labelDialog.setText("Выберите валюту!");
            return 0;
        }
    }
}