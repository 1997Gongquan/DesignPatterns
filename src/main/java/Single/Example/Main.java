package Single.Example;

//应用举例
/*设计一个Champion单件类以及多个线程，每个线程从左向右水平移动一个属于自己的按钮，最先将按钮移动到指定位置的线程为冠军
 *即该线程将负责创建出Champion单件类的唯一实例，后续将自己的按钮移动到指定位置的其他线程都可以看到冠军的有关信息
 * 即看到Champion单件的唯一实例的有关属性值
 *
 */
public class Main {
    public static void main(String[] args){
        new Application();
    }

}
