package Single;
//静态内部类单例模式
public class Demo04 {
    private static class Demo04Instance{
        private static final Demo04 instance=new Demo04();
    }

    public static Demo04 getInstance(){
        return Demo04Instance.instance;
    }

    private Demo04(){}
}
