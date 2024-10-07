import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawComponent extends JComponent implements Drawable, MouseListener, MouseMotionListener {


    int xStart,yStart,xEnd,yEnd;
    Color color = Color.MAGENTA;
    String shape = "";
    Rectangle bounds = new Rectangle();

    boolean isInside = false;
    boolean isDragging = false;

    MyPanel myPanel;

    int offsetX, offsetY, offsetXEnd, offsetYEnd;


    public DrawComponent(String shape,int xStart, int yStart, int xEnd, int yEnd,MyPanel myPanel) {
        this.shape = shape;
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        bounds = new Rectangle(xStart, yStart, xEnd - xStart, yEnd - yStart);
        this.myPanel = myPanel;
        addMouseListener(this);
        addMouseMotionListener(this);
        System.out.println(bounds);
        System.out.println("xStart: " + xStart + " yStart: " + yStart + " xEnd: " + xEnd + " yEnd: " + yEnd);
    }

    public DrawComponent(String shape,int xStart, int yStart, int xEnd, int yEnd, Color color,MyPanel myPanel) {
        this.shape = shape;
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        bounds = new Rectangle(xStart, yStart, xEnd - xStart, yEnd - yStart);
        this.color = color;
        addMouseListener(this);
        addMouseMotionListener(this);
        this.myPanel = myPanel;
    }

    private boolean checkParameters(){
        return false;
    }

    private void revertParameters(){
        if(xStart > xEnd && yStart > yEnd){

        }
        if(xStart > xEnd){
            int tmp = xStart;
            xStart = xEnd;
            xEnd = tmp;
        }
        if(yStart > yEnd){
            int tmp = yStart;
            yStart = yEnd;
            yEnd = tmp;
        }


    }


    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
        g.setColor(color);
        revertParameters();
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
        return drawComponent.color.equals(this.color)
                && drawComponent.xStart == this.xStart
                && drawComponent.yStart == this.yStart
                && drawComponent.xEnd == this.xEnd
                && drawComponent.yEnd == this.yEnd
                && this.shape.equals(drawComponent.shape);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mousePressed");
        if(isInside(e.getPoint()) && SwingUtilities.isMiddleMouseButton(e)){
            System.out.println("Inside isInside");
            isDragging = true;
            offsetX = e.getX() - xEnd;
            offsetY = e.getY() - yEnd;
        }
        if(isInside(e.getPoint()) && SwingUtilities.isLeftMouseButton(e)){
            System.out.println("Inside isInside");
            isDragging = true;
            offsetX = e.getX() - xStart;
            offsetXEnd = e.getX() - xEnd;
            offsetY = e.getY() - yStart;
            offsetYEnd = e.getY() - yEnd;

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased");
        isInside = false;
        isDragging = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //System.out.println("mouseDragged");
        if(isDragging && SwingUtilities.isMiddleMouseButton(e)){
            System.out.println("Inside isDragging");
            int newX = e.getX() - offsetX;
            int newY = e.getY() - offsetY;
            xEnd = newX;
            yEnd = newY;
            bounds = new Rectangle(xStart, yStart, xEnd - xStart, yEnd - yStart);
            repaint();
            myPanel.forcedRepaint();
        }
        if(isDragging && SwingUtilities.isLeftMouseButton(e)){
            System.out.println("Inside isDragging");
            int newX = e.getX() - offsetX;
            int newY = e.getY() - offsetY;
            int newXEnd = e.getX() - offsetXEnd;
            int newYEnd = e.getY() - offsetYEnd;
            xStart = newX;
            yStart = newY;
            xEnd = newXEnd;
            yEnd = newYEnd;
            bounds = new Rectangle(xStart, yStart, xEnd - xStart, yEnd - yStart);
            repaint();
            myPanel.forcedRepaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public boolean isInside(Point p) {
        return bounds.contains(p);
    }

    public Rectangle getBounds() {
        return bounds;
    }


    @Override
    public String toString(){
        return shape + "|" +xStart + "|" + yStart + "|" + xEnd + "|" + yEnd + "|" + color;
    }
}
