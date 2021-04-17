package lesson_3;

import java.io.PrintStream;
import java.util.*;

public class Main {


    /**
     * 1	Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
     * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
     * Посчитать, сколько раз встречается каждое слово.
     * <p>
     * 2	Написать простой класс Телефонный Справочник,
     * который хранит в себе список фамилий и телефонных номеров.
     * В этот телефонный справочник с помощью метода add() можно добавлять записи,
     * а с помощью метода get() искать номер телефона по фамилии.
     * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
     * тогда при запросе такой фамилии должны выводиться все телефоны.
     * Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
     * взаимодействие с пользователем через консоль и т.д).
     * Консоль использовать только для вывода результатов проверки телефонного справочника.
     */
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList(
                "назначение", "обработка", "пример", "реализация", "применение",
                "вставка", "принцип", "пример", "назначение",
                "вставка", "описание", "недостатки", "метод", "пример",
                "принцип", "вставка", "пример", "активизация", "метод"));
        ArrayListMassive arrayListMassive = new ArrayListMassive(list);
        System.out.println("Информация: сколько раз встречается каждое слово:");
        System.out.println(arrayListMassive.NumberWordsArray(list));
        System.out.println("Список уникальных слов, из которых состоит массив (дубликаты не считаем):");
        arrayListMassive.ListUniqueWords();


        PhoneDirectory phoneDirectory = new PhoneDirectory();

        phoneDirectory.add("Ivanov", "+7123456");
        phoneDirectory.add("Petrov", "+7456789");
        phoneDirectory.add("Sidorov", "+7789123");
        phoneDirectory.add("Ivanov", "+7147852");
        phoneDirectory.add("Ivanov", "+7852369");
        phoneDirectory.add("Sidorov", "+7123123");

        System.out.println("Список всех номеров в телефонной книге:");
        phoneDirectory.toStringArr();
        System.out.println("Поиск номера телефона по фамилии:");
        phoneDirectory.get("Ivanov");
        phoneDirectory.get("Sidorov");

    }


}



