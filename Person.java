package com.aqd.gumtreeaddressbook;

import java.util.Date;

/**
 *
 * @author Alberto Quintero Delgado
 */
public class Person implements Comparable<Person> {
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
