package threadpool;

/**
 * @author c_fu
 * @date 2017/8/24
 * @time 16:43
 */
public class FirstThreadTest extends Thread {

  public static void main(String[] args) {
    //获得线程
    FirstThreadTest thread = new FirstThreadTest();
    System.out.println("线程名称为：" + thread.getName());
    //启动线程
    thread.start();
    System.out.println("main方法也是一个线程：" + Thread.currentThread().getName());
  }

  public void run() {
    System.out.println("这里是线程的执行方法");
  }
}
