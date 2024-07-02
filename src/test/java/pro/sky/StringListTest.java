package pro.sky;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.list.StringList;
import pro.sky.list.StringListImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringListTest {
    private StringList stringList;


    @BeforeEach
    public void beforeEach() {
        stringList = new StringListImpl();
    }

    @Test
    void testAdd() {
        stringList.add("один");
        stringList.add("два");
        assertEquals(2, stringList.size());
        assertTrue(stringList.contains("один"));
        assertTrue(stringList.contains("два"));
    }

    @Test
    void testAddByIndex() {
        stringList.add("один");
        stringList.add("три");
        stringList.add(1, "два");
        assertEquals(3, stringList.size());
        assertEquals("один", stringList.get(0));
        assertEquals("два", stringList.get(1));
        assertEquals("три", stringList.get(2));
    }

    @Test
    void testSet() {
        stringList.add("один");
        stringList.add("два");
        stringList.set(1, "три");
        assertEquals(2, stringList.size());
        assertEquals("один", stringList.get(0));
        assertEquals("три", stringList.get(1));
    }

    @Test
    void testRemoveByItem() {
        stringList.add("один");
        stringList.add("два");
        stringList.add("три");
        stringList.remove("два");
        assertEquals(2, stringList.size());
        assertTrue(stringList.contains("три"));
        assertEquals("один", stringList.get(0));
        assertEquals("три", stringList.get(1));
    }

    @Test
    void testRemoveByIndex() {
        stringList.add("один");
        stringList.add("два");
        stringList.add("три");
        stringList.remove(1);
        assertEquals(2, stringList.size());
        assertFalse(stringList.contains("два"));
        assertEquals("один", stringList.get(0));
        assertEquals("три", stringList.get(1));
    }

    @Test
    void testContains() {
        stringList.add("один");
        stringList.add("два");
        stringList.add("три");
        assertTrue(stringList.contains("один"));
        assertTrue(stringList.contains("два"));
        assertTrue(stringList.contains("три"));
        assertFalse(stringList.contains("четыре"));
    }

    @Test
    void testIndexOf() {
        stringList.add("один");
        stringList.add("два");
        stringList.add("три");
        assertEquals(0, stringList.indexOf("один"));
        assertEquals(1, stringList.indexOf("два"));
        assertEquals(2, stringList.indexOf("три"));
        assertEquals(-1, stringList.indexOf("четыре"));
    }

    @Test
    void testLastIndexOf() {
        stringList.add("один");
        stringList.add("два");
        stringList.add("два");
        stringList.add("три");
        assertEquals(0, stringList.lastIndexOf("один"));
        assertEquals(2, stringList.lastIndexOf("два"));
        assertEquals(3, stringList.lastIndexOf("три"));
        assertEquals(-1, stringList.lastIndexOf("четыре"));
    }

    @Test
    void testGet() {
        stringList.add("один");
        stringList.add("два");
        stringList.add("три");
        assertEquals("один", stringList.get(0));
        assertEquals("два", stringList.get(1));
        assertEquals("три", stringList.get(2));
    }

    @Test
    void testEquals() {
        StringList otherList = new StringListImpl();
        otherList.add("один");
        otherList.add("два");
        otherList.add("три");
        stringList.add("один");
        stringList.add("два");
        stringList.add("три");
        assertTrue(stringList.equals(otherList));
    }

    @Test
    void testSize() {
        assertEquals(0, stringList.size());
        stringList.add("один");
        stringList.add("два");
        stringList.add("три");
        assertEquals(3, stringList.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(stringList.isEmpty());
        stringList.add("один");
        assertFalse(stringList.isEmpty());
    }

    @Test
    void testClear() {
        stringList.add("один");
        stringList.add("два");
        stringList.add("три");
        stringList.clear();
        assertEquals(0, stringList.size());
        assertTrue(stringList.isEmpty());
    }

    @Test
    void testToArray() {
        stringList.add("один");
        stringList.add("два");
        stringList.add("три");
        String[] array = stringList.toArray();
        assertEquals(3, array.length);
        assertEquals("один", array[0]);
        assertEquals("два", array[1]);
        assertEquals("три", array[2]);
    }
}
