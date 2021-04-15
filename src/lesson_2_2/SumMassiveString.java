package lesson_2_2;

import java.util.Random;

public class SumMassiveString  {
    public SumMassiveString (String [][] massiv){

    }
    public int sumMassiveString(String[][] massive) throws MyArraySizeException, MyArrayDataException {


        int sum = 0;


        if (massive.length != 4) {
            try {
                throw new MyArraySizeException();
            } finally {
                System.out.println("Работа программы завершена с ошибками:");
            }
        }
        for (int i = 0; i < massive.length; i++) {
            for (int j = 0; j < massive.length; j++) {
                if (!(massive[i][j]).matches("[-+]?\\d+")) {

                try {

                    throw new MyArrayDataException(i, j, (massive[i][j]));

                }finally {
                       System.out.println("Работа программы завершена с ошибками:");
                    }
               } else
                    sum += Integer.parseInt(massive[i][j]);
            }}



        return  sum;
    }}