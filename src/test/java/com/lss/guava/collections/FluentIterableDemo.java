package com.lss.guava.collections;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Sean.liu on 2016/7/27.
 */
public class FluentIterableDemo {

    private ArrayList<Person> personList = null;

    @Before
    public void setUp() {
        Person person1 = new Person("Wilma", "Flintstone", 30, "F");
        Person person2 = new Person("Fred", "Flintstone", 32, "M");
        Person person3 = new Person("Betty", "Rubble", 31, "F");
        Person person4 = new Person("Barney", "Rubble", 33, "M");
        personList = Lists.newArrayList(person1, person2, person3,
                person4);
    }

    @Test
    public void testFilter()
    {
        Iterable<Person> personsByAge = FluentIterable.from(personList).filter(new Predicate<Person>() {
            public boolean apply(Person input) {
                return input.getAge()>31;
            }
        });

        Iterator<Person> personIterator = personsByAge.iterator();
        while (personIterator.hasNext())
        {
            System.out.println(personIterator.next().getAge());
        }
    }

    @Test
    public void testTransform()
    {
        Iterable<String> personsTransform = FluentIterable.from(personList).transform(new Function<Person,String>(){
            public String apply(Person input) {
                return Joiner.on('#').join(input.getGivenName(),input.getFamlyName(),input.getAge());
            }
        }).toList();

        Iterator<String> personIterator = personsTransform.iterator();
        while (personIterator.hasNext())
        {
            System.out.println(personIterator.next());
        }
    }
}
