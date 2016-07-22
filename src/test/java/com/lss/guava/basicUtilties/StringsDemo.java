package com.lss.guava.basicUtilties;

import com.google.common.base.Strings;
import org.junit.Test;

/**
 * Created by Sean.liu on 2016/7/22.
 */
public class StringsDemo {

    @Test
    public void padEndTest()
    {
        System.out.println(Strings.padEnd("foor",10,'x'));
    }

    @Test
    public void nullEmptyTest()
    {
        System.out.println(Strings.nullToEmpty(null));

        System.out.println(Strings.emptyToNull(""));

        System.out.println(Strings.isNullOrEmpty(""));
    }
}
