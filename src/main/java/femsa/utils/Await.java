package femsa.utils;

import java.util.concurrent.CountDownLatch;

public class Await {


    public static void during(int milliseconds) {
        CountDownLatch latch = new CountDownLatch(1);
        try {
            latch.await();
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
    }

}
