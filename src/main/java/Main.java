import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        String nazwa = "Projekt1";
        int rozmiarX = 900;
        int rozmiarY = 800;
        Color tlo = Color.BLACK;
        MyFrame frame = new MyFrame(nazwa,rozmiarX,rozmiarY,tlo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
