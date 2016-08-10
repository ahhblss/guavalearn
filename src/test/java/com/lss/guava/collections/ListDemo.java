package com.lss.guava.collections;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sean.liu on 2016/7/27.
 */
public class ListDemo {
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
    public void partitionTest()
    {
        List<List<Person>> subLists =Lists.partition(personList,2);
        for (List<Person> list:subLists)
        {
            System.out.println(list.size());
        }
    }
}
