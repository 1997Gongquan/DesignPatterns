package Single;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo01_Test {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        Demo01_Crack demo01=Demo01_Crack.getInstance();
        Demo01_Crack demo02=Demo01_Crack.getInstance();
        System.out.println(demo01);
        System.out.println(demo02);

//        //通过反射
//        Class<Demo01_Crack> clazz= Demo01_Crack.class;
//        Constructor<Demo01_Crack> c=clazz.getDeclaredConstructor(null);
//        //跳过安全检查
//        c.setAccessible(true);
//        Demo01_Crack demo03=c.newInstance();
//        Demo01_Crack demo04=c.newInstance();
//        System.out.println(demo03);
//        System.out.println(demo04);

        //通过反序列化构造多个对象
        //输出对象
        FileOutputStream fos=new FileOutputStream("E:/a.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(demo01);
        oos.close();
        fos.close();

        //反序列化读取
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("E:/a.txt"));
        Demo01_Crack demo05= (Demo01_Crack) ois.readObject();
        System.out.println(demo05);
    }
}
