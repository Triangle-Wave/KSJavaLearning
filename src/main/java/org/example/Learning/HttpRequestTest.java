package org.example.Learning;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author TWAVE
 */
public class HttpRequestTest {
    public static void main(String[] args) throws Exception {
        // 指定URL
        String url = "https://www.baidu.com/";

        // 创建URL对象
        URL apiUrl = new URL(url);

        // 创建HttpURLConnection对象
        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

        // 设置请求方法
        connection.setRequestMethod("GET");

        // 发送请求
        int responseCode = connection.getResponseCode();

        // 读取响应结果
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // 输出响应结果
        System.out.println("Response Code: " + responseCode);
        System.out.println("Response Body: " + response);

        // 关闭连接
        connection.disconnect();
    }
}
