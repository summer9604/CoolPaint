package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cursor {

    private int col;
    private int row;
    private final int CELL_SIZE = 40;
    private Rectangle rectangle;
    private Cell cell;
    private Grid grid;
    private RectangleHandler rectangleHandler;
    private final int MIN_VALUE = 1;
    private final int ZERO = 0;

    public Cursor(Grid grid){

        this.grid = grid;
        this.col = (int)(Math.random() * (grid.getCol() - ZERO) + MIN_VALUE) + ZERO;
        this.row = 0;
        this.rectangle = new Rectangle( col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        this.rectangleHandler = new RectangleHandler(rectangle);
        this.cell = new Cell(col, row);
    }

    public int getCol(){

        return col;
    }

    public int getRow(){

        return row;
    }

    public Rectangle getRectangle(){

        return rectangle;
    }

    public void moveUp(){

        if(row > ZERO) {

            rectangleHandler.setRectangle(ZERO, -MIN_VALUE * CELL_SIZE, Color.GREEN);
            row--;
            System.out.println(" Col: " + getCol() + "    Row: " + getRow());
            System.out.println("cima\n");
            return;
        }

        rectangleHandler.setRectangle(ZERO, (grid.getRow() - MIN_VALUE) * CELL_SIZE, Color.GREEN);
        row += (grid.getRow() - MIN_VALUE);
        System.out.println(" Col: " + getCol() + "    Row: " + getRow());
        System.out.println("cima\n");
    }

    public void moveLeft() {

        if (col > MIN_VALUE) {

            rectangleHandler.setRectangle(-MIN_VALUE * CELL_SIZE, ZERO, Color.RED);
            col--;
            System.out.println(" Col: " + getCol() + "    Row: " + getRow());
            System.out.println("esquerda\n");
            return;
        }

        rectangleHandler.setRectangle((grid.getCol() - MIN_VALUE) * CELL_SIZE, ZERO, Color.GREEN);
        col += (grid.getCol() - MIN_VALUE);
        System.out.println(" Col: " + getCol() + "    Row: " + getRow());
        System.out.println("cima\n");
    }

    public void moveRight() {

        if (col < grid.getCol()) {

            rectangleHandler.setRectangle(MIN_VALUE * CELL_SIZE, ZERO, Color.ORANGE);
            col += MIN_VALUE;
            System.out.println(" Col: " + getCol() + "    Row: " + getRow());
            System.out.println("direita\n");
            return;
        }

        rectangleHandler.setRectangle((-grid.getCol() + MIN_VALUE)* CELL_SIZE, ZERO, Color.GREEN);
        col -= (grid.getCol() - MIN_VALUE);
        System.out.println(" Col: " + getCol() + "    Row: " + getRow());
        System.out.println("cima\n");
    }

    public void moveDown() {

        if (row < (grid.getRow() - MIN_VALUE)) {

            rectangleHandler.setRectangle(ZERO, MIN_VALUE * CELL_SIZE, Color.BLUE);
            row++;
            System.out.println(" Col: " + getCol() + "    Row: " + getRow());
            System.out.println("baixo\n");
            return;
        }

        rectangleHandler.setRectangle(ZERO, (-grid.getRow() + MIN_VALUE) * CELL_SIZE, Color.GREEN);
        row -= (grid.getRow() - MIN_VALUE);
        System.out.println(" Col: " + getCol() + "    Row: " + getRow());
        System.out.println("cima\n");
    }

    public void paint(){

        grid.paintCell();
        System.out.println("pintando cell\n");
    }

    public void cleanCell(){

        grid.cleanCell();
        System.out.println("limpa cell\n");
    }

    public void cleanAllCells(){

        grid.cleanAllCells();
        System.out.println("limpa todas as cells\n");
    }

    public void saveCells(){

        grid.saveCells();
        System.out.printf("Guarda cells pintadas\n");
    }

    public void loadCells(){

        grid.loadCells();
        System.out.printf("Carrega cells guardadas\n");
    }

    public void setColorToRed(){

        grid.setColor(Color.RED);
        System.out.println("Cor vermelha\n");
    }

    public void setColorToGreen(){

        grid.setColor(Color.GREEN);
        System.out.println("Cor verde\n");
    }

    public void setColorToBlue(){

        grid.setColor(Color.BLUE);
        System.out.println("Cor azul\n");
    }
}