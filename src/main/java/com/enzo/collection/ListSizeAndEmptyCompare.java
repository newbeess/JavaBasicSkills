package com.enzo.collection;


import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * 判断List中是否存在元素时，list.size()>0和!list.isEmpty()都可以 但当list数据量变大时，两者的性能却不一样。
 *
 * List中常用函数： Size 和 isEmpty 性能比较
 */
public class ListSizeAndEmptyCompare {

  public static void main(String[] args) {
  String a="a";
    String b="a";
    System.out.println(a==b);
//    String a = "a";
//    System.out.println(a.equals("a"));
//    System.out.println(a == "a");


//    ListSizeAndEmptyCompare a=new ListSizeAndEmptyCompare();
//    System.out.println(ListSizeAndEmptyCompare.class.isAssignableFrom(a.getClass()));
//    ListSizeAndEmptyCompare listSizeAndEmptyCompare = new ListSizeAndEmptyCompare();
////    listSizeAndEmptyCompare.Compare(10000);
//String a="0123";
//    System.out.println(a.substring(0,a.length()-1));
//
//    StringBuffer b=new StringBuffer("0123");
//    System.out.println(b.substring(0,b.length()-1));
//    String a = "";
//    String b = "  ";
//    String c = new String();
////    String d = "s";
//    System.out.println(a.equals(" "));
//    if (!StringUtils.isBlank(a)) {
//      System.out.println("a");
//    }
//    if (!StringUtils.isBlank(b)) {
//      System.out.println("b");
//    }
//    if (!StringUtils.isBlank(c)) {
//      System.out.println("c");
//    }
////    if (!StringUtils.isBlank(d)) {
////      System.out.println("d");
////    }
//    System.out.println("============");
//    if (!StringUtils.isEmpty(a)) {
//      System.out.println("a");
//    }
//    if (!StringUtils.isEmpty(b)) {
//      System.out.println("b");
//    }
//    if (!StringUtils.isEmpty(c)) {
//      System.out.println("c");
//    }
//    if (!StringUtils.isEmpty(d)) {
//      System.out.println("d");
//    }
  }



}
