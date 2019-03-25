package Single;
//双重检测锁模式
public class Demo03 {
    private static Demo03 instance;
    public static Demo03 getInstance(){
        if(instance==null){
            Demo03 temp;
            synchronized (Demo03.class){
                temp=instance;
                if(temp==null){
                    synchronized (Demo03.class){
                        if(temp==null){
                            temp=new Demo03();
                        }
                    }
                }
                instance=temp;
            }
        }
        return instance;
    }
    private Demo03(){ }
}
