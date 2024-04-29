package com.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReminderTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        app.getMainScreen().confirm();
    }

    @Test
    public void addReminderTitlePositiveTest(){
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");
        app.getReminder().saveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderTitlePresent().contains("Holiday"));
    }
}
