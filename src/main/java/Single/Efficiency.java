package Single;

import java.util.concurrent.CountDownLatch;

//测试5种单例模式在多线程环境下的效率
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
