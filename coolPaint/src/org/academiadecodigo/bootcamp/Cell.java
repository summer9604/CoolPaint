package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    private int col;
    private int row;
    private final int CELL_SIZE = 40;
    private boolean painted;
    private Rectangle rectangle;
    private Color cellColor = Color.WHITE;

    public Cell(int col, int row){

        this.col = col;
        this.row = row;
        this.rectangle = new Rectangle(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        this.painted = false;
    }

    public Rectangle getRectangle(){

        return rectangle;
    }

    public boolean isPainted() {

        return painted;
    }

    public void setPainted(boolean painted) {

        this.painted = painted;
    }

    public void setCellColor(Color cellColor) {

        this.cellColor = cellColor;
    }

    public Color getCellColor() {

        return cellColor;
    }
}