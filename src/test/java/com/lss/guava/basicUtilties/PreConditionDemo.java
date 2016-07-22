package com.lss.guava.basicUtilties;

import com.google.common.base.Preconditions;

/**
 * Created by Sean.liu on 2016/7/22.
 */
public class PreConditionDemo {

    private String label;
    private int[] values = new int[5];
    private int currentIndex;

    public PreConditionDemo(String label) {
        this.label = Preconditions.checkNotNull(label,"label can not be null");
    }

    public void updateCurrentIndexValue(int index,int value)
    {
        this.currentIndex = Preconditions.checkElementIndex(index,values.length,"index out of bounds");

        Preconditions.checkArgument(value<=100,"value can not more than 100");

        values[this.currentIndex] = value;

    }

    public void doOperation()
    {
        Preconditions.checkState(validateObjectState(),"can not perform operation");
    }

    private boolean validateObjectState()
    {
        return this.label.equalsIgnoreCase("open") && values[this.currentIndex] == 10;
    }

    public static void main(String[] args) {
        PreConditionDemo demo = new PreConditionDemo("open");
        demo.updateCurrentIndexValue(3,10);
        demo.doOperation();
    }
}
