package org.example.S0719;

import java.io.*;

/**
 * @author : twave
 * @date : 2023/7/19 15:33
 */
public class TestBuffered {
    public static void main(String[] args) throws IOException {
        // Buffered是字符缓冲流，可以提高读写效率
        BufferedReader br = new BufferedReader(new FileReader("d:/bjsxt1.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("d:/bjsxt2.txt"));
        String str = br.readLine();
        while (str != null) {
            bw.write(str);
            bw.newLine();
            str = br.readLine();
        }
        br.close();
        bw.close();
    }
}
