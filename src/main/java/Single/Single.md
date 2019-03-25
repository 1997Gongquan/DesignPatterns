# <center> 单例模式
## 核心作用
* 保证一个类只有一个实例，并且提供一个访问该实例的全局访问点
## 常见应用场景
* Windows的任务管理器、回收站就是典型的单例模式
* 项目中，读取配置文件的类，一般也只有一个对象。没有必要每次使用配置文件数据，每次new一个对象去读取。
* 网站的计数器，一般采用单例模式实现。
* 应用程序的日志应用，一般都采用单例模式实现，者一般时由于共享的日志文件一直处于打开状态，因为只能由一个实例去操作，否则内容不好追加
* 数据库连接池的设计一般采用单例模式，因为数据库连接的是一种数据库资源
* 操作系统的文件系统，也是大的单例模式实现的具体例子，一个操作系统只有一个文件系统
* Application也是单例的典型应用（Servlet编程中会涉及到）
* 在Spring中，每个Bean默认就是单例的，这样做的优点是Spring容器可以管理
* 在Servlt编程中，每个Servlet也是单例
* 在Spring MVC/struts框架中，控制器对象也是单例

## 单例模式的优点
* 减少了系统性能开销，当一个对象的产生需要比较多的资源时，如读取配置、产生其他依赖对象时，则可以通过在应用启动时直接产生一个单例对象，然后永久潴留内存的方式来解决
* 单例模式可以在系统设置全局的访问点，优化共享资源访问，例如可以设计一个单例类，负责所有数据表的映射处理

## 常见的5种单例模式实现方式
* 主要
    * 饿汉式（线程安全，调用效率高。但是，不能延时加载）
    * 懒汉式（线程安全，调用效率不高，但是，可以延时加载）
* 其他：
    * 双重检测锁式（由于JVM底层内部模型原因，偶尔会出问题，不建议使用）
    * 静态内部类式（线程安全，调用效率高，但是，可以延时加载）
    * 枚举单例（线程安全，调用效率高，不能延时加载）

### 饿汉式实现（单例对象立即加载）
    public class Demo01{
        private static Demo01 demo=new Demo01();

        //私有化构造器
        private Demo01(){}

        //从这里取对象
        public static Demo01 getInstance(){
            return s;
        }

    }
* 饿汉式单例模式代码中，static变量会在类装载时初始化，此时不会涉及多个线程对象访问该对象的问题。虚拟机保证只会装载一次该类，肯定不会发生并发访问的问题，因此，可以省略 synchronized关键字
* 如果只是加载本类，而不是要调用getInstance()，甚至永远没有调用，则会照成资源浪费

### 懒汉式实现（单例对象延时加载）
    public class Demo02 {
        private static Demo02 instance;
        private Demo02(){};
        public static synchronized Demo02 getInstance(){
            //延时加载
            if(instance==null){
                //线程A在此处挂起，B new对象，然后A继续运行，new一个新对象，违反单例的概念
                instance=new Demo02();
            }
            return instance;
        }
    }
* 延时加载，懒加载，真正使用的时候才加载
* 资源利用率提高了，按时每次调用getInstance()方法时都要同步，并发效率低（并发时创建多个对象）


### 双重检测锁实现
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
* 此种模式将同步内容下放到if内部，提高了执行的效率，不必每次获取对象时都进行同步，只有第一次才同步，创建后就没有必要同步了。
* 由于编译器优化原因和JVM底层原因，偶尔会出现文通，不建议使用

### 静态内部类的实现（也是一种懒加载）
    public class Demo04 {
        private static class Demo04Instance{
            private static final Demo04 instance=new Demo04();
        }
        //方法没有同步，调用效率高
        public static Demo04 getInstance(){
            return Demo04Instance.instance;
        }
    
        private Demo04(){}
    }

* 外部类没有static属性，则不会像懒汉式那样立即加载对象。
* 只有真正调用getInstance()才会加载静态内部类。加载时是线程安全的。instance是staic final类型，保证了内存种只有这样一个实例存在，而且只被赋值一次，从而保证了线程安全性
* 兼备了并发高效和延迟加载的优势

### 单例枚举（天然单例，无延时加载）
    public enum Demo05 {
        //定义一个枚举的元素，他代表了Demo05的一个实例
        INSTANCE;
        public void operation(){
        }
    }
* 实现简单，枚举本身就是单例模式，由JVM从根本上提供保障，避免通过反射和反序列化的漏洞（反射调用private属性）
* 无延迟加载

## 问题

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
* 反射可以破解上面的几种实现方式（可以在钩爪方法种手动抛出异常控制）
* 反射化序列可以破解上面集中实现方式！
    * 可以通过定义readResolve()防止获得不同对象。
        * 反序列化时，如果对象所在类定义了readResolve()，实际是一种回调，定义返回哪个对象

## 常见的五种单例模式在多线程环境下的效率测试

    public class Efficiency {
        public static void main(String[] args) throws InterruptedException {

            long start=System.currentTimeMillis();
            int threadNum=10;
            final CountDownLatch countDownLatch=new CountDownLatch(threadNum);
            for(int j=0;j<threadNum;j++){
                new Thread(new Runnable() {
                    public void run() {
                        for(int i=0;i<500000;i++){
                            Object o =Demo01.getInstance();
                        }
                        countDownLatch.countDown();
                    }
                }).start();
            }
            countDownLatch.await();
            long end=System.currentTimeMillis();
            System.out.println("总耗时："+(end-start));
        }
    }
        