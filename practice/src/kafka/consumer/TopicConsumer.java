package kafka.consumer;

import kafka.service.ReceiveInfoService;

public class TopicConsumer {
    public static void main(String[] args) {
        ReceiveInfoService receiveInfoService = new ReceiveInfoService();

        Thread thread = new Thread(receiveInfoService);

        thread.start();
    }
}
