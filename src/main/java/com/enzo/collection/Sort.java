package com.enzo.collection;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * @author c_fu
 * @date 2017/11/7
 * @time 12:18
 */
public class Sort {

    public static void main(String[] args) {
//        User u1 = new User();
//        u1.setAge(2);
//        u1.setLevel(2);
//        User u2 = new User();
//        u2.setAge(1);
//        u2.setLevel(5);
//        User u3 = new User();
//        u3.setAge(3);
//        u3.setLevel(1);
//        User u4=new User();
//        u4.setAge(1);
//        u4.setLevel(1);
//        User u5=new User();
//        u5.setAge(5);
//        u5.setLevel(5);
//        List<User> list = new ArrayList<>();
//        list.add(u1);
//        list.add(u2);
//        list.add(u3);
//        list.add(u4);
//        list.add(u5);
//        for (User u :list){
//            System.out.println(u.getAge() + ",,,," + u.getLevel());
//        }
//        User user=new User();
//        user.setLevel(2);
//        user.setAge(2);
//        User user1=new User();
//        user1.setAge(100);
//        user1.setLevel(100);
//        System.out.println(Collections.replaceAll(list,user,user1));
//
////        Collections.sort(list, new Comparator<User>() {
////            @Override
////            public int compare(User o1, User o2) {
////                return (o1.getAge() * o1.getLevel()) - (o2.getAge() * o2.getLevel());
////            }
////        });
//        for (User u : list) {
//            System.out.println(u.getAge() + ",,,," + u.getLevel());
//        }
        Calendar currentDay=Calendar.getInstance();
        currentDay.setTime(new Date());
        currentDay.set(Calendar.HOUR_OF_DAY,0);
        currentDay.set(Calendar.MINUTE,0);
        currentDay.set(Calendar.SECOND,0);
        currentDay.add(Calendar.DAY_OF_YEAR,2);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentDay.getTime()));


    }

    public static Integer getRandomTimeCardId() {
        Integer randomId = 0;
        try {
            throw new Exception();
        } catch (Exception e) {
        }
        System.out.println("======");
        return randomId;
    }


}
