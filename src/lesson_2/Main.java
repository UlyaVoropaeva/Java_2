package lesson_2;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.*;

public class Main {

    /**
     * 1	Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
     * При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     * 2	Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
     * Если в каком-то элементе массива преобразование не удалось
     * (например, в ячейке лежит символ или текст вместо числа),
     * должно быть брошено исключение MyArrayDataException с детализацией,
     * в какой именно ячейке лежат неверные данные.
     * 3	В методе main() вызвать полученный метод,
     * обработать возможные исключения MyArraySizeException и MyArrayDataException
     * и вывести результат расчета (сумму элементов, при условии что подали на вход корректный массив).
     */

    public static void main(String[] args) {

        // Scanner scanner = new Scanner(System.in);

        //System.out.println("Введите размер массива");
        //int massiveLength = scanner.nextInt();
        int massiveLength = 4;
        String[][] massive = new String[massiveLength][massiveLength];

        sumMassiveString(massive);

    }


    public static void sumMassiveString(String[][] massive) {

        int sum = 0;
        if (massive.length != 4) {
            try {
                throw new MyArraySizeException(massive);
            } catch (MyArraySizeException e) {
                e.printStackTrace();
            }
        } else {
            massive = randomMassiveString(massive);
            for (int i = 0; i < massive.length; i++) {
                for (int j = 0; j < massive.length; j++) {
                    if (!(massive[i][j]).matches("[-+]?\\d+")) try {
                        throw new MyArrayDataException(i, j, (massive[i][j]));
                    } catch (MyArrayDataException e) {
                        e.printStackTrace();
                    }
                    else
                        sum += Integer.parseInt(massive[i][j]);
                }
            }
            System.out.println("Результат расчета: сумму элементов = " + sum);
        }
    }

    public static String[][] randomMassiveString(String[][] massive) {

        Random r = new Random();
        String randomString = "0123456789abcdeF";

        for (int i = 0; i < massive.length; i++) {
            for (int j = 0; j < massive.length; j++) {
                massive[i][j] = String.valueOf(randomString.charAt(r.nextInt(16)));
            }
        }
        return massive;
    }

}