package com.vend.pathum;

import org.junit.Test;

import java.util.Arrays;

public class JUnitTest {

    @Test(timeout = 100)
    public void testMethod1(){
        int [] array = {23, 54, 12};
        for(int i =0; i < 1000000; i++){
            array[0]=i;
            Arrays.sort(array);
        }
    }

    @Test
    public void testMethod2(){
    }

}
