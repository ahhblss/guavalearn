package com.lss.guava.collections;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sean.liu on 2016/8/4.
 */
public class MapDemo {
    private ArrayList<Person> personList = null;

    @Before
    public void setUp() {
        Person person1 = new Person("Wilma", "Flintstone", 30, "F",1);
        Person person2 = new Person("Fred", "Flintstone", 32, "M",2);
        Person person3 = new Person("Betty", "Rubble", 31, "F",3);
        Person person4 = new Person("Barney", "Rubble", 33, "M",4);
        personList = Lists.newArrayList(person1, person2, person3,
                person4);
    }

    @Test
    public void uniqueIndexDemo()
    {
        //list to map
        Map<Integer,Person> personMap = Maps.uniqueIndex(personList.iterator(), new Function<Person, Integer>() {
            public Integer apply(Person input) {
                return input.getID();
            }
        });

        for (Map.Entry<Integer,Person> entry:personMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue().getGivenName());
        }
    }

    @Test
    public void asMapTest()
    {
        Set<Person> personSet = Sets.newHashSet(personList.iterator());

        Map<Person,Integer> personMap =  Maps.asMap(personSet, new Function<Person, Integer>() {
            public Integer apply(Person input) {
                return input.getID();
            }
        });
        for (Map.Entry<Person,Integer> entry:personMap.entrySet()){
            System.out.println(entry.getKey().getID()+":"+entry.getValue());
        }

    }

    @Test
    public void toMapTest()
    {
        Set<Person> personSet = Sets.newHashSet(personList.iterator());

        Map<Person,Integer> personAsMap =  Maps.toMap(personSet, new Function<Person, Integer>() {
            public Integer apply(Person input) {
                return input.getID();
            }
        });
        for (Map.Entry<Person,Integer> entry:personAsMap.entrySet()){
            System.out.println(entry.getKey().getID()+":"+entry.getValue());
        }

    }

    @Test
    public void transformEntriesTest()
    {
        //可以通过可以修改value
        Map<Integer,Person> personMap = Maps.uniqueIndex(personList.iterator(), new Function<Person, Integer>() {
            public Integer apply(Person input) {
                return input.getID();
            }
        });

        for (Map.Entry<Integer,Person> entry:personMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue().getAge());
        }

        Map<Integer,Person> personMapV2 = Maps.transformEntries(personMap, new Maps.EntryTransformer<Integer, Person, Person>() {
            public Person transformEntry(Integer key, Person value) {
                value.setAge(value.getAge()+1);
                return value;
            }
        });
        for (Map.Entry<Integer,Person> entry:personMapV2.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue().getAge());
        }
    }

    @Test
    public void transformValuesTest()
    {
        //修改map的value
        Map<Integer,Person> personMap = Maps.uniqueIndex(personList.iterator(), new Function<Person, Integer>() {
            public Integer apply(Person input) {
                return input.getID();
            }
        });

        for (Map.Entry<Integer,Person> entry:personMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue().getAge());
        }

        Map<Integer,Person> personMapV2 = Maps.transformValues(personMap, new Function<Person, Person>() {
            public Person apply(Person input) {
                input.setAge(input.getAge()+1);
                return input;
            }
        });
        for (Map.Entry<Integer,Person> entry:personMapV2.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue().getAge());
        }
    }
}
