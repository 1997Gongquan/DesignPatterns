package Cammand;

public class OffLightCommand implements Cammand {
    Light light;

    OffLightCommand(Light light){
        this.light=light;
    }
    public void execute() {
        light.off();
    }

    public String getName() {
        return "关闭照明灯";
    }
}
