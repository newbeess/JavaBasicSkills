package concurrent;


import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * @author c_fu
 * @date 2017/12/13
 */
public class MultiplePosts {

//    public static void main(String[] args) throws Exception {
//        ExecutorService threadPool = Executors.newCachedThreadPool();
//
//        int threadNum=20000;
//        CyclicBarrier barrier=new CyclicBarrier(threadNum);
//        List<SelectUserRightsInterestRequestType> requestTypeList = new ArrayList<>();
//        for (int i = 0; i < threadNum; i++) {
//            SelectUserRightsInterestRequestType request = new SelectUserRightsInterestRequestType();
//            request.setPlatform("h5");
//            request.setRightsInterestID(515L);
//            UserInfo userInfo = new UserInfo();
//            userInfo.setUID("123456");
//            request.setUserInfo(userInfo);
//            request.setProductLineID(31);
//            requestTypeList.add(request);
//        }
//
//        for (SelectUserRightsInterestRequestType requestType : requestTypeList) {
//            ThreadTest task = new ThreadTest(1,barrier);
//            threadPool.submit(task);
//        }
//        threadPool.shutdown();
//    }
}


class ThreadTest<T> implements Callable<Integer> {

    T request;
    CyclicBarrier barrier;

    public ThreadTest(T request, CyclicBarrier barrier) {
        this.request = request;
        this.barrier=barrier;
    }


    public Integer call() throws Exception {
        return select();
    }

    public Integer select() {
//        CloseableHttpClient client = null;
//        try {
//            client = HttpClients.createDefault();
//            HttpPost post = new HttpPost("http://10.5.58.9:8080/vipwelfarews/api/json/selectUserRightsInterest");
//            post.setHeader("Content-type", "application/json; charset=utf-8");
//            post.setHeader("Connection", "Close");
//            StringEntity entity = new StringEntity(JSON.toJSONString(request), Charset.forName("UTF-8"));
//            entity.setContentEncoding("UTF-8");
//            post.setEntity(entity);
////            System.out.println("准备就绪"+"========="+barrier.getNumberWaiting());
//            barrier.await();
//            HttpResponse response = client.execute(post);
////            System.out.println(JSON.toJSONString(response));
////            System.out.println("输出");
//        } catch (Exception e) {
//
//        }
        return 1;
    }

}
