package threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author c_fu
 * @date 2017/8/24
 * @time 16:57
 */
public class CallableThreadTest implements Callable<List<String>> {

  public static void main(String[] args) {
//    定义一个线程池
    ExecutorService threadPool = Executors.newFixedThreadPool(5);

    List<String> list = new ArrayList<String>();
//    提交线程到线程池，接收结果
    for (int i = 0; i < 5; i++) {
      //    定义一个线程
      CallableThreadTest threadTest = new CallableThreadTest();
      Future<List<String>> result = threadPool.submit(threadTest);
      try {
        list.addAll(result.get());
        if (list.size() > 1) {
          break;
        }
      } catch (Exception e) {
      }
    }

    System.out.print("执行结果:");
    for (String s : list) {
      System.out.println(s + ", ");
    }

    System.out.println("主线程执行完成");

  }

  public List<String> call() throws Exception {
    List<String> res = new ArrayList<String>();
    System.out.println("子线程在执行任务：" + Thread.currentThread().getName() + "线程内Call方法");
    res.add(Thread.currentThread().getName());
    return res;
  }
}
