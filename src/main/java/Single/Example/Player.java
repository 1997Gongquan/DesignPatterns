package Single.Example;

//选手类，负责创建线程对象，每一个线程即为一个选手

import javax.swing.*;

public class Player extends Thread{
    int maxDistance;
    int stopTime,step;

    JButton com;
    JTextField showMess;
    Champion champion;

    public Player(int stopTime,int step,int maxDistance,JButton com,int w,int h,JTextField showMess){
        this.showMess=showMess;
        this.step=step;
        this.com=com;
        this.maxDistance=maxDistance;
        this.stopTime=stopTime;
    }


    @Override
    public void run() {
        super.run();
        while(true){
            int a=com.getBounds().x;
            int b=com.getBounds().y;
            if(a+com.getBounds().width>=maxDistance){
                champion=Champion.getInstance(com.getText());
                showMess.setText(champion.getMessage());
                return;
            }
            a=a+step;
            com.setLocation(a,b);
            try {
                sleep(stopTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
