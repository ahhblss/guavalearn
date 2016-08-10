package com.lss.guava.collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
/**
 * Created by Sean.liu on 2016/8/10.
 */
public class BiMapDemo {
    @Test
    public void testBiMapForcePut() throws Exception {
        BiMap<String,String> biMap = HashBiMap.create();
        biMap.put("1","Tom");
        biMap.forcePut("2","Tom");
        System.out.println(biMap.containsKey("1"));
        System.out.println(biMap.containsKey("2"));
    }

    @Test
    public void testBiMapInverse() throws Exception {
        BiMap<String,String> biMap = HashBiMap.create();
        biMap.put("1","Tom");
        biMap.put("2","Harry");
        assertThat(biMap.get("1"),is("Tom"));
        assertThat(biMap.get("2"),is("Harry"));
        BiMap<String,String> inverseMap = biMap.inverse();
        assertThat(inverseMap.get("Tom"),is("1"));
        assertThat(inverseMap.get("Harry"),is("2"));
    }
}
