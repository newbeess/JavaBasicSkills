package com.enzo.collection;

import com.google.common.base.Splitter;
import com.google.common.base.Stopwatch;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import po.PromotionCouponInfo;
import po.ReceivedCouponItem;
import po.UserRightsProductInfo;

/**
 * @author c_fu
 * @date 2017/10/13
 * @time 19:59
 */
public class EnumTest {

    public static void main(String[] args) {
//        List<Long> list = new ArrayList<Long>();
//        List<Long> partList=new ArrayList<Long>();
//        list.add(444L);
//        list.add(5555L);
//        list.add(111L);
//        partList.add(111L);
//        partList.add(222L);
//        testRemoveAll(list,partList);
//        testFor();
//testTime();
//int a=testReturn();
        List<UserRightsProductInfo> receiveList = getUserRightInfoList();
        List<ReceivedCouponItem> itemList = getReceiveItemList();
        Map<Integer, List<PromotionCouponInfo>> testMap = new HashMap<Integer, List<PromotionCouponInfo>>();
        for (ReceivedCouponItem item : itemList) {
            PromotionCouponInfo couponInfo = new PromotionCouponInfo();
            couponInfo.setCouponCode(item.getCouponCode());
            couponInfo.setPromotionID(item.getPromotionID());
            if (testMap.containsKey(item.getPromotionID())){
                List<PromotionCouponInfo> list=testMap.get(item.getPromotionID());
                list.add(couponInfo);
            }else {
                List<PromotionCouponInfo> list=new ArrayList<PromotionCouponInfo>();
                list.add(couponInfo);
                testMap.put(item.getPromotionID(), list);
            }
        }

        for (UserRightsProductInfo info : receiveList){
            if (testMap.containsKey(info.getPromotionCode())){
                Integer id=info.getPromotionCode();
                int listSize=testMap.get(info.getPromotionCode()).size();
                String couponCode=testMap.get(info.getPromotionCode()).get(listSize-1).getCouponCode();
                testMap.get(info.getPromotionCode()).remove(listSize-1);
                System.out.println("策略："+id+";;;券码=="+couponCode);
            }
        }

    }
    private static List<ReceivedCouponItem> getReceiveItemList() {
        List<ReceivedCouponItem> list = new ArrayList<ReceivedCouponItem>();
        ReceivedCouponItem item = new ReceivedCouponItem();
        item.setCouponCode("xxxdee0");
        item.setPromotionID(13470);
        list.add(item);
        ReceivedCouponItem item1 = new ReceivedCouponItem();
        item1.setCouponCode("xxxdee1");
        item1.setPromotionID(13471);
        list.add(item1);
        ReceivedCouponItem item2 = new ReceivedCouponItem();
        item2.setCouponCode("xxxdee2");
        item2.setPromotionID(13470);
        list.add(item2);
        return list;

    }
    private static List<UserRightsProductInfo> getUserRightInfoList() {
        List<UserRightsProductInfo> list = new ArrayList<UserRightsProductInfo>();
        UserRightsProductInfo info = new UserRightsProductInfo();
        info.setPromotionCode(13470);
        info.setUserProductId(580);
        info.setResult("成功");
        list.add(info);
        UserRightsProductInfo info1 = new UserRightsProductInfo();
        info1.setPromotionCode(13471);
        info1.setUserProductId(581);
        info1.setResult("成功");
        list.add(info1);
        UserRightsProductInfo info2 = new UserRightsProductInfo();
        info2.setPromotionCode(13470);
        info2.setUserProductId(582);
        info2.setResult("成功");
        list.add(info2);
        return list;
    }




    public static void testRemove(HashMap<Integer, String> map) {
        map.remove(0);
    }

    public static int testReturn() {
        int res = 0;
        try {
            res = 1;
            return res;
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            res = 2;
        }
        return res;
    }

    public static void testTime() {
        long[] millisecondsTimeSpan = getMillisecondsTimeSpan();

    }

    private static long[] getMillisecondsTimeSpan() {
        Timestamp[] nextFirstDays = getNextFirstDays();
        long[] list = new long[4];
        list[0] = (nextFirstDays[0].getTime() - System.currentTimeMillis());
        list[1] = (nextFirstDays[1].getTime() - System.currentTimeMillis());
        list[2] = (nextFirstDays[2].getTime() - System.currentTimeMillis());
        list[3] = (nextFirstDays[3].getTime() - System.currentTimeMillis());
        return list;
    }

    private static Timestamp[] getNextFirstDays() {

        //1: 默认初始值，每次的情况可以设置此值
        Timestamp nextFirstTime = Timestamp.valueOf("2050-1-1 0:0:0");
        //2: 第二天的0点
        Timestamp nextFirstDay = new Timestamp(nextDayStartDate().getTimeInMillis());
        //3: 下周第一天的0点
        Calendar thisWeek = getThisWeekStart();
        thisWeek.add(Calendar.DAY_OF_MONTH, 7);//下周第一天的0点
        Timestamp nextFirstDayOfWeek = new Timestamp(thisWeek.getTimeInMillis());
        //4: 下个月第一天的0点
        Calendar thisMonth = getThisMonthStart();
        thisMonth.add(Calendar.MONTH, 1);//下个月第一天的0点
        Timestamp nextFirstDayOfMonth = new Timestamp(thisMonth.getTimeInMillis());
        Timestamp[] list = {nextFirstTime, nextFirstDay, nextFirstDayOfWeek, nextFirstDayOfMonth};
        return list;
    }

    private static Calendar getThisMonthStart() {
        Calendar thisMonthStart = Calendar.getInstance();
        thisMonthStart.set(Calendar.HOUR_OF_DAY, 0);
        thisMonthStart.set(Calendar.MINUTE, 0);
        thisMonthStart.set(Calendar.SECOND, 0);
        thisMonthStart.set(Calendar.MILLISECOND, 0);
        thisMonthStart.set(Calendar.DAY_OF_MONTH, 1);
        return thisMonthStart;
    }

    private static Calendar getThisWeekStart() {
        Calendar nextWeekStart = Calendar.getInstance();
        nextWeekStart.set(Calendar.HOUR_OF_DAY, 0);
        nextWeekStart.set(Calendar.MINUTE, 0);
        nextWeekStart.set(Calendar.SECOND, 0);
        nextWeekStart.set(Calendar.MILLISECOND, 0);
        nextWeekStart.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return nextWeekStart;
    }

    public static Calendar nextDayStartDate() {
        Calendar nextDayStart = Calendar.getInstance();
        nextDayStart.set(Calendar.HOUR_OF_DAY, 0);
        nextDayStart.set(Calendar.MINUTE, 0);
        nextDayStart.set(Calendar.SECOND, 0);
        nextDayStart.set(Calendar.MILLISECOND, 0);
        nextDayStart.add(Calendar.DAY_OF_MONTH, 1);
        return nextDayStart;
    }

    public static void testFor() {
        for (int i = 1; i < 10; i++) {
            System.out.println(i);
            if (i == 3) {
                return;
            }
        }
    }

    public static void testRemoveAll(List<Long> totalList, List<Long> partList) {
        System.out.println("totalList");
        for (Long total : totalList) {
            System.out.print("," + total);
        }
        System.out.println("partList");
        for (Long total : partList) {
            System.out.print("," + total);
        }
        totalList.removeAll(partList);
        System.out.println("leftList");
        for (Long total : totalList) {
            System.out.print("," + total);
        }
    }

    public static void testForEach(List<Long> list) {
        try {
            for (Long l : list) {
                System.out.println("===" + l);
            }
        } catch (Exception e) {
            System.out.println("抛出异常");
        }
    }

    public static void testEqual(Long a, Long b) {
        System.out.println("a==b:" + (a == b));
        System.out.println("a.equals(b):" + a.equals(b));
    }

    public static void testTrim(String s) {
        String strim = s.trim();
        System.out.println("s =" + strim + "===" + "s.size=" + strim.length());
    }

    public static void textFilter(String s) {
        String rich = "<p>2016年12月1日~2017年2月10日期间，成交携程任意产品2"
            + "单及以上用户，即可领取“舒简日式棉麻拖鞋”兑换券一张，此券可至网易严选免费兑换棉麻拖鞋一份，"
            + "点击<a href=\"https://pages.ctrip.com/commerce/rk/wb/201701/txd.jpg\">"
            + "查看详情&gt;&gt;</a></p><p style=\"white-space: normal;\">"
            + "<img src=\"https://pages.c-ctrip.com/commerce/rk/2017/07/cj670.jpg\"/></p><p style=\"white-space: normal;\">"
            + "1、该兑换码需登录携程账号后兑换使用，一经兑换，无法修改权益账号，敬请留意当前登录账号。暂无携程账号的用户需先注册再领取使用兑换码；"
            + " &nbsp;</p><p style=\"white-space: normal;\">2、用户可在携程旅行APP-“我的“-“超级会员”页面中登录使用权益；"
            + "用户在首次登录超级会员时需绑定指定乘机人；</p><p style=\"white-space: normal;\">3、每位用户仅限使用一个兑换码，每个兑换码仅限使用一次。"
            + "</p><p><a href=\"https://pages.ctrip.com/commerce/rk/wb/201701/txd.jpg\"></a><br/></p>";
        s = rich;
        //匹配规则
        // 1、过滤所有的<>标签
        String reg = "<([^>]*)>|&nbsp;|&gt;";
        // 要验证的字符串
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(s);
        //替换第一个符合正则的数据
        String pure = matcher.replaceAll("");
        System.out.println(pure);


    }

    public static void compareWithMultiField(List<User> userList) {
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return new CompareToBuilder()
                    .append(u1.getAge(), u2.getAge())
                    .append(u1.getWeight(), u2.getWeight()).toComparison();
            }
        });
    }

    public static List<User> userFactory() {
        List<User> list = new ArrayList<User>();
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();
        u1.setAge(8);
        u2.setAge(9);
        u3.setAge(8);

        u1.setLevel(1);
        u2.setLevel(1);
        u3.setLevel(4);

        u1.setWeight(4);
        u2.setWeight(3);
        u3.setWeight(2);

        list.add(u1);
        list.add(u2);
        list.add(u3);
        return list;
    }

    public static void split() {
        String str = "|wechat|h5";
        char separator = '|';
        List<String> list = Splitter.on(separator).omitEmptyStrings().splitToList(str);
        for (String s : list) {
            System.out.print(s);
        }
    }

    public static User empty() {
        User user = new User();
        user.setWeight(null);
        user.setLevel(1);
        return user;
    }

    public static void sort(List<Long> list) {
        Collections.sort(list, new Comparator<Long>() {
            @Override
            public int compare(Long right1, Long right2) {
                return (int) (right1 - right2); //降序
            }
        });
    }

    public static void enumTest(String platform) {
        if (PlatformEnum.WECHAT.toString().equalsIgnoreCase(platform)) {
            System.out.println(PlatformEnum.WECHAT.toString());
        }
        System.out.println(platform);
    }

    public static void dayTest(LocalDate someDay) {
        LocalTime t1 = new LocalTime();
        DateTime d1 = someDay.toDateTime(t1);
        System.out.println(d1);
    }

    public static void stopwatchTest() {
        Stopwatch stopWatch = Stopwatch.createStarted();
        System.out.println(stopWatch.elapsed(TimeUnit.MICROSECONDS));
        stopWatch.start();
        System.out.println(stopWatch.elapsed(TimeUnit.MILLISECONDS));
        listTest();
        System.out.println(stopWatch.elapsed(TimeUnit.MICROSECONDS));
    }

    public static void listTest() {
        List<User> list = new ArrayList<User>();
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();
        u1.setAge(1);
        u2.setAge(1);
        u3.setAge(3);
        u1.setLevel(1);
        u2.setLevel(1);
        u3.setLevel(4);
        list.add(u1);
        list.add(u2);
        list.add(u3);
        for (User u : list) {
            System.out.println("u:" + u + ",age:" + u.getLevel() + ",level:" + u.getLevel());
        }
        User u4 = new User();
        u4.setAge(1);
        u4.setLevel(1);
        list.remove(u1);
        for (User u : list) {
            System.out.println("u:" + u + ",age:" + u.getLevel() + ",level:" + u.getLevel());
        }
        System.out.print(list.getClass());

        list.removeAll(list);
        System.out.print(list.getClass());
        for (User u : list) {
            System.out.println("u:" + u + ",age:" + u.getLevel() + ",level:" + u.getLevel());
        }
    }

    public static Integer g(int a) {
        return null;

    }

    public static String f(int a) {
        String res = "try";
        try {
            for (int i = 0; i < 5; i++) {
                if (i == 1) {
                    return String.valueOf(i);
                }
                if (i == 2) {
                    System.out.println(i);
                }
            }
            if (res.equalsIgnoreCase("try")) {
                res = "try2";
                return res;
            }
        } catch (Exception e) {

        } finally {
            res = "finally";

        }
        return res;
    }


}
