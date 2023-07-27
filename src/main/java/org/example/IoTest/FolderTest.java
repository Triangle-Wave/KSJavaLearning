package org.example.IoTest;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author : twave
 * @date : 2023/7/17 17:46
 */

public class FolderTest {
    /**
     * 使用缓冲流复制文件夹
     *
     * @param sourcePath 源文件路径
     * @param targetPath 目标文件路径
     * @throws IOException 可能抛出IO异常
     */
    private void copyFolder(String sourcePath, String targetPath) throws IOException {
        // 创建源File和目标File对象
        File src = new File(sourcePath);
        File target = new File(targetPath);

        // 判断源File是否是文件夹
        if (src.isDirectory()) {
            // 如果是文件夹
            // 判断目标文件夹是否存在
            if (!target.exists()) {
                // 如果目标文件夹不存在，先创建目标文件夹
                target.mkdirs();
            }
            // 获取源文件夹下的所有文件和文件夹
            String[] files = src.list();
            // 对于每一个文件或文件夹，递归调用copyFolder方法
            if (files != null) {
                for (String file : files) {
                    String srcFile = sourcePath + File.separator + file;
                    String destFile = targetPath + File.separator + file;
                    copyFolder(srcFile, destFile);
                }
            }
        } else {
            // 如果源File是文件
            // 使用try-with-resources语句创建缓冲流对象
            try (BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(src.toPath()));
                 BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(target.toPath()))) {
                // len是每次读取到的字节数量
                int len;
                // 定义一个字节数组，作为缓冲区
                byte[] buffer = new byte[1024];
                // 循环条件：只要能够读取到数据（字节数组长度不为-1），就一直循环
                while ((len = bis.read(buffer)) != -1) {
                    // 输出流将缓冲区的数据写入文件
                    bos.write(buffer, 0, len);
                }
            }
        }
    }

    public static void main(String[] args) {
        FolderTest folderTest = new FolderTest();
        String sourcePath = "F:\\MyProjects\\Test\\RuoYi";
        String targetPath = "F:\\MyProjects\\Test\\RuoYiCopy";
        try {
            folderTest.copyFolder(sourcePath, targetPath);
        } catch (IOException e) {
            System.out.println("复制失败");
        }
    }
}

