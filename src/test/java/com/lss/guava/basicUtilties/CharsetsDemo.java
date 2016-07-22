package com.lss.guava.basicUtilties;

import com.google.common.base.Charsets;
import org.junit.Test;
import sun.nio.cs.StandardCharsets;

/**
 * Created by Sean.liu on 2016/7/22.
 */
public class CharsetsDemo {

    @Test
    public void testChartsets()
    {
        String demo = "我爱中国";
        byte[] demoBytes = demo.getBytes(Charsets.UTF_8);
    }
}
