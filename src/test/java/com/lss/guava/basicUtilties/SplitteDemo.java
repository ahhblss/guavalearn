package com.lss.guava.basicUtilties;

import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import com.sun.javafx.collections.MappingChange;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by Sean.liu on 2016/7/21.
 */
public class SplitteDemo {

    private String strings;

    @Before
    public void init(){
        strings = "  Monday  ,Tuesday,,Thursday,Friday,,";
    }

    @Test
    public void splitTest()
    {
        String[] traditionalDemo = strings.split(",");
        for (String str:traditionalDemo)
        {
            System.out.println(str);

        }
        System.out.println("-----");
        Iterable<String> guavaDemo = Splitter.on(",").split(strings);
        Iterator<String> iterator = guavaDemo.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-----");
        //去掉string前后空格
        Splitter splitter = Splitter.on(",").trimResults();
        guavaDemo = splitter.split(strings);
        iterator = guavaDemo.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testMapSplitter() {
        String startString = "Washington D.C=Redskins#New York City=Giants#Philadelphia=Eagles#Dallas=Cowboys";
        Map<String,String> testMap = Maps.newLinkedHashMap();
        testMap.put("Washington D.C","Redskins");
        testMap.put("New York City","Giants");
        testMap.put("Philadelphia","Eagles");
        testMap.put("Dallas","Cowboys");
        Splitter.MapSplitter mapSplitter =
                Splitter.on("#").withKeyValueSeparator("=");
        Map<String,String> splitMap =
                mapSplitter.split(startString);
        for (Map.Entry item:splitMap.entrySet())
        {
            System.out.println(item.getKey()+":"+item.getValue());
        }
    }
}
