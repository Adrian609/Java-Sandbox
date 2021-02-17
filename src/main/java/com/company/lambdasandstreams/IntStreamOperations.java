package com.company.lambdasandstreams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamOperations {

    public static void main(String[] args) {
        int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};
        int[] arrayOfEvenElements = evenElements(values);
        int[] sortedOddValues = sortedOddValuesPower10(values);
        int[] summaryStats;
        int sum = IntStream.of(values).sum();
        int max = IntStream.of(values).max().getAsInt();
        int min = IntStream.of(values).min().getAsInt();
        long count = IntStream.of(values).count();
        summaryStats = new int[]{sum, max, min, ((int) count)};
        double average = (int) IntStream.of(values).average().orElse(Double.MIN_VALUE);
        Map<String, Integer> givenMap = getStringIntegerMap(values, sum, max, min, (int) count, average);
        Map<String, Integer> mapKeySorted = getSortedMapKey(givenMap, Map.Entry.comparingByKey());
        Map<String, Integer> mapKeySortDesc = getSortedMapKey(givenMap, Map.Entry.comparingByKey(Comparator.reverseOrder()));
        Map<String, Integer> mapValueSorted = getSortedMapKey(givenMap, Map.Entry.comparingByValue());
        Map<String, Integer> mapValueSortDesc = getSortedMapKey(givenMap, Map.Entry.comparingByValue(Comparator.reverseOrder()));

        givenMap.forEach((key, val) -> {
            putInMap(givenMap, key, givenMap.get(key));
        });

        printMaps(givenMap, mapKeySorted, mapValueSorted, mapValueSortDesc, mapKeySortDesc);
        printVariables(values);
        printArrays(values, arrayOfEvenElements, sortedOddValues, summaryStats);
    }

    private static Map<String, Integer> getSortedMapKey(Map<String, Integer> givenMap, Comparator<Map.Entry<String, Integer>> entryComparator) {
        return givenMap.entrySet().stream().sorted(entryComparator).collect(Collectors.toMap(
                Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    private static int[] sortedOddValuesPower10(int[] array) {
        return IntStream.of(array).filter(value -> value % 2 == 1).map(value -> value * 10).sorted().toArray();
    }

    private static Map<String, Integer> putInMap(Map<String, Integer> map, String key, int val) {
        map.put(key, val);
        return map;
    }

    private static int[] evenElements(int[] array) {
        return IntStream.of(array).filter(element -> element % 2 == 0).sorted().toArray();
    }

    private static void printArrays(int[] values, int[] arrayOfEvenElements, int[] sortedOddValues, int[] summaryStats) {
        printList("Original values: ", values);
        printList("Sum of squares using the reduce method: ", IntStream.of(values).reduce(0, (x, y) -> x + y * y));
        printList("Product using the reduce method: ", IntStream.of(values).reduce(1, (x, y) -> x * y));
        printList("arrayOfEvenElements: ", arrayOfEvenElements);
        printList("Even elements", evenElements(values));
        printList("values: ", values);
        printList("Sorted odd values to the Power of 10: ", sortedOddValues);
        printList("summaryStats: ", summaryStats);
    }

    private static void printVariables(int[] values) {
        if (IntStream.of(values).min().isEmpty() || IntStream.of(values).average().isEmpty()) {
            return;
        }
        printList("Count: ", IntStream.of(values).count());
        printList("Min: ", IntStream.of(values).min().orElse(Integer.MIN_VALUE));
        printList("Max: ", IntStream.of(values).max().getAsInt());
        printList("Sum: ", IntStream.of(values).sum());
        printList("Average: ", IntStream.of(values).average().orElse(Double.MIN_VALUE));
    }

    private static void printMaps(Map<String, Integer> givenMap, Map<String, Integer> mapKeySorted, Map<String, Integer> mapValueSorted, Map<String, Integer> mapValueSortDesc, Map<String, Integer> mapKeySortDesc) {
        printList("givenMap: ", givenMap);
        printList("Sorted by key: ", mapKeySorted);
        printList("Sorted by key: ", mapKeySorted);
        printList("mapValueSorted: ", mapValueSorted);
        printList("mapValueSortDesc: ", mapValueSortDesc);
        printList("mapKeySortDesc: ", mapKeySortDesc);
    }

    private static Map<String, Integer> getStringIntegerMap(int[] values, int sum, int max, int min, int count, double average) {
        Map<String, Integer> createMap = new HashMap<>();
        createMap.put("sum", sum);
        createMap.put("max", max);
        createMap.put("min", min);
        createMap.put("count", count);
        createMap.put("average", (int) IntStream.of(values).average().orElse(Double.MIN_VALUE));
        return createMap;
    }

    private static void printList(String message, Map<String, Integer> map) {
        System.out.println(message);
        System.out.printf("%s ", map);
        System.out.println();
    }

    private static void printList(String message, double asDouble) {
        System.out.println(message);
        System.out.printf("%s ", asDouble);
        System.out.println();
    }

    private static void printList(String message, long count) {
        System.out.println(message);
        System.out.print(count);
        System.out.println();
    }

    private static void printList(String message, int[] array) {
        System.out.println(message);
        Arrays.stream(array).forEach(element -> System.out.printf("%s ", element));
        System.out.println();
    }

    private static void printList(String message, int value) {
        System.out.println(message);
        System.out.printf("%s ", value);
        System.out.println();
    }

    private static void printList(String array) {
        System.out.printf("%s ", array.toLowerCase());
    }
}
