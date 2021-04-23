package lesson_5;

import java.util.Arrays;

public class MyMainMetod1 {
    private float[] arr;


    public MyMainMetod1(float[] arr) {
        this.arr = arr;
    }

    public void MyMainMetodArr1() {

        long time = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Время выполнения  метода MyMainMetod1 =" + (System.currentTimeMillis() - time));
    }

}
