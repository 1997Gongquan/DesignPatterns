package Single.Example;
//冠军的单例类，以懒汉式实现
public class Champion {

    private static Champion instance;
    private String message;
    private Champion(String message){
        this.message=message;
    }

    public static synchronized Champion getInstance(String message){
        if(instance==null){
            instance=new Champion(message);
        }
        return instance;
    }

    public static void initChampion(){
        instance=null;
    }

    public String getMessage() {
        return message;
    }
}
