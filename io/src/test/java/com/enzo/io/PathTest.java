package com.enzo.io;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

/**
 * Path类API方法使用
 */
public class PathTest {

  //文件目录
  private static final String ABS_DIR = "D:/Github/javabasicskills/README.md";
  private static final String REL_DIE = "../README.md";

  /**
   * 获取Path路径的基本信息
   */
  @Test
  public void getPathInfo() {
    Path absolutePath = Paths.get(ABS_DIR);
    // 目录层级
    System.out.printf("该目录下一共有%s个文件\r\n", absolutePath.getNameCount());
    for (int i = 0; i < absolutePath.getNameCount(); i++) {
      System.out.printf("    第%d层目录名称为%s\r\n", i + 1, absolutePath.getName(i));
    }
    // 父目录
    System.out.printf("父目录为：%s\r\n", absolutePath.getParent().toString());
    // 根目录
    System.out.printf("根目录：%s\r\n", absolutePath.getRoot().toString());
    // 子路径
    System.out.printf("子路径：%s\r\n", absolutePath.subpath(0, 3));
  }

  /**
   * 移除路径中多余的点
   */
  @Test
  public void removePathRedundancy() {
    Path relPath = Paths.get(REL_DIE);
    try {
      System.out.println(relPath.toAbsolutePath());
      System.out.println(relPath.normalize());
      System.out.println(relPath.toRealPath());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 链接路径
   */
  @Test
  public void joinPath() {
    Path prefix = Paths.get("/C/");
    Path completePath = prefix.resolve("./README.md");
    System.out.println(completePath.toString());
    System.out.printf("已%s开始%s:\r\n", prefix.toString(), completePath.startsWith(prefix));
  }


}
