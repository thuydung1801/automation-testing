package com.test.ass1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ex2 {
    @Parameters({"mark"})
    @Test
    public void CheckPassFail(int mark) {
        if (mark <= 50){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

    }

}
