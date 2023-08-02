package org.example.Learning.proxyStudy;

public class SmsServiceImpl implements SmsService {

    /**
     * @param message
     * @return
     */
    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
