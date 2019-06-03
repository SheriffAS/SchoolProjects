package itsovy;

import java.util.concurrent.ThreadLocalRandom;

public class Reciever implements Runnable{

    private Data load;

    public Reciever(Data load) {
        this.load = load;
    }


    @Override
    public void run() {
        for (String receivedMessage = load.receive();
             !"Finish".equals(receivedMessage);
             receivedMessage = load.receive()){

            System.out.println(receivedMessage);

            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000,3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
