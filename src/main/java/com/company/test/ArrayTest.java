package com.company.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayTest {

    @Test
    public void addingToArrayOnASpecificIndex() {
        //given
        int[] input = new int[10];

        //when
        input[0] = 1;
        input[9] = 199;

        //then lookup is O(1) - we dont need to iterate over the list
        assertEquals(199, input[9]);
    }

    @Test
    public void shouldAddElementToArrayList() {
        //given
        ArrayList<String> list = new ArrayList<>();

        //when
        list.add("a");

        //then
        assertEquals("a", list.get(0));

        //and when
        list.remove("a");
        assertEquals(0, list.size());
    }

    @Test
    public void shouldGetElementByIndex() {
        //given
        ArrayList<String> list = new ArrayList<>();

        //when
        list.add("a");
        list.add("b");
        list.add("c");

        //then
        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("c", list.get(2));
        assertTrue(list.contains("c"));
        assertTrue(list.remove("c"));
        assertFalse(list.contains("c"));
        assertEquals(2, list.size());
    }
}
