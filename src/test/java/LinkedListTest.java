package com.company.test;

import com.company.datastructuresandalgos.CustomList;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LinkedListTest {

    @Test
    public void shouldAddElementToCustomList() {
        //Given
        CustomList<String> list = new CustomList<>();
        //when
        list.add("a");

        //then
        assertEquals(1, list.size());

        //and when
        list.add("b");
        list.add("c");
        list.add("d");

        //and then
        assertEquals("c", list.get(2));
    }

    @Test
    public void shouldRetrieveHeadAndTailOfCustomList() {
        //Given
        CustomList<String> list = new CustomList<>();

        //when
        list.add("a");
        list.add("b");

        //then
        assertEquals("a", list.peekFirst());
    }

    @Test
    public void shouldAddElementToList() {
        //Given
        LinkedList<String> list = new LinkedList<>();

        //when
        list.add("a");
        list.add("b");

        //then
        assertEquals(2, list.size());

        //and when
        list.remove("a");
        assertEquals(1, list.size());
    }

    @Test
    public void shouldRetrieveHeadAndTailOfList() {
        //given
        LinkedList<String> list = new LinkedList<>();

        //when
        list.add("a");
        list.add("b");

        //then
        assertEquals(2, list.size());
        assertEquals("a", list.peekFirst());
        assertEquals("b", list.peekLast());
    }
}
