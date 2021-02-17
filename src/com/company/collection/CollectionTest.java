package com.company.collection;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) throws Exception {
        String[] colors = {"Magenta", "Red", "White", "Blue", "Cyan"};
        String[] colors2 = {"black", "Yellow", "green", "blue", "violet", "silver"};
        List<String> list = new ArrayList<>(Arrays.asList(colors));
        String[] removeColors = {"Red", "White", "Blue"};
        List<String> removeList = new ArrayList<>(Arrays.asList(removeColors));
        List<String> list1 = new LinkedList<>(Arrays.asList(colors));
        List<String> list2 = new LinkedList<>(Arrays.asList(colors2));

        System.out.println("Initial list: ");
        for (String s : list) {
            System.out.printf("%s ", s);
        }
        System.out.println();
        removeColors(list, removeList);

        System.out.println("After removing data from list: ");
        for (String s : list) {
            System.out.printf("%s ", s);
        }
        System.out.println();

        list1.addAll(list2);
        list2 = null;
        System.out.println("Print out linked list #1: ");
        printList(list1);

        System.out.println("Print out linked list #2: ");
        printList(list2);

        convertToUpperCase(list1);
        printList(list1);

        removeItems(list1, 4, 7);
        printList(list1);
        printReversedList(list1);

        System.out.println("Sorting list: ");
        Collections.sort(list1);
        printList(list1);

        System.out.println("Sorted Set: ");
        SortedSet<String> tree = new TreeSet<>(Arrays.asList(colors));
        printList(tree);

        System.out.println("Maps: ");
        Map<String, Integer> testMap = new HashMap<>();
        createMap(testMap);
        displayMap(testMap);
    }

    private static void displayMap(Map<String, Integer> map) {
        System.out.println(map);

        Set<String> keys = map.keySet();
        TreeSet<String> sortedKeys = new TreeSet<>(keys);

        System.out.println(sortedKeys);
    }

    private static void createMap(Map<String, Integer> map) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        String[] tokens = input.split(" ");

        for (String token : tokens) {
            String word = token.toLowerCase();
            if (map.containsKey(word)) {
                int count = map.get(word);
                map.put(word, count + 1);
            } else {
                map.put(word, 1);
            }
        }
    }

    private static void removeItems(List<String> list, int start, int end) {
        System.out.printf("%nDeleting elements %s to %s...\n", start, end);
        list.subList(start, end).clear();
    }

    private static void printReversedList(List<String> list) {
        System.out.println("Printing reversed list: ");
        ListIterator<String> iterator = list.listIterator(list.size());

        while (iterator.hasPrevious()) {
            System.out.printf("%s ", iterator.previous());
        }
        System.out.println();
    }

    private static void convertToUpperCase(List<String> list) {
        System.out.println("Printing to upper case: ");
        ListIterator<String> iterator = list.listIterator();

        while (iterator.hasNext()) {
            String color = iterator.next();
            iterator.set(color.toUpperCase());
        }
    }

    private static void printList(Collection<String> collection) throws Exception {
        if (collection == null) {
            System.out.println("Empty collection");
            return;
        }
        collection.forEach(color -> System.out.printf("%s, ", color));
        System.out.println();
    }

    private static void removeColors(Collection<String> collection1, Collection<String> collection2) {
        collection1.removeIf(collection2::contains);
        System.out.println();
    }
}
