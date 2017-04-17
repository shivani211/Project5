package project5;

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
    
    public void testSize() {
        assertEquals(0, list.size());
        list.addToFront("a");
        assertEquals(1, list.size());
        list.removeFront();
        assertEquals(0, list.size());
    }
    
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
    
    public void testRemoveFront() {
        list.addToFront("0");
        list.addToFront("1");
        list.addToFront("2");
        list.addToFront("3");
        assertEquals("3", list.removeFront());
        assertEquals("2", list.getFront());
        assertEquals(3, list.size());
    }
    
    public void testRemoveBack() {
        list.addToBack("0");
        list.addToBack("1");
        list.addToBack("2");
        list.addToBack("3");
        assertEquals("3", list.removeBack());
        assertEquals("2", list.getBack());
        assertEquals(3, list.size());
    }
    
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
}
