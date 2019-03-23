package Cammand;

import javax.swing.*;

public class Camera extends JPanel {
    String name;
    Icon imageIcon;
    JLabel label;
    public Camera(){
        label=new JLabel("我是摄像头");
        add(label);
    }

    public void on(){
        label.setIcon(new ImageIcon("src/main/java/Cammand/arcs3.jpg"));
    }


    public void off(){
        label.setIcon(new ImageIcon("src/main/java/Cammand/arcs4.jpg"));
    }
}
