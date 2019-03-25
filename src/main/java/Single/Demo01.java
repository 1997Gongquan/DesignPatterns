package Single;
//测试饿汉式单例模式
public class Demo01 {

    //类初始化时立即加载（当类比较复杂的时候，立即加载会比较耗费资源，因此会考虑延时加载）
    private static Demo01 instance=new Demo01();

    //私有化构造器
    private Demo01(){}

    //从这里取对象
    public static Demo01 getInstance(){
        return instance;
    }
}
