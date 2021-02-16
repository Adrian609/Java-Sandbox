package com.company.datastructuresandalgos;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        assertTrue("c", list.contains("c"));
        assertTrue("c", list.remove("c"));
        assertFalse("c", list.contains("c"));
        assertEquals(2, list.size());
    }
}
