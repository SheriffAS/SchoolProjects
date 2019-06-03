package itsovy;

public class Data {
    private String packet;

    private boolean transfer = true;
    // True if receiver should wait,False if sender should wait

    public synchronized void send(String packet) {
        while(!transfer){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        transfer =false;

        this.packet = packet;
        notifyAll();
    }

    public synchronized String receive() {
        while(transfer){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        transfer = true;

        notifyAll();
        return packet;
    }
}
