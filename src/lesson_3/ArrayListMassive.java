package lesson_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayListMassive {

    private HashMap<Object, Integer> newList = new HashMap<Object, Integer>();
    private List<String> list = new ArrayList<>();

    public ArrayListMassive(List<String> list){
        this.list=list;
    }

    public String NumberWordsArray (List<String> list){

        for (String lis : list) {
            int k = 0;
            for (int i = list.size() - 1; i >= list.indexOf(lis); i--) {
                if (lis.equals(list.get(i))) {
                    newList.put(list.get(i), k + 1);
                    k += 1;
                }
            }
        }
        return newList.toString();
    }
    public void ListUniqueWords (){

        for (Map.Entry<Object, Integer> pair : newList.entrySet())
            if (pair.getValue() == 1) {
                System.out.println((String) pair.getKey());
            }
    }
}
