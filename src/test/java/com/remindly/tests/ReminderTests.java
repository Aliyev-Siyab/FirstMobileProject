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

    @Test
    public void addReminderWithDatePositiveTest(){
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");
        app.getReminder().tapOnDateField();
        app.getReminder().swipeToMonth("future",1,"MAY");
        app.getReminder().selectDate(0);
        app.getReminder().tapOnYear();
        app.getReminder().swipeToYear("future","2025");
        app.getReminder().tapOnOk();
        app.getReminder().saveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderDatePresent().contains("1/5/2025"));
    }


    @Test
    public void addReminderWithTimePositive(){
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");
        app.getReminder().tapOnTimeField();
        app.getReminder().selectTime("am",269,926,531,1195);
        app.getReminder().tapOnOk();
        app.getReminder().saveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderDatePresent().contains("9:30"));

    }

    // Check Repeat(verify Repeat off)

    // check Repetition Interval (verify Interval)

    // check Type of repetition (verify "Week")
}
