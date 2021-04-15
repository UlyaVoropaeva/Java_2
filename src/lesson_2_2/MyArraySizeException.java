package lesson_2_2;

public class MyArraySizeException extends Exception{
    private int index;
    private int len = 4;

    public int getIndex() {
        return index;
    }

    public int getLen() {
        return len;
    }

    public MyArraySizeException() {
        super ("Двумерный строковый массив не соответствует размеру 4х4." );
    }
}
