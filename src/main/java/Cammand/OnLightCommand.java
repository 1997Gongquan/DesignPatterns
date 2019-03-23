package Cammand;

public class OnLightCommand implements Cammand {
    Light light;

    OnLightCommand(Light light){
        this.light=light;
    }
    public void execute() {
        light.on();
    }

    public String getName() {
        return "打开照明灯";
    }
}
