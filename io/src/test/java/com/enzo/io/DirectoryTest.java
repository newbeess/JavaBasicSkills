package com.enzo.io;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 目录和目录树
 */
public class DirectoryTest {

  private static final String DIR = "D:/Github/javabasicskills/";
  private static final Logger log = LoggerFactory.getLogger(DirectoryTest.class);

  /**
   * 在某个目录中查找文件
   */
  @Test
  public void findFile() {
    Path path = Paths.get(DIR);
    log.info("路径Path{},{}", path.toString(), path.getFileName());
    try (DirectoryStream<Path> matchedPathList = Files.newDirectoryStream(path, "*.iml")) {
      for (Path matchedPath : matchedPathList) {
        System.out.println(matchedPath.getFileName());
      }
    } catch (IOException e) {
      log.error("过滤路径流异常", e);
    }
  }

  /**
   * 遍历目录树
   */
  @Test
  public void walkFileTree() throws IOException {
    Path path = Paths.get(DIR);
    Files.walkFileTree(path, new FindJavaVistor());
  }

  private static class FindJavaVistor extends SimpleFileVisitor {
    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
      Path filePath = (Path) file;
      if (filePath.toString().endsWith(".java")) {
        System.out.println((filePath));
      }
      return super.visitFile(file, attrs);
    }
  }
}
