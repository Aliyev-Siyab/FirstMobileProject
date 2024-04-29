package com.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainScreenTests extends TestBase{

    // confirm OK
    @BeforeMethod
    public void precondition(){
        app.getMainScreen().confirm();
    }
    // verify text is displayed
    @Test
    public void appLunchTest(){
        Assert.assertTrue(app.getMainScreen().isNoReminderTextPresent());
    }
}
