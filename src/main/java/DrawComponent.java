import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class DrawComponent extends JComponent implements Drawable {


    int xStart,yStart,xEnd,yEnd;
    Color color = Color.MAGENTA;
    String shape = "";

    public DrawComponent(String shape,int xStart, int yStart, int xEnd, int yEnd) {
        this.shape = shape;
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    public DrawComponent(String shape,int xStart, int yStart, int xEnd, int yEnd, Color color) {
        this.shape = shape;
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        this.color = color;
    }


    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        switch (shape) {
            case "circle":
                g.drawOval(xStart,yStart,xEnd-xStart,yEnd-yStart);
                break;
            case "rectangle":
                g.drawRect(xStart,yStart,xEnd-xStart,yEnd-yStart);
                break;
            case "line":
                g.drawLine(xStart,yStart,xEnd,yEnd);
                break;
        }
    }



    public boolean componentEquals(DrawComponent drawComponent) {
        if(drawComponent.color.equals(this.color)
                && drawComponent.xStart == this.xStart
                && drawComponent.yStart == this.yStart
                && this.xEnd == this.xEnd
                && this.yEnd == this.yEnd
                && this.shape.equals(drawComponent.shape)
        ) {
            return true;
        }else {
            return false;
        }
    }
}
