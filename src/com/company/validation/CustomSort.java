package com.company.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Result2 {
    public static int moves(List<Integer> arr) {
        // Write your code here

        List<Integer> temp = new ArrayList<>(arr);
        int[] intArr = new int[temp.size()];
        int count = 0;

        for (int element : temp) {
            intArr[count] = element;
            count++;
        }
        int numberOfMoves = 0;
        int firstEven = findFirstEven(temp);
        int firstOdd = findFirstOdd(temp);
        System.out.println("Before:" + temp);

        numberOfMoves += swapElementIndexes(temp, firstEven, firstOdd, numberOfMoves);

        if (findFirstEven(temp) <= temp.size() / 2 + 1) {
            firstEven = findFirstEven(temp);
            firstOdd = findFirstOdd(temp);
            numberOfMoves += swapElementIndexes(temp, firstEven, firstOdd, numberOfMoves);
        }
        System.out.printf("After: %s, Moves: %s%n", temp, numberOfMoves);
        return moves(temp);
    }

    private static int findFirstOdd(List<Integer> tempList) {
        int counter = 0;
        for (int num : tempList) {
            if (num % 2 == 1) {
                return counter;
            }
            counter++;
        }
        return counter;
    }

    private static int findFirstEven(List<Integer> tempList) {
        int[] intArr = new int[tempList.size()];
        int count = 0;
        for (int element : tempList) {
            intArr[count] = element;
            count++;
        }
        int tempInt = 0;

        for (int i = intArr.length - 1; i >= 0; i--) {
            if (intArr[i] % 2 == 0) {
                tempInt = i;
            }
        }
        return tempInt;
    }

    private static int swapElementIndexes(List<Integer> temp, int firstEven, int firstOdd, int numberOfMoves) {
        Collections.swap(temp, firstOdd, firstEven);
        System.out.printf("Swap: %s, Moves: %s%n", temp, numberOfMoves);
        return numberOfMoves + 1;
    }
}

public class CustomSort {
    public static void main(String[] args) {
//        Result2.moves(Arrays.asList(13, 10, 21, 20));
        Result2.moves(Arrays.asList(8, 5, 11, 4, 6));
    }
}
