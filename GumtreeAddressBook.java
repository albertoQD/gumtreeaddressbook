package com.aqd.gumtreeaddressbook;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Alberto Quintero Delgado
 */
public class GumtreeAddressBook {

    private class Person implements Comparable<Person> {
        private final String  name_;
        private final boolean sex_; /* 1- Male, 0 - Female */
        private final Date    birthdate_;
        
        Person(String name, boolean sex, Date birthdate) {
            name_      = name;
            sex_       = sex;
            birthdate_ = birthdate;
        }
        
        String  getName()      { return name_; }
        boolean getSex()       { return sex_;  }
        Date    getBirthdate() { return birthdate_; }

        @Override
        public int compareTo(Person t) {
            return birthdate_.compareTo(t.getBirthdate());
        }
    }
    
    public void readFile() throws IOException {
        Scanner fileScanner = new Scanner(Paths.get(FILE_));
        people_ = new TreeSet();
        
        while(fileScanner.hasNextLine()) {
            /* While reading the parts, if one of them is missing just 
             * ignore this person and move forward */
            Scanner lineScanner = new Scanner(fileScanner.nextLine());
            lineScanner.useDelimiter(",");
            
            /* Checking for the person's name */
            if (!lineScanner.hasNext()) continue;
            String personName = lineScanner.next().trim();
            
            /* Checking for the person's sex */
            if (!lineScanner.hasNext()) continue;
            boolean personSex = (lineScanner.next()
                                            .trim()
                                            .equalsIgnoreCase("male"));
            
            // Add it to the TreeSet
            
        }
    }
    
    final static String FILE_ = "/home/ajqd/people.txt";
    /* BST - O (log(N)) for insertion and lookup */
    private TreeSet<Person> people_;
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        GumtreeAddressBook app = new GumtreeAddressBook();
        app.readFile();
    }
    
}
