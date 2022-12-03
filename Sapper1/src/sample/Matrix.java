/* Класс создает матрицу нужной размеренности,
   рандомно заполняет его бомбами
   и расставляет числа вокруг них
 */

package sample;

import java.util.Random;

public class Matrix {
    private static final int QUANTITY_SQUARE = 10;  // Количество квадратов в линию
    private static final int QUANTITY_BOMB = 10;    // Количестов бомб
    private static final int BOMB = -1;             // Код бомбы в матрице
    private int[][] matrix;

    public Matrix(){
        matrix = new int[QUANTITY_SQUARE][QUANTITY_SQUARE];
        fillMatrix();
    }

    // Размещаем мины рандомным образом
    private void fillMatrix() {
        for (int i = 0; i < QUANTITY_BOMB; i++) {            // Размещаем мины рандомным образом
            Random random = new Random();
            int line = random.nextInt(QUANTITY_SQUARE);
            int column = random.nextInt(QUANTITY_SQUARE);
            matrix[line][column] = BOMB;

            // Расставляем вокруг мины числа
            for (int j = -1; j < 2; j++) {
                // Условие: если мина на краю поля, то индексы массива не должны выходить за диапазон массива
                if (((line - 1) >= 0) && (((column + j) >= 0) && ((column + j) < QUANTITY_SQUARE))) {
                    // Условие: мы не должны увеличивать число квадрата, на котором мина
                    if (matrix[line - 1][column + j] != BOMB) {
                        matrix[line - 1][column + j] += 1;
                    }
                }
                // Те же условия
                if (((line + 1) < 10) && (((column + j) >= 0) && ((column + j) < QUANTITY_SQUARE))){
                    if (matrix[line + 1][column + j] != BOMB) {
                        matrix[line + 1][column + j] += 1;
                    }
                }
            }

            // Тоже расставляем числа, только на строке, в котором мина. Условия те же.
            for (int j = -1; j < 2; j += 2) {
                if( ( (column + j) >= 0 ) && ( (column + j) < QUANTITY_SQUARE) ) {
                    if (matrix[line][column + j] != BOMB) {
                        matrix[line][column + j] += 1;
                    }
                }
            }
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
