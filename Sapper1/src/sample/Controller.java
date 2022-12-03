package sample;

import javafx.scene.canvas.GraphicsContext;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

import static javafx.scene.paint.Color.*;

public class Controller {
    public static final int QUANTITY_SQUARE = 10;  // Количество квадратов в линию
    public static final int SIZE_SQUARE = 25;      // Сторона квадрата
    public static final int SIZE_FIELD = QUANTITY_SQUARE*SIZE_SQUARE; // Размер стороны поля
    public static final int QUANTITY_BOMB = 10;    // Количестов бомб
    public static final int BOMB = -1;             // Код бомбы в матрице
    public static final int OPEN_SQUARE = -2;      // Код открытого квадрата в матрице
    public static final Color DEFAULT_SQUARE_COLOR = BLUE; // Цвет всех квадратов в начале игры
    public static final Color OPEN_SQUARE_COLOR = GRAY;    // Цвет открытого квадрата
    public static final Color BOMB_SQUARE_COLOR = RED;     // Цвет бомбы
    public static final Color FLAG_COLOR = YELLOW;     // Цвет флажка

    @FXML
    private Canvas c;

    @FXML
    private Button buttonStart;

    @FXML
    private Button buttonRestart;

    @FXML
    private Label dialog;

    Square square;
    Square[][] arrSquare = new Square[QUANTITY_SQUARE][QUANTITY_SQUARE];  // массив квадратов
    int[][] matrix;
    int quantityRightFlag;
    int f;

    public void start(){
        buttonStart.setDisable(true);
        GraphicsContext gc = c.getGraphicsContext2D();
        quantityRightFlag = 0;
        f = 0;
        dialog.setText("");

        Matrix m = new Matrix();
        matrix = m.getMatrix();

        for (int i = 0, line = 0; i < SIZE_FIELD; i += SIZE_SQUARE, line++) {       // Заполнение поля квадратами и массива - объектами
            for (int j = 0, column = 0; j < SIZE_FIELD; j += SIZE_SQUARE, column++) {
                square = new Square(j, i, SIZE_SQUARE);
                arrSquare[line][column] = square;
                square.paint(gc, DEFAULT_SQUARE_COLOR);
            }
        }

        outputMatrix();
    }

    public void outputMatrix(){
        for (int[] x: matrix){
            for( int y: x){
                System.out.print(y + "  ");
            }
            System.out.println();
        }
    }

    public void mouseEventRight(int x, int y){
        if(f == 0) {
            int column = (x / SIZE_SQUARE);
            int line = (y / SIZE_SQUARE);

            GraphicsContext gc = c.getGraphicsContext2D();

            if (arrSquare[line][column].getColor() == BLUE) {
                arrSquare[line][column].paint(gc, FLAG_COLOR);

                if (matrix[line][column] == BOMB) {
                    quantityRightFlag += 1;
                }
                if (quantityRightFlag == QUANTITY_BOMB) {
                    inputVictory();
                }
            } else {
                arrSquare[line][column].paint(gc, DEFAULT_SQUARE_COLOR);
            }
        }
    }

    public void mouseEventLeft(int x, int y){                // При нажатии левой кнопки мыши определяем квадрат и открываем его
        if(f == 0) {
            int column = (x / SIZE_SQUARE);
            int line = (y / SIZE_SQUARE);

            if (matrix[line][column] == BOMB) {
                openSquareWithBomb();
            }
            if (matrix[line][column] == 0) {
                openEmptySquare(line, column);
            }
            if (matrix[line][column] > 0) {
                openSquareWithNumber(line, column);
            }
        }
    }


    public void openSquareWithBomb(){           // Функция открывает все бомбы, если нажали на одну из них
        GraphicsContext gc = c.getGraphicsContext2D();

        for (int i = 0; i < QUANTITY_SQUARE; i++) {
            for (int j = 0; j < QUANTITY_SQUARE; j++) {
                if(matrix[i][j] == BOMB){
                    arrSquare[i][j].paint(gc, BOMB_SQUARE_COLOR);
                }
            }
        }

        inputLosing();
    }


    public void openSquareWithNumber(int line, int column){   // Функция открывает квадрат с номером
        GraphicsContext gc = c.getGraphicsContext2D();

        String str = Integer.toString(matrix[line][column]);
        arrSquare[line][column].paintWithNumber(gc, OPEN_SQUARE_COLOR, str);
    }


    public void openEmptySquare(int line, int column){         // Функция,которая открывает все соседние пустые клетки, включая первые встретившие цифры
        GraphicsContext gc = c.getGraphicsContext2D();
        ArrayList<Integer> list = new ArrayList<>();           // Будем хранить координаты следующих соседних пустых клеток

        arrSquare[line][column].paint(gc, OPEN_SQUARE_COLOR);
        list.add(line);
        list.add(column);
        matrix[line][column] = OPEN_SQUARE;

        int l, c;    // строка и столбец
        boolean b = true;

        while(b){
            l = list.get(0);
            c = list.get(1);

            // Циклы, которые и открывают нужные квадраты ( горизонтальные )
            for (int i = -1; i < 2; i += 2) {
                if(((c + i) >= 0) && (c + i) < QUANTITY_SQUARE) {   // Условие: проверяемый квадрат должен быть внутри поля (массива)
                    if (matrix[l][c + i] == 0) {
                        arrSquare[l][c + i].paint(gc, OPEN_SQUARE_COLOR);
                        matrix[l][c + i] = OPEN_SQUARE;
                        list.add(l);
                        list.add(c + i);
                    } else if (matrix[l][c + i] > 0) {
                        openSquareWithNumber(l, c + i);
                    }
                }
            }

            // (вертикальные)
            for (int i = -1; i < 2; i += 2) {
                if(((l + i) >= 0) && (l + i) < QUANTITY_SQUARE) {
                    if (matrix[l + i][c] == 0) {
                        arrSquare[l + i][c].paint(gc, OPEN_SQUARE_COLOR);
                        matrix[l + i][c] = OPEN_SQUARE;
                        list.add(l + i);
                        list.add(c);
                    } else if (matrix[l + i][c] > 0) {
                        openSquareWithNumber(l + i, c);
                    }
                }
            }

            // Удаляем просмотренный квадрат
            list.remove(0);
            list.remove(0);

            if(list.size() == 0) { b = false; }
        }
    }

    public void inputVictory(){
        dialog.setText("Вы победили!");
        f = 1;
    }

    public void inputLosing(){
        dialog.setText("Вы проиграли!");
        f = 1;
    }
}
