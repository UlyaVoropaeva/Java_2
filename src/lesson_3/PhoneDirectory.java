package lesson_3;

import java.util.*;


public class PhoneDirectory {

    private HashMap<String, Set<String>> phone = new HashMap<>();
    private String name;
    private String number;

    public void add(String name, String number) {
        Set<String> list = new HashSet<>();
        this.number = number;
        this.name = name;
        int k = 0;

        for (Map.Entry<String, Set<String>> entry : phone.entrySet()) {
            if (Objects.equals(name, entry.getKey())) {
                list.addAll(entry.setValue(Collections.singleton(entry.getKey())));
                list.add(number);
                phone.put(name, list);
                k = 1;
            }
        }
        if (k == 0) {
            phone.put(name, Collections.singleton(number));
        }
    }


    public void get(String name) {
        for (Map.Entry<String, Set<String>> entry : phone.entrySet()) {
            if (Objects.equals(name, entry.getKey())) {
                System.out.println("Фамилия: " + entry.getKey() + " Номер телефона: " + entry.toString());
            }
        }
    }

    public String toString() {
        return "Фамилия: " + name + " Номер телефона: " + number;
    }

    public void toStringArr() {
        for (Map.Entry<String, Set<String>> entry : phone.entrySet()) {
            System.out.println("Фамилия: " + entry.getKey() + " Номер телефона: " + entry.getValue());
        }
    }
}

