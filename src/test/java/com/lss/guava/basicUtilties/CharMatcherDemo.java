package com.lss.guava.basicUtilties;

import com.google.common.base.CharMatcher;
import org.junit.Test;

/**
 * Created by Sean.liu on 2016/7/22.
 */
public class CharMatcherDemo {

    @Test
    public void testRemoveWhiteSpace(){
        //去掉tab键与空格
        String tabsAndSpaces = "String with    spaces and          tabs";
        String scrubbed = CharMatcher.WHITESPACE.
                collapseFrom(tabsAndSpaces,' ');
        System.out.println(scrubbed);

    }

    @Test
    public void testTrimRemoveWhiteSpace(){
        //去掉tab键与空格和trim
        String tabsAndSpaces = " String with spaces and                 tabs";
        String scrubbed = CharMatcher.WHITESPACE.
                trimAndCollapseFrom(tabsAndSpaces,' ');
        System.out.println(scrubbed);
    }

    @Test
    public void testRetainFrom(){
        //抽取
        String lettersAndNumbers = "foo989yxbar234";
        String retained = CharMatcher.JAVA_DIGIT.
                retainFrom(lettersAndNumbers);
        System.out.println(retained);

        retained =CharMatcher.JAVA_LETTER.retainFrom(lettersAndNumbers);
        System.out.println(retained);

    }
}
