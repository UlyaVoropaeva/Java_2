package lesson_2_2;

import java.util.Random;

public class Main {

    /**
     * 1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
     * При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     * 2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
     * Если в каком-то элементе массива преобразование не удалось
     * (например, в ячейке лежит символ или текст вместо числа),
     * должно быть брошено исключение MyArrayDataException с детализацией,
     * в какой именно ячейке лежат неверные данные.
     * 3 В методе main() вызвать полученный метод,
     * обработать возможные исключения MyArraySizeException и MyArrayDataException
     * и вывести результат расчета (сумму элементов, при условии что подали на вход корректный массив).
     */

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        int massiveLength = 4;
        String[][] massive = new String[massiveLength][massiveLength];
        massive = randomMassiveString(massive);

        SumMassiveString sumMassiveString = new SumMassiveString(massive);
        try {
          System.out.println("Результат расчета: сумма элементов = "
                  + sumMassiveString.sumMassiveString(massive));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static String[][] randomMassiveString(String[][] massive) {

        Random r = new Random();
        String randomString = "01234567891234ыв";

        for (int i = 0; i < massive.length; i++) {
            for (int j = 0; j < massive.length; j++) {
                massive[i][j] = String.valueOf(randomString.charAt(r.nextInt(16)));
            }
        }
        return massive;
    }

}



