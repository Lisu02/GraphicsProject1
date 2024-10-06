import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonComponent extends JComponent {

    JButton rectangleButton = new JButton("Rectangle");
    JButton circleButton = new JButton("Circle");
    JButton lineButton = new JButton("Line");

    static Color paintingColor = Color.GREEN;

    Dimension buttonSize = new Dimension(100,50);



    String selectedShape= "";

    public ButtonComponent(MyPanel myPanel) {

        setLayout(null);
        setVisible(true);


        rectangleButton.setSize(buttonSize);
        rectangleButton.setBounds(0,0,buttonSize.width,buttonSize.height);
        rectangleButton.addActionListener(e -> {
            selectedShape = "rectangle";
            myPanel.addDrawable(new DrawComponent(selectedShape,200,400,500,650,Color.ORANGE));
        });
        add(rectangleButton);

        circleButton.setSize(buttonSize);
        circleButton.setBounds(0,50,buttonSize.width,buttonSize.height);
        circleButton.addActionListener(e -> {
            selectedShape = "circle";
            myPanel.addDrawable(new DrawComponent(selectedShape,150,200,500,650,Color.GREEN));
            System.out.println("circle");
        });
        add(circleButton);

        lineButton.setSize(buttonSize);
        lineButton.setBounds(0,100,buttonSize.width,buttonSize.height);
        lineButton.addActionListener(e -> {
            selectedShape = "line";
            myPanel.addDrawable(new DrawComponent(selectedShape,600,100,500,869));
            //myPanel.setShapeToDraw(selectedShape);
        });
        add(lineButton);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(paintingColor);
        g.drawOval(500,550,400,123);
        switch (selectedShape){
            case "line":
                g.drawLine(300,150,450,250);
                break;
            case "circle":
                g.drawOval(300,150,buttonSize.width,buttonSize.height);
                break;
            case "rectangle":
                g.drawRect(300,150,buttonSize.width,buttonSize.height);
            default:
                break;
        }

    }

}
