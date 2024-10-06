import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame(String nazwa, int rozmiarX, int rozmiarY, Color tlo){
        super(nazwa);
        MyPanel panel = new MyPanel(rozmiarX, rozmiarY);
        panel.setBackground(tlo);
        add(panel);
        pack();
        setVisible(true);
    }

}
