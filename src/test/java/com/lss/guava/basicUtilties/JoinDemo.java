package com.lss.guava.basicUtilties;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Sean.liu on 2016/7/21.
 */
public class JoinDemo {
    private String[] strArray1;

    @Before
    public void init(){
        strArray1 = new String[]{"1","2",null,"3"};
    }

    @Test
    public void joinTest()
    {
//        Joiner.on(",").join(strArray1); throws null point because infact joiner use object.toString()
        System.out.println(Joiner.on(",").skipNulls().join(strArray1));

        //joiner class对象为不可变对象
        Joiner stringJoiner = Joiner.on("|").skipNulls();

//        stringJoiner.useForNull("not set"); java.lang.UnsupportedOperationException: already specified skipNulls

        System.out.println(stringJoiner.join(strArray1));

        //with stringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        Joiner stringJoinerTwo = Joiner.on("||").skipNulls();
        System.out.println(stringJoinerTwo.appendTo(stringBuilder,strArray1).toString());
    }

    @Test
    public void testMapJoiner() {
        //map转换成string
        //Using LinkedHashMap so that the original  order is preserved
        String expectedString = "Washington D.C=Redskins#New York City=Giants#Philadelphia=Eagles#Dallas=Cowboys";
        Map<String,String> testMap = Maps.newLinkedHashMap();
        testMap.put("Washington D.C","Redskins");
        testMap.put("New York City","Giants");
        testMap.put("Philadelphia","Eagles");
        testMap.put("Dallas","Cowboys");
        String returnedString = Joiner.on("#").
                withKeyValueSeparator("=").join(testMap);
        System.out.println(returnedString.equals(expectedString));
    }
}
