package Factory.SimpleFactory;
//简单工厂模式
public class SimpleFactory {

    //调用者，需要知道接口类以及实现类（Student、Boy、Girl）

    public static void main(String[] args){
        //没有工厂的时候
        Student s1=new Boy();
        Student s2=new Girl();
        s1.talk();
        s2.talk();

        //有工厂模式
        Student s3=createStudent("男孩");
        s3.talk();

        Student s4=SimpleFactory.creatGirl();
        s4.talk();
    }

    public static Student createStudent(String type){
        //根据开闭原则，当需要增加性别的时候，需要修改代码，所有有缺点
        if("男孩".equals(type)){
            return new Boy();
        }else
            return new Girl();
    }

    public static Boy creatBoy(){
        return new Boy();
    }

    public static Girl creatGirl(){
        return new Girl();
    }
}
