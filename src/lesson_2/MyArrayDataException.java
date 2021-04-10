package lesson_2;

import static java.lang.String.*;

public class MyArrayDataException extends Exception{

        private int indexI;
        private int indexJ;
        String s;

    public MyArrayDataException(int indexI, int indexJ, int parseInt) {
        super();

    }

    public int getIndexI() {
            return indexI;
        }

        public int getIndexJ() {
        return indexJ;
        }

    public String getS() {
        return s;
    }


    public MyArrayDataException (int indexI, int indexJ, String s) {
            super("Преобразование не удалось выполнить: в ячейке "+ " ("+ indexI+ " , "+ indexJ+" ) "+" лежит символ или текст '' " + s + " '' вместо числа");
            this.indexI = indexI;
            this.indexJ = indexJ;
            this.s = s;
        }

}
