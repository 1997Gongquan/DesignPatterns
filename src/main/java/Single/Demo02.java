package Single;
//懒汉式单例模式
public class Demo02 {
    private static Demo02 instance;

    private Demo02(){};

    public static synchronized Demo02 getInstance(){
        //延时加载
        if(instance==null){
            instance=new Demo02();
        }
        return instance;

    }
}
