package com.aqd.gumtreeaddressbook;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Alberto Quintero Delgado
 */
public class GumtreeAddressBook {
    
    final static String FILE_ = "/home/ajqd/people.txt";
    /* BST - O (log(N)) for insertion and lookup */
    private TreeSet<Person> people_;
    
    
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
            
            if (!lineScanner.hasNext()) continue;
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
                Date personBirthdate = format.parse(lineScanner.next().trim());
                
                /* As it is a tree, it keep the objects ordered */
                people_.add(new Person(personName, personSex, personBirthdate));
            } catch (ParseException ex) {
                System.out.println("ERROR: Cannot parse the birthdate");
            }
        }
    }
    
    public int countBySex(boolean sex) {
        int retVal = 0;
        for (Person p: people_) {
            retVal += (p.getSex() == sex) ? 1 : 0;
        }
        
        return retVal;
    }
    
    public Person getOldest()   { return people_.first(); }
    
    public Person getYoungest() { return people_.last(); }
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        GumtreeAddressBook app = new GumtreeAddressBook();
        app.readFile();
        Person p1 = app.getOldest();
        Person p2 = app.getYoungest();
        
        System.out.println("The oldest person is: " + p1.getName());
        System.out.println("The youngest person is: " + p2.getName());
        System.out.println("The number of males is: " + Integer.toString(app.countBySex(true)));
    }
}
