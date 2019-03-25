package Single;

//如何防止反射和反序列化漏洞，懒汉式单例模式

import java.io.Serializable;

public class Demo01_Crack implements Serializable {
    //类初始化时立即加载（当类比较复杂的时候，立即加载会比较耗费资源，因此会考虑延时加载）
    private static Demo01_Crack instance=new Demo01_Crack();

    //私有化构造器
    private Demo01_Crack(){
//        if(instance!=null){
//            throw new RuntimeException("重复！！！");
//        }
    }

    //从这里取对象
    public static Demo01_Crack getInstance(){
        return instance;
    }

    //在发序列化时直接调用这个方法，而不需要再把新对象返回
//    private Object readResolve(){
//        return instance;
//    }
}
