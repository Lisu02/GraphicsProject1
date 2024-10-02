import javax.swing.*;
import java.awt.*;
import java.awt.Component;

public class MyPanel extends JPanel {


    int sizeX,sizeY;

    JButton testButton = new JButton("TestButton");
    JTextField textField = new JTextField("TestText");

    Graphics2D g2;

    public MyPanel(int sizeX, int sizeY){
        setLayout(null); //SETLAYOUT NULL DLA JPANEL przyciski w dowolnym miejscu z setBounds!
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        ButtonComponent buttonComponent = new ButtonComponent();
        addComponentArray(buttonComponent.getComponents());
        //testButton.setBackground(Color.GREEN);
        //testButton.setSize(100,350);
        //testButton.setBounds(400,700,100,30);
        textField.setBounds(500,700,100,30);
        //testButton.setLayout(null);
        //textField.setLayout(null);
        add(textField);
        //add(testButton);
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
        drawTestObjects();
    }

    private void paintButtons(Graphics2D g2){
        //buttonComponent
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
