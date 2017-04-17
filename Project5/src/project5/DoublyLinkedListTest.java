package project5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

/**
 * Tests the DoublyLinkedList class
 * 
 * @author Truman Heberle trumanh
 * @version 4.16.2017
 */
public class DoublyLinkedListTest extends TestCase {
    private DoublyLinkedList<String> list;
    
    /**
     * Runs before each test case
     */
    public void setUp() {
        list = new DoublyLinkedList<String>();
    }
    
    /**
     * Tests the size method
     */
    public void testSize() {
        assertEquals(0, list.size());
        list.addToFront("a");
        assertEquals(1, list.size());
        list.removeFront();
        assertEquals(0, list.size());
    }
    
    /**
     * Tests the addToBack method
     */
    public void testAddToBack() {
        list.addToBack("Front");
        list.addToBack("Back");
        assertEquals("Back", list.getBack());
        assertEquals("Front", list.getFront());
        assertEquals(2, list.size());
        
        list = new DoublyLinkedList<String>();
        list.addToBack("back");
        list.addToBack("back");
        assertEquals(2, list.size());
        assertEquals("back", list.getBack());
        assertEquals("back", list.getFront());
    }
    
    /**
     * tests the addToFront method
     */
    public void testAddToFront() {
        list.addToFront("Back");
        list.addToFront("Front");
        assertEquals("Back", list.getBack());
        assertEquals("Front", list.getFront());
        assertEquals(2, list.size());
        
        list = new DoublyLinkedList<String>();
        list.addToFront("back");
        list.addToFront("back");
        assertEquals(2, list.size());
        assertEquals("back", list.getBack());
        assertEquals("back", list.getFront());
    }
    
    /**
     * Tests the add method
     * Tests for exception when index is illegal
     */
    public void testAdd() {
        list.add(0, "0");
        assertEquals("0", list.getFront());
        assertEquals("0", list.getBack());
        assertEquals(1, list.size());
        
        list.add(0, "1");
        assertEquals("1", list.getFront());
        assertEquals("0", list.getBack());
        assertEquals(2, list.size());
        
        list.add(1, "2");
        assertEquals("1", list.getFront());
        assertEquals("0", list.getBack());
        assertEquals("2", list.getEntry(1));
        assertEquals(3, list.size());
        
        list.add(3, "3");
        assertEquals("1", list.getFront());
        assertEquals("3", list.getBack());
        assertEquals(4, list.size());
        
        Exception ex = null;
        try {
            list.add(10, "data");
        }
        catch (Exception e) {
            ex = e;
        }
        assertTrue(ex instanceof IndexOutOfBoundsException);
        assertEquals(4, list.size());
        
        ex = null;
        try {
            list.add(-1, "data");
        }
        catch (Exception e) {
            ex = e;
        }
        assertTrue(ex instanceof IndexOutOfBoundsException);
        assertEquals(4, list.size());
    }
    
    /**
     * Tests the removeFront method
     * Tests exception when empty
     */
    public void testRemoveFront() {
        list.addToFront("0");
        list.addToFront("1");
        list.addToFront("2");
        list.addToFront("3");
        assertEquals("3", list.removeFront());
        assertEquals("2", list.getFront());
        assertEquals(3, list.size());
        
        list = new DoublyLinkedList<String>();
        Exception ex = null;
        String item = null;
        try {
            item = list.removeFront();
        }
        catch (Exception e) {
            ex = e;
        }
        assertNull(item);
        assertTrue(ex instanceof IllegalStateException);
    }
    
    /**
     * Tests the removeBack method
     * Tests exception when empty
     */
    public void testRemoveBack() {
        list.addToBack("0");
        list.addToBack("1");
        list.addToBack("2");
        list.addToBack("3");
        assertEquals("3", list.removeBack());
        assertEquals("2", list.getBack());
        assertEquals(3, list.size());
        
        list = new DoublyLinkedList<String>();
        Exception ex = null;
        String item = null;
        try {
            item = list.removeBack();
        }
        catch (Exception e) {
            ex = e;
        }
        assertNull(item);
        assertTrue(ex instanceof IllegalStateException);
    }
    
    /**
     * Tests the remove method (by index)
     * Tests for IllegalStateException when empty
     * Tests for IndexOutOfBoundsException when
     * index is illegal
     */
    public void testRemoveIndex() {
        Exception ex = null;
        String item = null;
        try {
            item = list.remove(0);
        }
        catch (Exception e) {
            ex = e;
        }
        assertNull(item);
        assertTrue(ex instanceof IllegalStateException);
        
        list.addToFront("front");
        assertEquals("front", list.remove(0));
        assertEquals(0, list.size());
        
        list.addToFront("back");
        list.addToFront("front");
        assertEquals("front", list.remove(0));
        assertEquals(1, list.size());
        assertEquals("back", list.remove(0));
        assertEquals(0, list.size());
        
        list.addToFront("back");
        list.addToFront("front");
        assertEquals("back", list.remove(1));
        assertEquals(1, list.size());
        assertEquals("front", list.remove(0));
        assertEquals(0, list.size());
        
        list.addToFront("data");
        ex = null;
        item = null;
        try {
            list.remove(3);
        }
        catch (Exception e) {
            ex = e;
        }
        assertNull(item);
        assertTrue(ex instanceof IndexOutOfBoundsException);
        assertEquals(1, list.size());
        
        ex = null;
        item = null;
        try {
            list.remove(-1);
        }
        catch (Exception e) {
            ex = e;
        }
        assertNull(item);
        assertTrue(ex instanceof IndexOutOfBoundsException);
        assertEquals(1, list.size());
    }
    
    /**
     * Tests the remove method (by data)
     * Test a boolean is returned
     */
    public void testRemoveItem() {
        assertFalse(list.remove("data"));
        
        list.addToBack("data");
        assertTrue(list.remove("data"));
        assertEquals(0, list.size());
        
        list.addToBack("data");
        list.addToBack("notdata");
        assertTrue(list.remove("data"));
        assertEquals(1, list.size());
        
        list = new DoublyLinkedList<String>();
        list.addToBack("data");
        list.addToBack("data");
        assertTrue(list.remove("data"));
        assertEquals(1, list.size());
        assertTrue(list.contains("data"));
    }
    
    /**
     * Tests the get method
     * Tests exception when index is illegal
     */
    public void testGet() {
        list.addToFront("Front");
        assertEquals("Front", list.getEntry(0));
        
        list.addToFront("front");
        assertEquals("front", list.getEntry(0));
        assertEquals("Front", list.getEntry(1));
        
        list.addToFront("f");
        assertEquals("f", list.getEntry(0));
        assertEquals("front", list.getEntry(1));
        assertEquals("Front", list.getEntry(2));
        
        Exception ex = null;
        String item = null;
        try {
            item = list.getEntry(21);
        }
        catch (Exception e) {
            ex = e;
        }
        assertNull(item);
        assertTrue(ex instanceof IndexOutOfBoundsException);
        
        ex = null;
        item = null;
        try {
            item = list.getEntry(-1);
        }
        catch (Exception e) {
            ex = e;
        }
        assertNull(item);
        assertTrue(ex instanceof IndexOutOfBoundsException);
    }
    
    /**
     * Tests the contains method
     */
    public void testContains() {
        assertFalse(list.contains("notinList"));
        
        list.addToBack("back");
        assertTrue(list.contains("back"));
        assertFalse(list.contains("notinList"));
        
        list.addToBack("newBack");
        assertTrue(list.contains("back"));
        assertTrue(list.contains("newBack"));
        assertFalse(list.contains("notinList"));
        
        list.removeBack();
        assertTrue(list.contains("back"));
        assertFalse(list.contains("newBack"));
        assertFalse(list.contains("notinList"));
    }
    
    /**
     * Tests the iterator method
     * to make sure a usable iterator is returned
     */
    public void testIterator() {
        for (int i = 0; i < 20; i++) {
            list.addToBack("String" + i);
        }
        Iterator<String> iter = list.iterator();
        for (int i = 0; i < 20; i++) {
            assertTrue(iter.hasNext());
            assertEquals("String" + i, iter.next());
        }
        
        assertFalse(iter.hasNext());
        Exception ex = null;
        String next = null;
        try {
            next = iter.next();
        }
        catch (Exception e) {
            ex = e;
        }
        assertNull(next);
        assertTrue(ex instanceof NoSuchElementException);
    }
}
