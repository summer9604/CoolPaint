package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class RectangleHandler {

    private Rectangle rectangle;

    public RectangleHandler(Rectangle rectangle){

        this.rectangle = rectangle;
    }

    public void setRectangle(int x, int y, Color color){

        rectangle.translate(x, y);
        rectangle.setColor(color);
        rectangle.draw();
        rectangle.fill();
    }
}