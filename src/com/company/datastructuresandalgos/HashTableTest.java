package com.company.datastructuresandalgos;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {
    @Test
    public void whenAddElementToCustomHashTableTHenShouldRetrieveIt() {
        //given
        CustomHashTable<String, Integer> map = new CustomHashTable<>();
        //when
        map.put("a", 1);
        map.put("b", 1);
        map.put("c", 1);
        //then
        assertEquals(3, map.size());
        assertTrue(map.containsKey("a"));
        assertFalse(map.containsKey("d"));
    }

    @Test
    public void addMultipleElementsToTheHashTable() {
        //given
        CustomHashTable<String, Integer> map = new CustomHashTable<>();
        //when
        IntStream.range(0, 10_000).forEach(i -> map.put(String.valueOf(i), i));
        //then
        assertEquals(10_000, map.size());
    }

    @Test
    public void whenUsingObjectsWithBrokenHashCodeThenAllElementsWillLandInTheSameBucket() {
        //given
        CustomHashTable<BrokenHashCode, Integer> map = new CustomHashTable<>();
        //when
        IntStream.range(0, 10_000).forEach(i -> map.put(new BrokenHashCode(i), i));
        //then
        assertEquals(1, map.getHashCodeDistribution().stream().filter(v -> v.equals(10_000)).count());
        assertEquals(10_000, map.size());
    }

    @Test
    public void whenUsingObjectsWithProperHashCode() {
        //given
        CustomHashTable<ProperHashCode, Integer> map = new CustomHashTable<>();
        //when
        IntStream.range(0, 10_000).forEach(i -> map.put(new ProperHashCode(i), i));
        //then
        assertEquals(10, map.getHashCodeDistribution().stream().filter(v -> v.equals(1_000)).count());
        assertEquals(10_000, map.size());
    }

    @Test
    public void whenAddElementToMapThenShouldRetrieveIt() {
        //given
        Map<String, Integer> map = new HashMap<>();
        //when
        map.put("a", 1);
        map.put("b", 1);
        map.put("c", 1);
        //then
        assertEquals(3, map.size());
        assertEquals(1, map.get("b").intValue());
        assertTrue(map.containsKey("a"));
    }

    private static class ProperHashCode {
        private final int value;

        public ProperHashCode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ProperHashCode)) return false;
            ProperHashCode that = (ProperHashCode) o;
            return value == that.value;
        }

        @Override
        public int hashCode() {
            return getValue();
        }
    }

    private static class BrokenHashCode {
        private final int value;

        public BrokenHashCode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof BrokenHashCode)) return false;
            BrokenHashCode that = (BrokenHashCode) o;
            return value == that.value;
        }

        @Override
        public int hashCode() {
            return 1; // broken hashcode
        }
    }
}
