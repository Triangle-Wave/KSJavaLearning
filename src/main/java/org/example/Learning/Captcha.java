package org.example.Learning;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @author TWAVE
 * @date 2023/6/7 8:52
 */
public class Captcha {
    public static void main(String[] args) throws IOException {
        // 验证码图片
        ByteArrayInputStream image;
        // 验证码对应的字符串
        StringBuffer captcha = new StringBuffer();
        // 验证码的宽度和高度
        int width = 350, height = 46;
        // 生成验证码
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        // 随机设置背景颜色
        graphics.setColor(getRandomColor(100, 250));
        graphics.fillRect(0, 0, width, height);
        Random random = new Random();
        // 设置字体
        // Font.PLAIN：普通样式常量
        graphics.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        // 随机产生数字
        for (int i = 0; i < 6; i++) {
            captcha.append(random.nextInt(10));
            graphics.setColor(getRandomColor(20, 90));
        }
        // 绘制字符串
        // x：绘制字符串的x坐标, y：绘制字符串的y坐标
        graphics.drawString(captcha.toString(), 20, 40);
        graphics.dispose();
        ByteArrayInputStream byteArrayInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // try {
        //     ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(byteArrayOutputStream);
        //     ImageIO.write(bufferedImage, "JPEG", imageOutputStream);
        //     imageOutputStream.close();
        //     byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        // } catch (Exception e) {
        //     System.out.println("图片生成失败");
        // }
        File outputFile = new File("captcha.jpg");
        ImageIO.write(bufferedImage, "JPEG", outputFile);
    }

    private static Color getRandomColor(int i1, int i2) {
        // 生成一个随机类，用于生成随机数字
        Random random = new Random();
        // 生成随机数字并返回
        // random.nextInt的功能是生成一个随机的int值，范围是[0, i2 - i1)，+i1则范围是[i1, i2)
        return new Color(random.nextInt(i2 - i1) + i1, random.nextInt(i2 - i1) + i1, random.nextInt(i2 - i1) + i1);
    }
}
