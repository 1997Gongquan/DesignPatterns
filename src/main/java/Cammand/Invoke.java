package Cammand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Invoke {
    JButton button;
    Cammand cammand;
    public Invoke(){
        button =new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeCommand();
            }
        });
    }


    public void setCammand(Cammand cammand){
        this.cammand=cammand;
        button.setText(cammand.getName());
    }

    public JButton getButton(){
        return button;
    }

    private void executeCommand(){
        cammand.execute();
    }
}
