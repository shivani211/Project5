package project5;

import java.io.File;
import java.util.Scanner;

public class PersonScanner {
    private DoublyLinkedList<Person> peopleList;
    
    public PersonScanner() {
        peopleList = new DoublyLinkedList<Person>();
    }
    
    public PersonScanner(String fileName) {
        this();
        this.scanPeople(fileName);
    }
    
    public void scanPeople(String fileName) {
        Scanner scan = new Scanner(fileName);
        while (scan.hasNext()) {
            System.out.println(scan.next());
        }
    }
    
    public DoublyLinkedList<Person> getPeopleList() {
        return peopleList;
    }
}
