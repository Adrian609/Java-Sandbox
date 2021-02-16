package com.company.datastructuresandalgos;

import org.junit.jupiter.api.Test;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    @Test
    public void shouldAddElementsToTheQueueAndRetrieveIt() {
        //given
        Queue<String> strings = new LinkedBlockingQueue<>();

        //when
        strings.offer("a");
        String element = strings.poll();

        //then
        assertEquals("a", element);
        assertTrue(strings.isEmpty());
    }

    @Test
    public void shouldAddElementsToTheQueueAndRetrieveItButNotDelete() {
        //given
        Queue<String> strings = new LinkedBlockingQueue<>();

        //when
        strings.offer("a");
        String element = strings.peek();

        //then
        assertEquals("a", element);
        assertFalse(strings.isEmpty());

        // and when
        strings.offer("b");
        element = strings.poll();
        String element2 = strings.poll();

        //and then
        assertEquals("a", element);
        assertEquals("b", element2);
        assertTrue(strings.isEmpty());
    }
}
