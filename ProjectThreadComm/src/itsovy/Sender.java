package itsovy;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable{
    private Data data;

    public Sender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("I'm starting !");
        String packets[] = numberGeneration();

        for(String packet : packets){
            data.send(packet);

            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000,3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String[] numberGeneration(){

        String[] array = new String[11];
        int[] array2 = new int[10];
        Random random = new Random();


        for(int i = 0; i<array2.length; i++){
            array2[i]=i+1;
            array[i] = String.valueOf(array2[i]);
        }

        int i = 0;

        while(i != 10) {
            int num =random.nextInt(10);
            int secondNum =random.nextInt(10);


            String temp = array[num];
            array[num] = array[secondNum];
            array[secondNum] = temp;
            i++;
        }
        array[10] = "Finish";
        return array;
    }
}