package com.enzo.collection;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author c_fu
 * @date 2017/11/7
 * @time 12:19
 */
public class User {

    int age;
    int level;
    Integer weight;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public static void main(String[] args) {
        String str = "1234567891"; //true
        System.out.println(isNumeric(str));

         str = "123a5678910"; //true
        System.out.println(isNumeric(str));
        str = "-123";   //true
        System.out.println(isNumeric(str));

        str = "abc";    //false
        System.out.println(isNumeric(str));

    }

    //@ author: walker
    //用正则表达式判断字符串是否为数字（含负数）
    public static boolean isNumeric(String str) {
        String regEx = "^1[0-9]{10}$";
        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(str);
        return mat.matches();
    }
}
