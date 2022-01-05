package com.spacex.data.structure.test;

import com.spacex.data.structure.list.CustomArrayList;
import com.spacex.data.structure.list.CustomList;

public class CustomArrayListTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        CustomList<Object> arrayList = new CustomArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add("Custom-Array-List-" + i);
        }

        System.out.println(arrayList);
        System.out.println(arrayList.size());
    }
}
