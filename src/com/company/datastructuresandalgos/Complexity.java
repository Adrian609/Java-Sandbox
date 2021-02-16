package com.company.datastructuresandalgos;

import java.util.Arrays;

public class Complexity {
    // O(1)
    public static void printFirstElement(int[] arrayOfItems) {
        System.out.println(arrayOfItems[0]);
    }

    // O(n)
    public static void printAllItems(int[] arrayOfItems) {
        for (int item : arrayOfItems) {
            System.out.println(item);
        }
    }

    //O(N^2)
    public static void printAllPossibleOrderedPairs(int[] arrayOfItems) {
        for (int firstItem : arrayOfItems) {
            for (int secondItem : arrayOfItems) {
                int[] orderedPair = new int[]{firstItem, secondItem};
                System.out.println(Arrays.toString(orderedPair));
            }
        }
    }

    //O(N) + O(N) = O(N)
    public static void printAllItemsTwice(int[] theArray) {
        for (int item : theArray) {
            System.out.println(item);
        }
        for (int item : theArray) {
            System.out.println(item);
        }
    }
}
