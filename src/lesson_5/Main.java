package lesson_5;

import java.util.Arrays;

public class Main {


    static final int size = 10000000;
    static final int half = size / 2;

    public static void main(String[] args) {

        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        MyMainMetod1 myMainMetod1 = new MyMainMetod1(arr);
        MyMainMetod2 myMainMetod2 = new MyMainMetod2(arr, half);

        myMainMetod1.MyMainMetodArr1();
        myMainMetod2.MyMainMetodArr2();

    }
}
