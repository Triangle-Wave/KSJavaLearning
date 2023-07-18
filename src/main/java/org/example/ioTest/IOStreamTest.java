package org.example.ioTest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author : twave
 * @date : 2023/7/17 15:56
 */
public class IOStreamTest {
    /**
     * 使用文件流的方式进行文件复制
     *
     * @param sourcePath 源文件路径
     * @param targetPath 目标文件路径
     */
    private void copyByFileStream(String sourcePath, String targetPath) {
        // 使用文件流复制文件
        // 使用try-with-resources语句，自动关闭流
        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(targetPath)) {
            // len是每次读取到的字节长度
            int len;
            // 循环条件：只要能够读取到数据（字节长度不为-1），就一直循环
            while ((len = fis.read()) != -1) {
                // 将读取到的数据写入到输出流
                fos.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用缓冲流的方式进行文件复制
     *
     * @param sourcePath 源文件路径
     * @param targetPath 目标文件路径
     */
    private void copyByBufferStream(String sourcePath, String targetPath) {
        // 使用缓冲流复制文件
        // 使用try-with-resources语句，自动关闭流
        try (BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(Paths.get(sourcePath)));
             BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(Paths.get(targetPath)))) {
            // len是每次读取到的字节数量
            int len;
            // 定义一个缓冲区，大小是1024字节
            byte[] buffer = new byte[1024];
            // 循环条件：只要能够读取到数据（字节数组长度不为-1），就一直循环
            while ((len = bis.read(buffer)) != -1) {
                // 将缓冲区的数据写入到输出流
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IOStreamTest test = new IOStreamTest();
        // 记录开始时间，结束时间
        long startTime, endTime;
        // 计算时间间隔
        double duration;

        // 文件大小：147mb
        /* 缓冲流运行时间：0.368秒*/
        startTime = System.nanoTime();
        test.copyByBufferStream("F:\\MyProjects\\Test\\summer rain.wav", "F:\\MyProjects\\Test\\summer rain_buffer.wav");
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000000.0;
        System.out.println("缓冲流方法的运行时间: " + String.format("%.3f", duration) + " 秒");

        /*文件流运行时间：868.821秒*/
        startTime = System.nanoTime();
        test.copyByFileStream("F:\\MyProjects\\Test\\summer rain.wav", "F:\\MyProjects\\Test\\summer rain2.wav");
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000000.0;
        System.out.println("文件流方法的运行时间: " + String.format("%.3f", duration) + " 秒");
    }
}
