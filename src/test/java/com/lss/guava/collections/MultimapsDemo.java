package com.lss.guava.collections;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Sean.liu on 2016/8/10.
 */
public class MultimapsDemo {

    @Test
    public void arrayListMultiMapTest() {
        ArrayListMultimap<String, String> multiMap =
                ArrayListMultimap.create();
        multiMap.put("Foo", "1");
        multiMap.put("Foo", "2");
        multiMap.put("Foo", "3");

        List<String> expected = Lists.newArrayList("1","2","3");
        assertEquals(multiMap.get("Foo"),expected);
    }

    @Test
    public void testArrayListMultimapSameKeyValue(){
        ArrayListMultimap<String,String> multiMap =
                ArrayListMultimap.create();
        multiMap.put("Bar","1");
        multiMap.put("Bar","2");
        multiMap.put("Bar","3");
        multiMap.put("Bar","3");
        multiMap.put("Bar","3");
        List<String> expected = Lists.
                newArrayList("1","2","3","3","3");
        System.out.println(multiMap.size());

        Map<String,Collection<String>> map = multiMap.asMap();
        for (String key:map.keySet()){
            Collection<String> valueList = map.get(key);
            for (String item:valueList)
            {
                System.out.println(item);
            }
        }
        assertEquals(multiMap.get("Bar"),expected);
    }

    @Test
    public void hashMultimapTest()
    {
        //value不允许重复
        HashMultimap<String,String> multiMap =
                HashMultimap.create();
        multiMap.put("Bar","1");
        multiMap.put("Bar","2");
        multiMap.put("Bar","3");
        multiMap.put("Bar","3");
        multiMap.put("Bar","3");
        assertEquals(multiMap.size(),3);
    }
}
