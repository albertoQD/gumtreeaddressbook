package com.aqd.gumtreeaddressbook;

import java.util.TreeSet;

/**
 *
 * @author Alberto Quintero Delgado
 */
public class GumtreeAddressBook {

    private class Person {
        private final String  name_;
        private final boolean sex_;
        
        Person(String name, boolean sex) {
            name_ = name;
            sex_  = sex;
        }
        
        String  getName() { return name_; }
        boolean getSex()  { return sex_;  }
        
    }
    
    public void readFile() {
        
    }
    
    final static String FILE_ = "/home/ajqd/people.txt";
    /* BST - O (log(N)) for insertion and lookup */
    private TreeSet<Person> people_;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
}
