package com.travel.utilities;

import org.junit.Assert;

public class BrowserUtils {

    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);

    }

    public static void sleep(int second){
        second *= 1000;
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }

}
