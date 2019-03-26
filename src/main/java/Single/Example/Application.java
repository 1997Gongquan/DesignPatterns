package Single.Example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application extends JFrame implements ActionListener {
    JButton start;
    Player playerOne,playerTwo,playerThree;
    JButton one,two,three;
    JTextField showLabel;
    int width=06;
    int height=28;
    int maxDistance=460;
    public Application(){
        setLayout(null);
        start=new JButton("开始比赛");
        start.addActionListener(this);
        add(start);
        start.setBounds(200,30,90,20);
        showLabel=new JTextField("冠军会是谁呢？");
        showLabel.setEditable(false);
        add(showLabel);
        showLabel.setBounds(300,30,120,20);
        showLabel.setBackground(Color.ORANGE);
        showLabel.setFont(new Font("隶书",Font.BOLD,16));
        one=new JButton("苏快");
        one.setSize(60,30);
        one.setBackground(Color.YELLOW);
        playerOne=new Player(18,2,maxDistance,one,width,height,showLabel);
        two=new JButton("李卉");
        two.setSize(65,30);
        two.setBackground(Color.green);
        playerTwo=new Player(19,2,maxDistance,two,width,height,showLabel);
        three=new JButton("胡跑");
        three.setSize(62,30);
        three.setBackground(Color.cyan);
        playerThree=new Player(21,2,maxDistance,three,width,height,showLabel);
        initPosition();
        setBounds(100,100,600,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    private void initPosition(){
        Champion.initChampion();
        showLabel.setText("冠军会是谁呢？");
        repaint();
        remove(one);
        remove(two);
        remove(three);
        add(one);
        add(two);
        add(three);
        one.setLocation(1,60);
        two.setLocation(1,60+height+2);
        three.setLocation(1,60+2*height+4);
    }

    public void actionPerformed(ActionEvent e) {
        boolean boo=playerOne.isAlive()||playerTwo.isAlive()||playerThree.isAlive();
        if(boo==false){
            initPosition();
            int m= (int) ((Math.random()*2)+19);
            playerOne=new Player(m,2,maxDistance,one,width,height,showLabel);
            m= (int) ((Math.random()*3)+18);
            playerTwo=new Player(m,2,maxDistance,two,width,height,showLabel);
            m= (int) ((Math.random()*4)+17);
            playerThree=new Player(m,2,maxDistance,three,width,height,showLabel);
        }
        playerOne.start();
        playerTwo.start();
        playerThree.start();
    }

    public void paint(Graphics g){
        super.paint(g);
        g.drawLine(maxDistance,0,maxDistance,maxDistance);
    }

}
