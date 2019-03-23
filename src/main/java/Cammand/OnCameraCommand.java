package Cammand;

public class OnCameraCommand implements Cammand {

    Camera camera;

    OnCameraCommand(Camera camera){
        this.camera=camera;
    }

    public void execute() {
        camera.on();
    }

    public String getName() {
        return "打开摄像头";
    }
}
