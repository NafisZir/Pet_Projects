package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static javafx.scene.paint.Color.BLACK;

public class Square {
    public static final Color STROKE_COLOR = BLACK;  // Цвет границы квадрата
    private int x, y, size;
    Color color;

    public Square(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void paint(GraphicsContext gc, Color color){    // рисование квадрата
        gc.setFill(color);
        gc.fillRect(x, y, size, size);
        gc.setStroke(STROKE_COLOR);
        gc.strokeRect(x, y, size, size);
        this.color = color;
    }

    public void paintWithNumber(GraphicsContext gc, Color color, String str){  // Рисование квадрата с числом внутри
        paint(gc, color);
        gc.setFill(BLACK);
        gc.fillText(str, (x + 10), (y + 15));
    }
}
