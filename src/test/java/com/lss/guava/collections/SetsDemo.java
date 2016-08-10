package com.lss.guava.collections;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Sean.liu on 2016/7/27.
 */
public class SetsDemo {

    @Test
    public void differenceTest()
    {
        //返回s1中的元素并且此元素在s2中不存在
        Set<String> s1 = Sets.newHashSet("1","2","3");
        Set<String> s2 = Sets.newHashSet("3","2","6");
        Sets.SetView<String> setView =  Sets.difference(s1,s2);
        Iterator<String> iterator = setView.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void symmetricDifferenceTest()
    {
        Set<String> s1 = Sets.newHashSet("1","2","3");
        Set<String> s2 = Sets.newHashSet("3","4","6");
        Sets.SetView<String> setView =  Sets.symmetricDifference(s1,s2);//返回s1、s2中不重复的数据
        Iterator<String> iterator = setView.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void intersectionTest()
    {
        Set<String> s1 = Sets.newHashSet("1","2","3");
        Set<String> s2 = Sets.newHashSet("3","4","6");
        Sets.SetView<String> setView =  Sets.intersection(s1,s2);//返回交集
        Iterator<String> iterator = setView.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void unionTest()
    {
        Set<String> s1 = Sets.newHashSet("1","2","3");
        Set<String> s2 = Sets.newHashSet("3","4","6");
        Sets.SetView<String> setView =  Sets.union(s1,s2);//返回并集
        Iterator<String> iterator = setView.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }

}
