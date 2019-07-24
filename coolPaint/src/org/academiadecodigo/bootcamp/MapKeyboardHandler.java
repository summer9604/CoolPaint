package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MapKeyboardHandler implements KeyboardHandler {

    private Cursor cursor;

    public MapKeyboardHandler(Cursor cursor){

        this.cursor = cursor;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        int key = keyboardEvent.getKey();

        switch (key){

            case KeyboardEvent.KEY_DOWN:

                cursor.moveDown();
                break;

            case KeyboardEvent.KEY_UP:

                cursor.moveUp();
                break;

            case KeyboardEvent.KEY_LEFT:

                cursor.moveLeft();
                break;

            case KeyboardEvent.KEY_RIGHT:

                cursor.moveRight();
                break;

            case KeyboardEvent.KEY_SPACE:

                cursor.paint();
                break;

            case KeyboardEvent.KEY_C:

                cursor.cleanCell();
                break;

            case KeyboardEvent.KEY_D:

                cursor.cleanAllCells();
                break;

            case KeyboardEvent.KEY_S:

                cursor.saveCells();
                break;

            case KeyboardEvent.KEY_L:

                cursor.loadCells();
                break;

            case KeyboardEvent.KEY_1:

                cursor.setColorToBlue();
                break;

            case KeyboardEvent.KEY_2:

                cursor.setColorToRed();
                break;

            case KeyboardEvent.KEY_3:

                cursor.setColorToGreen();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}