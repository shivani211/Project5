package project5;

/**
 * A linked chain of Nodes to store data
 * Contains sentinel nodes
 * 
 * @author Truman Heberle trumanh
 * @version 4.15.2017
 */
public class DoublyLinkedList<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;
    
    /**
     * Creates new DoublyLinkedList
     */
    public DoublyLinkedList() {
        size = 0;
        head = new Node<T>(null);
        tail = new Node<T>(null);
        head.setNext(tail);
        tail.setPrevious(head);
    }
    
    /**
     * Returns the size of the DoublyLinkedList
     * 
     * @return The size of the DoublyLinkedList
     */
    public int size() {
        return size;
    }
    
    /**
     * Creates a new Node with data and adds it to the back
     * of the DoublyLinkedList
     * 
     * @param data The data to be stored
     */
    public void addToBack(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.addAfter(tail.previous());
        size++;
    }
    
    /**
     * Creates a new Node with data and adds it to the front
     * of the DoublyLinkedList
     * 
     * @param data The data to be stored
     */
    public void addToFront(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.addAfter(head);
        size++;
    }
    
    /**
     * Creates a new Node with data and adds it at
     * a certain position in the DoublyLinkedList
     * 
     * @param index The position to add the Node to
     * @param data The data to be stored
     * @throws IndexOutOfBoundsException If the index is not valid
     */
    public void add(int index, T data) throws IndexOutOfBoundsException {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index is invalid");
        }
        
        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next();
        }
        Node<T> newNode = new Node<T>(data);
        newNode.addAfter(curr);
    }
    
    /**
     * Removes the first Node and returns its data
     * 
     * @return The first Node's data
     * @throws IllegalStateException If the list is empty
     */
    public T removeFront() throws IllegalStateException {
        if (size == 0) {
            throw new IllegalStateException("DoublyLinkedList is empty");
        }
        return head.next().remove();
    }
    
    /**
     * Removes the last Node and returns its data
     * 
     * @return The last Node's data
     * @throws IllegalStateException If the list is empty
     */
    public T removeBack() throws IllegalStateException {
        if (size == 0) {
            throw new IllegalStateException("DoublyLinkedList is empty");
        }
        return tail.previous().remove();
    }
    
    /**
     * Searches for the first Node containing input data
     * and removes that node. Returns whether the Node
     * was successfully removed
     * 
     * @param data The data to remove
     * @return Whether the Node was removed
     */
    public boolean remove(T data) {
        Node<T> curr = head;
        while(curr != tail) {
            if (curr.data().equals(data)) {
                curr.remove();
                return true;
            }
        }
        return false;
    }
    
    /**
     * Removes the Node at a certain index if possible
     * 
     * @param index The Node index to remove
     * @return The data removed
     * @throws IndexOutOfBoundsException If the index is not valid
     * @throws IllegalStateException If the list is empty
     */
    public T remove(int index) throws IndexOutOfBoundsException, IllegalStateException {
        if (size == 0) {
            throw new IllegalStateException("DoublyLinkedList is empty");
        }
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index is invalid");
        }
                
        Node<T> curr = head.next();
        for (int i = 0; i < index; i++) {
            curr = curr.next();
        }
        return curr.remove();
    }
    
    /**
     * Returns the data of the first Node
     * 
     * @return The data of the first Node
     */
    public T getFront() {
        return head.next().data();
    }
    
    /**
     * Returns the data of the last Node
     * 
     * @return The data of the last Node
     */
    public T getBack() {
        return tail.previous().data();
    }
    
    /**
     * Returns the data of a specified Node
     * 
     * @param index The Node's index
     * @return The Node's data
     * @throws IndexOutOfBoundsException If the index is invalid
     */
    public T getEntry(int index) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index is invalid");
        }
        
        Node<T> curr = head.next();
        for (int i = 0; i < index; i++) {
            curr = curr.next();
        }
        return curr.data();
    }
    
    /**
     * Checks whether data is contained in the list
     * 
     * @param data The data to check for
     * @return Whether a Node contains the data
     */
    public boolean contains(T data) {
        Node<T> curr = head;
        while (curr != null) {
            if (curr.data().equals(data)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Stores data in a Node
     * 
     * @author Truman Heberle trumanh
     * @version 4.15.2017
     * @param <T> The type of data stored in the Node
     */
    @SuppressWarnings("hiding")
    private class Node<T> extends DoublyLinkedList<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;
        
        /**
         * Creates a new Node
         * 
         * @param nodeData The data to store
         */
        public Node(T nodeData) {
            data = nodeData;
            next = null;
            prev = null;
        }
        
        /**
         * Sets the next Node
         * 
         * @param nextNode The next Node
         */
        public void setNext(Node<T> nextNode) {
            next = nextNode;
        }
        
        /**
         * Sets the previous Node
         * 
         * @param prevNode The previous Node
         */
        public void setPrevious(Node<T> prevNode) {
            prev = prevNode;
        }
        
        /**
         * Returns the next Node
         * 
         * @return The next Node
         */
        public Node<T> next() {
            return next;
        }
        
        /**
         * Returns the previous Node
         * 
         * @return The previous Node
         */
        public Node<T> previous() {
            return prev;
        }
        
        /**
         * Sets the data inside the Node
         * 
         * @param nodeData The data inside the Node
         */
        public void setData(T nodeData) {
            data = nodeData;
        }
        
        /**
         * Returns the data inside the Node
         * 
         * @return The data inside the Node
         */
        public T data() {
            return data;
        }
        
        /**
         * Separates this Node from a chain
         * 
         * @return The data inside this Node
         */
        public T remove() {
            this.previous().setNext(this.next());
            this.next().setPrevious(this.previous());
            return this.data;
        }
        
        /**
         * Adds this Node to a chain after a specified Node
         * 
         * @param currentNode the specified Node
         */
        public void addAfter(Node<T> currentNode) {
            this.setNext(currentNode.next());
            currentNode.next().setPrevious(this);
            currentNode.setNext(this);
            this.setPrevious(currentNode);
        }
    }
}
