import javax.swing.*;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

public class MouseComponent extends MouseMotionAdapter implements MouseListener, MouseMotionListener {

    MyPanel myPanel;
    Component selectedComponent = null;

    public MouseComponent(MyPanel panel) {
        myPanel = panel;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);

        if(SwingUtilities.isRightMouseButton(e)) {
            myPanel.addDrawable(new DrawComponent("line",e.getX(),e.getY(),e.getX()+1,e.getY()+1,null));
        }else{
            if(selectedComponent != null) {
                selectedComponent.move(e.getX(),e.getY());
                myPanel.add(selectedComponent);
                myPanel.repaint();
                //System.out.println("Component location: "+selectedComponent + "| " + selectedComponent.getLocation());
            }
        }
        //System.out.println("Mouse position: " + e.getX() + ", " + e.getY());
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        selectedComponent = myPanel.getComponentAt(e.getX(), e.getY());
        System.out.println(selectedComponent);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
