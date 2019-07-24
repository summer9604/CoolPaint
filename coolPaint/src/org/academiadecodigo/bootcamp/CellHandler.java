package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class CellHandler {

    private Cell[][] cells;

    public CellHandler(Cell[][] cells){

        this.cells = cells;
    }

    public void setCell(int col, int row, Color color, Color border, boolean painted) {

        cells[col][row].getRectangle().setColor(color);
        cells[col][row].getRectangle().fill();
        cells[col][row].getRectangle().setColor(border);
        cells[col][row].getRectangle().draw();
        cells[col][row].setPainted(painted);
    }

    public void setPaintedCell(int col, int row, Color color, boolean painted){

        cells[col][row].getRectangle().setColor(color);
        cells[col][row].getRectangle().fill();
        cells[col][row].setPainted(painted);
        cells[col][row].setCellColor(color);
    }
}