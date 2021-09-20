/*package com.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class amazon {

    public static void main(String[] args) {
        Map<String, pairInt> items = new HashMap<>();
        String[] keys = new String[items.size()];
        int[] value1 = new int[items.size()];
        int[] value2 = new int[items.size()];
        int index = 0;
        for (Map.Entry<String, pairInt> mapEntry : items.entrySet()) {
            keys[index] = mapEntry.getKey();
            value1[index] = mapEntry.getValue().first;
            value2[index]= mapEntry.getValue().second;
            index++;
        }

        //   Sort
        if(sortOrder == 0){
        if( sortParameter == 1 )
            selectionSort0(value1, keys);
        else if( sortParameter == 2)
            selectionSort0(value2, keys);
        else if( sortParameter == 0)
            selectionSort0(keys);}
        else if( sortOrder == 1)
        {
            if( sortParameter == 1 )
                selectionSort1(value1, keys);
            else if( sortParameter == 2)
                selectionSort1(value2, keys);
            else if( sortParameter == 0)
                selectionSort1(keys);
                }

        List<String> itemList = new ArrayList<>();

        int itemtodisplay = itemsPerPage * PageNumeber ;
        int limit  = itemtodisplay + itemPerPage;
        while( itemtodisplay < limit && itemtodisplay < keys.length);
            {
                itemList.add(keys[itemtodisplay++]);
            }
        return itemList;
    }


    static void selectionSort0(int array[], String[] str) {
        int size = array.length;

        for (int step = 0; step < size - 1; step++) {
            int min_idx = step;

            for (int i = step + 1; i < size; i++) {

                // To sort in descending order, change > to < in this line.
                // Select the minimum element in each loop.
                if (array[i] < array[min_idx]) {
                    min_idx = i;
                }
            }

            // put min at the correct position
            int temp = array[step];
            array[step] = array[min_idx];
            array[min_idx] = temp;

            String s = str[step];
            str[step] = str[min_idx];
            str[min_idx] = s;
        }
    }


    static void selectionSort1(int array[], String[] str) {
        int size = array.length;

        for (int step = 0; step < size - 1; step++) {
            int min_idx = step;

            for (int i = step + 1; i < size; i++) {

                // To sort in descending order, change > to < in this line.
                // Select the minimum element in each loop.
                if (array[i] > array[min_idx]) {
                    min_idx = i;
                }
            }

            // put min at the correct position
            int temp = array[step];
            array[step] = array[min_idx];
            array[min_idx] = temp;

            String s = str[step];
            str[step] = str[min_idx];
            str[min_idx] = s;
        }
    }

    static void selectionSort0(String array[]) {
        int size = array.length;

        for (int step = 0; step < size - 1; step++) {
            int min_idx = step;
            for (int i = step + 1; i < size; i++) {
                // To sort in descending order, change > to < in this line.
                // Select the minimum element in each loop.
                if (array[i].compareTo(array[min_idx]) < 0) {
                    min_idx = i;
                }
            }
            // put min at the correct position
            String temp = array[step];
            array[step] = array[min_idx];
            array[min_idx] = temp;
        }
    }

    static void selectionSort1(String array[]) {
        int size = array.length;

        for (int step = 0; step < size - 1; step++) {
            int min_idx = step;

            for (int i = step + 1; i < size; i++) {
                // To sort in descending order, change > to < in this line.
                // Select the minimum element in each loop.
                if (array[i].compareTo(array[min_idx]) > 0) {
                    min_idx = i;
                }
            }
            // put min at the correct position
            String temp = array[step];
            array[step] = array[min_idx];
            array[min_idx] = temp;
        }
    }
}

class pairInt{
    int first;
    int second;

}
*/