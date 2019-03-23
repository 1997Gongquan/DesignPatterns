package Cammand;

import javax.swing.*;
import java.awt.*;

public class Machine extends JFrame {

    Invoke requestOnCamera,requestOffCamera,requestOnLight,requestOffLight;

    Camera camera;
    Light light;
    public Machine(){
        setTitle("小电器");
        requestOnCamera=new Invoke();
        requestOffCamera=new Invoke();
        camera=new Camera();
        light=new Light();
        requestOnCamera.setCammand(new OnCameraCommand(camera));
        requestOffCamera.setCammand(new OffCameraCommand(camera));
        requestOnLight=new Invoke();
        requestOffLight=new Invoke();
        requestOnLight.setCammand(new OnLightCommand(light));
        requestOffLight.setCammand(new OffLightCommand(light));
        initPosition();
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    private void initPosition(){
        JPanel pSourth=new JPanel();
        pSourth.add(requestOffCamera.getButton());
        pSourth.add(requestOnCamera.getButton());
        pSourth.add(requestOffLight.getButton());
        pSourth.add(requestOnLight.getButton());

        add(pSourth, BorderLayout.SOUTH);
        JPanel pNorth=new JPanel();
        pNorth.add(light);
        add(pNorth,BorderLayout.NORTH);
        JPanel pCenter=new JPanel();
        pCenter.add(camera);
        add(pCenter,BorderLayout.CENTER);

    }}
