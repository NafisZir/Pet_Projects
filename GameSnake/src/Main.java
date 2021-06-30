/**
 * Classic game Snake from webinar in group of VK "Java"
 * written on 21.12.2020
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Main {
    public final String TITLE_OF_PROGRAM = "Snake";
    public final String GAME_OVER_MSG = "Game over";
    public final int POINT_RADIUS = 20; // in pxl
    public final int FIELD_WIDTH = 30;   // in point
    public final int FIELD_HEIGHT = 20;
    public final int FIELD_DX = 6;
    public final int FIELD_DY = 23;
    public final int START_LOCATION = 200;
    public final int START_SNAKE_SIZE = 6;
    public final int START_SNAKE_X = 10; // in point
    public final int START_SNAKE_Y = 10;
    public final int LEFT = 37;
    public final int UP = 38;
    public final int RIGHT = 39;
    public final int DOWN = 40;
    public final int START_DIRECTION = RIGHT;
    public final Color SNAKE_DEFAULT_COLOR = Color.magenta;
    public final Color SNAKE_HEAD_COLOR = Color.blue;
    public final Color FOOD_COLOR = Color.RED;

    public int showDelay = 100;

    Snake snake;
    Food food;
    JFrame frame;
    Canvas canvasPanel;
    Random random = new Random();
    boolean gameOver = false;

    public static void main(String[] args) {
        new Main().go();
    }

    public void go(){
        frame = new JFrame(TITLE_OF_PROGRAM + " : " + START_SNAKE_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FIELD_WIDTH*POINT_RADIUS+FIELD_DX, FIELD_HEIGHT*POINT_RADIUS+FIELD_DY);
        frame.setLocation(START_LOCATION, START_LOCATION);
        frame.setResizable(false);

        canvasPanel = new Canvas();
        canvasPanel.setBackground(Color.green);
        frame.getContentPane().add(BorderLayout.CENTER, canvasPanel);
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                snake.setDirection(e.getKeyCode());
            }
        });

        frame.setVisible(true);

        snake = new Snake(START_SNAKE_X, START_SNAKE_Y, START_SNAKE_SIZE, START_DIRECTION);
        food = new Food();

        while(!gameOver){
            snake.move();
            if(food.isEaten()){
                food.next();
            }
            canvasPanel.repaint();
            try{
                Thread.sleep(showDelay);
            } catch (InterruptedException e) { e.printStackTrace();}
        }
    }

    public class Snake{
        ArrayList<Point> snake = new ArrayList<>();
        ArrayList<Integer> dir = new ArrayList<>();
        int direction;

        public Snake(int x, int y, int length, int direction){
            for (int i = 0; i < length; i++) {
                Point point = new Point(x - i, y);
                snake.add(point);
            }
            this.direction = direction;
            dir.add(direction);
        }

        public void setDirection(int direction){
            if((direction >= LEFT) && (direction <= DOWN)){
                if (Math.abs(this.direction - direction) != 2) {
                    dir.add(direction);
                }
            }
        }

        public boolean isInsideSnake(int x, int y){
            for(Point point : snake){
                if((point.getX() == x) && (point.getY() == y)) { return true; }
            }
            return false;
        }

        public void paint(Graphics g){
            for(Point point : snake){
                point.paint(g);
            }
        }

        public boolean isFood(Point food){
            return (((snake.get(0).getX()) == food.getX()) && (snake.get(0).getY() == food.getY()));
        }

        public void move(){
            int x = snake.get(0).getX();
            int y = snake.get(0).getY();

            if(dir.size() >= 2){                // Условие, чтобы direction не менялся во время задержки
                this.direction = dir.get(1);
                dir.remove(0);
            }

            if(direction == LEFT) {x--;}        // В зависимости от нажатой кнопки менем координату
            else if(direction == RIGHT) {x++;}
            else if(direction == UP) {y--;}
            else if(direction == DOWN) {y++;}

            if(x > FIELD_WIDTH - 1) { x = 0; }  // Если голова змеи на границе окна, она должна продолжать путь в противоположной стороне
            else if(x < 0) { x = FIELD_WIDTH; }
            else if(y > FIELD_HEIGHT - 1) { y = 0; }
            else if(y < 0) { y = FIELD_HEIGHT; }

            gameOver = isInsideSnake(x, y);      // check for across
            snake.add(0, new Point(x,y));
            snake.get(0).setColor(SNAKE_HEAD_COLOR);
            snake.get(1).setColor(SNAKE_DEFAULT_COLOR);

            if(isFood(food)) {                   // Если координата головы и еды совпала
                food.eat();
                frame.setTitle(TITLE_OF_PROGRAM + " : " + snake.size());
                if((snake.size() % 2) == 0) { showDelay -= 5; }
            }
            else{
                snake.remove(snake.size() - 1);  // Удалаяем хвост (получается движение)
            }
        }
    }

    class Food extends Point{
        public Food(){
            super(-1,-1);
            this.color = FOOD_COLOR;
        }

        public void eat(){
            this.setXY(-1,-1);
        }

        boolean isEaten(){
            return this.getX() == -1;
        }

        public void next(){
            int x, y;
            do{
                x = random.nextInt(FIELD_WIDTH);
                y = random.nextInt(FIELD_HEIGHT);
            } while(snake.isInsideSnake(x, y));
            this.setXY(x, y);
        }
    }

    public class Point {
        int x, y;
        Color color = SNAKE_DEFAULT_COLOR;

        public Point(int x, int y){
            this.setXY(x,y);
        }

        public void setXY(int x, int y){
            this.x = x;
            this.y = y;
        }

        public void setColor(Color color){ this.color = color; }

        public int getX(){ return this.x; }
        public int getY(){ return this.y; }

        public void paint(Graphics g){
            g.setColor(color);
            g.fillOval(x*POINT_RADIUS, y*POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
        }
    }

    public class Canvas extends JPanel{
        @Override
        public void paint(Graphics g){
            super.paint(g);
            snake.paint(g);
            food.paint(g);
            if (gameOver) {
                g.setColor(Color.red);
                g.setFont(new Font("Arial", Font.BOLD, 40));
                FontMetrics fm = g.getFontMetrics();
                g.drawString(GAME_OVER_MSG, (FIELD_WIDTH * POINT_RADIUS + FIELD_DX - fm.stringWidth(GAME_OVER_MSG))/2, (FIELD_HEIGHT * POINT_RADIUS + FIELD_DY)/2);
            }
        }
    }
}
