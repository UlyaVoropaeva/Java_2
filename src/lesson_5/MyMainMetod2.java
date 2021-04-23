package lesson_5;

import java.util.Arrays;

public class MyMainMetod2 {


    private int half;
    private float[] arr;

    public  MyMainMetod2(float[] arr, int half){
        this.arr = arr;
        this.half=half;
    }

    public  void MyMainMetodArr2() {
        float[] a1 = new float[half];
        float[] a2 = new float[half];
        long time  = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, half);
        System.arraycopy(arr, half, a2, 0, half);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        thread1.start();
        thread2.start();

        System.arraycopy(a1, 0, arr, 0, half);
        System.arraycopy(a2, 0, arr, half,half);

        System.out.println("Время выполнения  метода MyMainMetod2 =" + (System.currentTimeMillis() - time));
    }

}
