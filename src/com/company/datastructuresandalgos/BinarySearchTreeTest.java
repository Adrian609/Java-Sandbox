package com.company.datastructuresandalgos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {
    @Test
    @DisplayName("Should be true")
    public void testBST() {
        //given
        BinarySearchTree b = new BinarySearchTree();

        //when
        b.insert(3);
        b.insert(8);
        b.insert(1);
        b.insert(4);
        b.insert(6);
        b.insert(2);
        b.insert(10);
        b.insert(9);
        b.insert(20);
        b.insert(25);
        b.insert(15);
        b.insert(16);

        //then
        List<Integer> result = b.getInOrder();

        assertTrue(result.containsAll(Arrays.asList(1, 2, 3, 4, 6, 8, 9, 10, 15, 16, 20, 25)));
        assertFalse(result.containsAll(Arrays.asList(1, 2, 3, 4, 6, 8, 9, 10, 15, 16, 5, 25)));
        assertTrue(b.find(4));
        assertFalse(b.find(100));
    }

    @Test
    public void testBSTDelete() {
        //given
        BinarySearchTree b = new BinarySearchTree();

        //when
        b.insert(3);
        b.insert(8);
        b.insert(1);
        b.insert(4);
        b.insert(6);
        b.insert(2);
        b.insert(10);
        b.insert(9);
        b.insert(20);
        b.insert(25);
        b.insert(15);
        b.insert(16);
        b.delete(10);

        //then
        List<Integer> result = b.getInOrder();
        assertTrue(result.containsAll(Arrays.asList(1, 2, 3, 4, 6, 8, 9, 15, 16, 20, 25)));
        assertTrue(b.find(4));
        assertFalse(b.find(100));

        //and when
        b.insert(10);
        b.delete(15);
        result = b.getInOrder();
        assertEquals(Arrays.asList(1, 2, 3, 4, 6, 8, 9, 10, 16, 20, 25), result);
    }

    @Test
    public void testBSTDeletionSimple() {
        //given
        BinarySearchTree b = new BinarySearchTree();

        //when
        b.insert(3);
        b.insert(8);
        b.insert(1);

        //then
        b.delete(8);
        List<Integer> results = b.getInOrder();
        assertTrue(results.containsAll(Arrays.asList(3, 1)));
        assertTrue(results.contains(1));
        assertTrue(results.contains(3));
        assertEquals(2, results.size());
        assertFalse(results.contains(8));
    }
}
