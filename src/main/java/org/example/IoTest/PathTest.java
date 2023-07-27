package org.example.IoTest;

import java.io.File;

/**
 * @author : twave
 * @date : 2023/7/18 10:01
 */
public class PathTest {
    public static void main(String[] args) {
        String path = PathTest.class.getResource("").getPath();
        String parentPath = new File(path).getParent();
        parentPath = new File(parentPath).getParent();
        parentPath = new File(parentPath).getParent();
        System.out.println(parentPath);
    }
}
