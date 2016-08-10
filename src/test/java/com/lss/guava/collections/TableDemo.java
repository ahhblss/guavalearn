package com.lss.guava.collections;

import com.google.common.collect.HashBasedTable;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Sean.liu on 2016/8/10.
 */
public class TableDemo {


    @Test
    public void tableOperations()
    {
        /*A table is a collection that takes two keys, a
        row, and a column, and maps those keys to a single value*/
        HashBasedTable<Integer,Integer,String> table =
                HashBasedTable.create();
        table.put(1,1,"Rook");
        table.put(1,2,"Knight");
        table.put(1,3,"Bishop");
        System.out.println(table.contains(1,1));
        System.out.println(table.containsColumn(2));
        System.out.println(table.containsRow(1));
        System.out.println(table.containsValue("Rook"));
        System.out.println(table.remove(1,3));
        System.out.println(table.get(3,4));
    }

    @Test
    public void tableViewsTest()
    {
        HashBasedTable<Integer,Integer,String> table =
                HashBasedTable.create();
        table.put(1,1,"Rook");
        table.put(1,2,"Knight");
        table.put(1,3,"Bishop");

        Map<Integer,String> columnMap = table.column(2);
        for (Map.Entry<Integer,String> entry:columnMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        Map<Integer,String> rowMap = table.row(1);
        for (Map.Entry<Integer,String> entry:rowMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
