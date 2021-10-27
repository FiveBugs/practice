package dto;

import java.util.concurrent.TimeUnit;

public class Phone {
    public synchronized void sendEmail() throws Exception{
        TimeUnit.SECONDS.sleep(2);
        System.out.println("*****sendEmail");
    }

    public synchronized void sendSMS() {
        System.out.println("*****sendSMS");
    }
}
