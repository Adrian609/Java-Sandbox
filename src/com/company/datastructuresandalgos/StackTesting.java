package com.company.datastructuresandalgos;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StackTesting {
    @Test
    public void whenPushToStackThenShouldRetrieveIt() {
        //given
        Stack<String> stack = new Stack<>();

        //when
        stack.push("a");

        //then
        assertEquals(stack.size(), 1);

        //and when
        String element = stack.pop();

        // and then
        assertEquals(element, "a");
        assertTrue(stack.isEmpty());
    }

    @Test
    public void whenPushToStackThenShouldRetrieveElementsInTheProperOrder() {
        //given
        Stack<String> stack = new Stack<>();
        //when
        stack.push("a");
        stack.push("b");
        stack.push("c");
        //then
        assertEquals("c", stack.pop()); // LIFO
        assertEquals("b", stack.pop());
        assertEquals("a", stack.pop());
    }

    @Test
    public void whenPushAndPeekElementShouldNotRemoveIT() {
        //given
        Stack<String> stack = new Stack<>();
        //when
        stack.push("a");
        //then
        assertEquals(1, stack.size());
        assertEquals("a", stack.peek());
        assertEquals(1, stack.size());
    }
}
