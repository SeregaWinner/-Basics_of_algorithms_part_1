package pro.sky;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.list.StringList;
import pro.sky.list.StringListImpl;

import static org.junit.jupiter.api.Assertions.*;


public class StringListTest {
    private StringList stringList;


    @BeforeEach
    public void beforeEach() {
        stringList = new StringListImpl();

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
