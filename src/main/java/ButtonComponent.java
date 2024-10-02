import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonComponent extends JComponent {

    JButton rectangleButton = new JButton("Rectangle");
    JButton circleButton = new JButton("Circle");
    JButton lineButton = new JButton("Line");

    Dimension buttonSize = new Dimension(100,50);

    Graphics graphics = new DebugGraphics();

    public ButtonComponent(){

        rectangleButton.setSize(buttonSize);
        rectangleButton.setBounds(0,0,buttonSize.width,buttonSize.height);
        rectangleButton.addActionListener(e -> System.out.println("RectangleButtonClicked!"));
        add(rectangleButton);

        circleButton.setSize(buttonSize);
        circleButton.setBounds(0,50,buttonSize.width,buttonSize.height);
        circleButton.addActionListener(e -> System.out.println("CircleButtonPressed!"));
        add(circleButton);

        lineButton.setSize(buttonSize);
        lineButton.setBounds(0,100,buttonSize.width,buttonSize.height);
        lineButton.addActionListener(e ->
                {
                graphics.setColor(Color.GREEN);
                graphics.drawLine(90,90,120,120);
                }
        );
        add(lineButton);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.graphics = g;
        g.setColor(Color.RED);
        g.drawLine(300,0,400,0);
    }
}
