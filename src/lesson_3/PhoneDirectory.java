package lesson_3;

import java.util.*;


public class PhoneDirectory  {

    private HashMap<Integer, String> map = new HashMap<>();
    private String name;
    private int number;

    public void add(int number, String name) {
        this.name = name;
        this.number = number;
        map.put(number, name);
    }

    public void get(String name) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (Objects.equals(name, entry.getValue())) {
                System.out.println("Фамилия: " + entry.getValue() + " Номер телефона: " + entry.getKey());
            }
        }
    }

    public String toString() {
        return "Фамилия: " + name + " Номер телефона: " + number;
    }

    public void toStringArr() {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Фамилия: " + entry.getValue() + " Номер телефона: " + entry.getKey());
        }
    }

}

