import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonComponent extends JComponent {

    JButton rectangleButton = new JButton("Rectangle");
    JButton circleButton = new JButton("Circle");
    JButton lineButton = new JButton("Line");
    JButton clearButton = new JButton("Clear");

    JButton saveButton = new JButton("Save");
    JButton loadButton = new JButton("Load");

    JTextField xTextField = new JTextField("150");
    JTextField yTextField = new JTextField("120");
    JTextField xEndTextField = new JTextField("300");
    JTextField yEndTextField = new JTextField("300");

    static Color paintingColor = Color.GREEN;

    Dimension buttonSize = new Dimension(100,50);



    String selectedShape= "";

    public ButtonComponent(MyPanel myPanel) {

        setLayout(null);
        setVisible(true);

        clearButton.setBounds(buttonSize.width,0,buttonSize.width,buttonSize.height);
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myPanel.clearDrawable();
            }
        });

        saveButton.setBounds(buttonSize.width,50,buttonSize.width,buttonSize.height);
        saveButton.addActionListener(e -> {
            SaveAndReadFile.saveToFile(myPanel.drawComponentList);
        });
        add(saveButton);

        loadButton.setBounds(buttonSize.width,100,buttonSize.width,buttonSize.height);
        loadButton.addActionListener(e -> {
            SaveAndReadFile.readFromFile(myPanel);
        });
        add(loadButton);

        xTextField.setBounds(0,150,buttonSize.width,buttonSize.height);
        xTextField.setBackground(Color.cyan);
        xTextField.setForeground(Color.black);
        yTextField.setBounds(0,200,buttonSize.width,buttonSize.height);
        yTextField.setBackground(Color.cyan);
        yTextField.setForeground(Color.black);
        xEndTextField.setBounds(0,250,buttonSize.width,buttonSize.height);
        yEndTextField.setBounds(0,300,buttonSize.width,buttonSize.height);
        JColorChooser colorChooser = new JColorChooser();

        colorChooser.setBounds(0,350,buttonSize.width+350,buttonSize.height+200);
        colorChooser.setColor(Color.GREEN);

        add(colorChooser);
        add(xTextField);
        add(yTextField);
        add(xEndTextField);
        add(yEndTextField);

        add(clearButton);

        rectangleButton.setSize(buttonSize);
        rectangleButton.setBounds(0,0,buttonSize.width,buttonSize.height);
        rectangleButton.addActionListener(e -> {
            selectedShape = "rectangle";
            myPanel.addDrawable(new DrawComponent(
                    selectedShape,
                    Integer.parseInt(xTextField.getText()),
                    Integer.parseInt(yTextField.getText()),
                    Integer.parseInt(xEndTextField.getText()),
                    Integer.parseInt(yEndTextField.getText()),
                    colorChooser.getColor(),
                    myPanel
            ));
        });
        add(rectangleButton);

        circleButton.setSize(buttonSize);
        circleButton.setBounds(0,50,buttonSize.width,buttonSize.height);
        circleButton.addActionListener(e -> {
            selectedShape = "circle";
            myPanel.addDrawable(new DrawComponent(selectedShape,
                    Integer.parseInt(xTextField.getText()),
                    Integer.parseInt(yTextField.getText()),
                    Integer.parseInt(xEndTextField.getText()),
                    Integer.parseInt(yEndTextField.getText()),
                    colorChooser.getColor(),
                    myPanel
            ));
            System.out.println("circle");
        });
        add(circleButton);

        lineButton.setSize(buttonSize);
        lineButton.setBounds(0,100,buttonSize.width,buttonSize.height);
        lineButton.addActionListener(e -> {
            selectedShape = "line";

            myPanel.addDrawable(new DrawComponent(selectedShape,
                    Integer.parseInt(xTextField.getText()),
                    Integer.parseInt(yTextField.getText()),
                    Integer.parseInt(xEndTextField.getText()),
                    Integer.parseInt(yEndTextField.getText()),
                    colorChooser.getColor(),
                    myPanel
            ));
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
                //g.drawRect(300,150,buttonSize.width,buttonSize.height);
                //g.fillRect(300,150,buttonSize.width,buttonSize.height);
            default:
                break;
        }

    }

}
