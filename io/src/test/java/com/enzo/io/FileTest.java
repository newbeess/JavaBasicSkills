package com.enzo.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件的CRUD、属性
 */
public class FileTest {

  private static final Logger log = LoggerFactory.getLogger(FileTest.class);
  //文件目录
  private static final String ABS_DIR = "D:/Github/javabasicskills/create.md";

  private static final String TARGET_DIR = "D:/Github/javabasicskills/io/create.md";
  // POM文件的目录
  private static final String POM_DIR = "D:/Github/javabasicskills/pom.xml";
  private static final String README_DIR = "D:/Github/javabasicskills/README.md";
  /**
   * CRUD
   */
  @Test
  public void cRUDFile() {
    Path path = Paths.get(ABS_DIR);
    try {
      System.out.println("创建前目录下已.md结尾的文件：------");
      findFile();
      // 创建文件
      Files.createFile(path);
      System.out.println("创建后目录下已.md结尾的文件：------");
      findFile();
      System.out.println("删除后目录下已.md结尾的文件：------");
      // 删除文件
      Files.delete(path);
      findFile();
      // 复制文件
      Files.copy(Files.createFile(path), Paths.get(TARGET_DIR));
      System.out.println("创建并复制后目录下已.md结尾的文件：------");
      findFile();
      Files.delete(Paths.get(TARGET_DIR));
      Files.move(path, Paths.get(TARGET_DIR));
    } catch (IOException e) {
      log.error("文件操作异常", e);
    }
  }

  /**
   * 文件属性
   */
  @Test
  public void fileAttribute() throws IOException {
    Path path = Paths.get(POM_DIR);
    log.info("文件{}，最后修改时间{}",path.getFileName(),Files.getLastModifiedTime(path,new LinkOption[]{}));
    log.info("文件{},大小{}",path.getFileName(),Files.size(path));
    log.info("是否是目录：{}",Files.isDirectory(path));
    log.info("文件Owner:{}",Files.getOwner(path));
    log.info("文件属性：{}",Files.readAttributes(path,"*"));
  }

  @Test
  public void asyncOpetation() throws IOException {
    Path path = Paths.get(README_DIR);
    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    FileChannel channel = FileChannel.open(path, StandardOpenOption.READ);
  }

  private void findFile() {
    Path path = Paths.get(ABS_DIR).getRoot().resolve(Paths.get(ABS_DIR).subpath(0, 2));
    log.info("路径Path：{},文件名：{}", path.toString(), path.getFileName());
    try (DirectoryStream<Path> matchedPathList = Files.newDirectoryStream(path, "*.md")) {
      for (Path matchedPath : matchedPathList) {
        System.out.println(matchedPath.getFileName());
      }
    } catch (IOException e) {
      log.error("过滤路径流异常", e);
    }

  }

}
