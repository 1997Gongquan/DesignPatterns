package Cammand;

public class OffCameraCommand implements Cammand{
    Camera camera;

    OffCameraCommand(Camera camera){
        this.camera=camera;
    }

    public void execute() {
        camera.off();
    }

    public String getName() {
        return "关闭摄像头";
    }
}
