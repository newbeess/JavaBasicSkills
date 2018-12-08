package threadpool;

/**
 * @author c_fu
 * @date 2017/8/24
 * @time 16:45
 */
public class RunnableThreadTest implements Runnable {

  public static void main(String[] args) {
    RunnableThreadTest thread = new RunnableThreadTest();
    Thread t1 = new Thread(thread, " 线程一");
    Thread t2 = new Thread(thread, "线程二");
    t2.start();
    t1.start();
  }

  @Override
  public void run() {
    System.out.print(Thread.currentThread().getName());
    System.out.println("线程方法");
  }
}
