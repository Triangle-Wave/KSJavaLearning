package org.example.S0719;

/**
 * @author TWAVE
 */
public class Test implements Runnable {
    // public static void main(String[ ] args) throws IOException {
    //     String str = "Hello World";
    //     FileWriter fw = null;
    //     try {
    //         fw = new FileWriter("c:\\hello.txt"); // 1
    //         fw.write(str); // 2
    //     } catch (IOException e) {
    //         e.printStackTrace(); // 3
    //     } finally {
    //         fw.close(); // 4
    //     }
    // }
    public void run() {
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        Test test = new Test();
        Thread thread = new Thread(test);
        thread.start();
    }
}