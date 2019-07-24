package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import java.awt.*;
import java.util.LinkedList;


public class Grid {

    private Color color;
    private MapKeyboardHandler mapKeyboardHandler;
    private LinkedList<Cell> linkedList;
    private LinkedList<Color> cellColor;
    private CellHandler cellHandler;
    private final int MIN_VALUE = 1;
    private Rectangle rectangle;
    private final int ZERO = 0;
    private Cell[][] cells;
    private Cursor cursor;
    private Keyboard k;
    private int col;
    private int row;

    public Grid(int col, int row) {

        this.col = col;
        this.row = row;
        this.cursor = new Cursor(this);
        this.cells = new Cell[col][row];
        this.mapKeyboardHandler = new MapKeyboardHandler(cursor);
        this.k = new Keyboard(mapKeyboardHandler);
        this.rectangle = new Rectangle(col, row);
        this.cellHandler = new CellHandler(cells);
        this.linkedList = new LinkedList<>();
        this.cellColor = new LinkedList<>();
        this.color = Color.RED;
        setKeyboard();
    }

    public void init() {

        cursor.getRectangle().setColor(Color.BLACK);
        cursor.getRectangle().draw();

        for (int i = ZERO; i < col; i++) {

            for (int j = ZERO; j < row; j++) {

                cells[i][j] = new Cell(i + 1, j);
                cellHandler.setCell(i, j, Color.WHITE, Color.ORANGE, false);
            }
        }
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    private void addKeyboardEvent(Keyboard k, int key, KeyboardEventType keyPressed) {

        KeyboardEvent e = new KeyboardEvent();
        e.setKey(key);
        e.setKeyboardEventType(keyPressed);
        k.addEventListener(e);
    }

    public void setKeyboard(){

        addKeyboardEvent(k, KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(k, KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(k, KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(k, KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(k, KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(k, KeyboardEvent.KEY_C, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(k, KeyboardEvent.KEY_D, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(k, KeyboardEvent.KEY_S, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(k, KeyboardEvent.KEY_L, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(k, KeyboardEvent.KEY_1, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(k, KeyboardEvent.KEY_2, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(k, KeyboardEvent.KEY_3, KeyboardEventType.KEY_PRESSED);
    }

    public void paintCell() {

        cellHandler.setPaintedCell(cursor.getCol() - MIN_VALUE, cursor.getRow(), color, true);
    }

    public void cleanCell() {

        cellHandler.setCell(cursor.getCol() - MIN_VALUE, cursor.getRow(), Color.WHITE, Color.ORANGE, false);
    }

    public void cleanAllCells() {

        for (int i = ZERO; i < col; i++) {

            for (int j = ZERO; j < row; j++) {

                if (cells[i][j].isPainted()) {

                    cellHandler.setCell(i, j, Color.WHITE, Color.ORANGE, false);
                    System.out.println("cell limpa\n");
                }
            }
        }
    }

    public void saveCells() {

        while(!linkedList.isEmpty()){

            linkedList.pop();
            cellColor.pop();
        }

        for (int i = ZERO; i < col; i++) {

            for (int j = ZERO; j < row; j++) {

                if (cells[i][j].isPainted() == true) {

                    linkedList.add(cells[i][j]);
                    cellColor.add(cells[i][j].getCellColor());
                    System.out.println("GRAVADO\n");
                }
            }
        }
    }

    public void loadCells () {

        cleanAllCells();

        for (int i = ZERO; i < linkedList.size(); i++) {

            linkedList.get(i).getRectangle().setColor(cellColor.get(i));
            linkedList.get(i).getRectangle().fill();
            linkedList.get(i).setPainted(true);
        }

        System.out.printf("TELA CARREGADA\n");
    }

    public void setColor (Color color){

        this.color = color;
    }
}