package org.example.FieldTest;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 利用反射给一个没有set方法的类的属性赋值
 *
 * @author : twave
 * @date : 2023/7/14 8:35
 */
public class FTest {
    private Student setStudent() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 返回一个Class对象，这个对象代表了Student类
        Class<?> clazz = Class.forName("org.example.FieldTest.Student");
        // 定义一个Student类的实例
        Object instance = clazz.newInstance();
        // 定义一个Map，用于保存属性的键值对
        Map<String, Object> fieldValues = new HashMap<>();
        fieldValues.put("name", "张三");
        fieldValues.put("age", 25);
        fieldValues.put("daySalary", 5000.0);
        // for循环的条件是使用Entry遍历Map，每次循环获取到一个条目
        // 赋值给entry
        for (Map.Entry<String, Object> entry : fieldValues.entrySet()) {
            String fieldName = entry.getKey();
            Object fieldValue = entry.getValue();
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(instance, fieldValue);
        }
        // instance是Object类型，需要强制转换为Student类型
        // 才能使用它的get方法
        return (Student) instance;
    }

    public static void main(String[] args) {
        FTest fTest = new FTest();
        try {
            Student student = fTest.setStudent();
            System.out.println(student.getName());
            System.out.println(student.getAge());
            System.out.println(student.getDaySalary());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
