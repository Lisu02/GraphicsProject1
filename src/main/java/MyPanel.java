import javax.swing.*;
import java.awt.*;
import java.awt.Component;
import java.util.LinkedList;

public class MyPanel extends JPanel {


    int sizeX,sizeY;

    JButton testButton = new JButton("TestButton");
    JTextField textFieldX = new JTextField("100");
    JTextField textFieldY = new JTextField("100");

    Graphics2D g2;

    LinkedList<DrawComponent> drawComponentList = new LinkedList<>();

    String shapeToDraw = "";

    public MyPanel(int sizeX, int sizeY){
        setLayout(null); //SETLAYOUT NULL DLA JPANEL przyciski w dowolnym miejscu z setBounds!
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        ButtonComponent buttonComponent = new ButtonComponent(this);
        add(buttonComponent);
        addComponentArray(buttonComponent.getComponents());
        textFieldX.setBounds(500,700,100,30);
        textFieldY.setBounds(600,730,100,30);
        add(textFieldX);
        add(textFieldY);
        //drawComponentList.add(new DrawComponent("rectangle",300,345,500,495));
        setPanelSize();
        requestFocus();
    }

    private void addComponentArray(Component[] components){
        for (Component component: components) {
            component.setBackground(Color.YELLOW);

            add(component);
        }
    }

    public void paintComponent(Graphics g){
        this.g2 = (Graphics2D) g;
        super.paintComponent(g2);
        g2.setColor(Color.BLACK);
        //drawTestObjects();

        for(Drawable drawable: drawComponentList){
            drawMyComponent(drawable);
        }
    }

    public void drawMyComponent(Drawable drawable){
        drawable.draw(g2);
    }


    public void addDrawable(DrawComponent drawComponent){
        boolean isComponentUnique = true;
        for(DrawComponent drawable: drawComponentList){
            if(drawComponent.componentEquals(drawable)){
                isComponentUnique = false;
                System.out.println(isComponentUnique);
            }
        }
        if(isComponentUnique){
            drawComponentList.add(drawComponent);
            repaint();
        }
        System.out.println(drawComponentList.size());
    }

    private void setPanelSize(){
        Dimension size = new Dimension(sizeX,sizeY);
        setPreferredSize(size);
    }

    private void drawTestObjects(){
        drawRectangle(100,100,150,150);
        drawCircle(250,250,50);
        drawLine(350,350,550,350);
    }

    private void drawRectangle(int startX, int startY, int lengthX,int lengthY){
        g2.setColor(Color.WHITE);
        g2.setBackground(Color.WHITE);

        g2.drawRect(startX,startY,lengthX,lengthY);
    }

    private void drawCircle(int startX, int startY, int radious){
        g2.setColor(Color.BLUE);
        g2.drawArc(startX,startY,radious,radious,0,360);
    }

    private void drawLine(int startX,int startY,int endX,int endY){
        g2.setColor(Color.RED);
        g2.drawLine(startX,startY,endX,endY);
    }

}
