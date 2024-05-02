package com.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReminderTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        app.getMainScreen().confirm();
    }

    // Ирина куда можно было вывести метод addReminder по хорошему ?
    public static void addReminder() {
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");
    }

    @Test
    public void addReminderTitlePositiveTest(){
        addReminder();
        app.getReminder().saveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderTitlePresent().contains("Holiday"));
    }



    @Test
    public void addReminderWithDatePositiveTest(){
        addReminder();
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
        addReminder();
        app.getReminder().tapOnTimeField();
        app.getReminder().selectTime("am",269,926,531,1195);
        app.getReminder().tapOnOk();
        app.getReminder().saveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderDatePresent().contains("9:30"));
    }

    // Check Repeat(verify Repeat off)
    @Test
    public void checkRepeatIsOffTest(){
        addReminder();
        app.getReminder().tapOnRepeatOff();
        app.getReminder().saveReminder();
        Assert.assertTrue(app.getReminder().isRepeatOff().contains("Repeat Off"));
    }

    // check Repetition Interval (verify Interval)
    @Test
    public void checkRepetitionIntervalTest(){
        addReminder();
        app.getReminder().setRepetitionInterval("2","OK");
        app.getReminder().saveReminder();
        Assert.assertTrue(app.getReminder().verifyRepetitionInterval().contains("2"));
    }

    // check Type of repetition (verify "Week")
    @Test
    public void checkTypeOfRepetitionTest(){
        addReminder();
        app.getReminder().tapOnRepeatField();
        app.getReminder().setRepetitionType("Week");
        app.getReminder().saveReminder();
        Assert.assertTrue(app.getReminder().verifyRepetitionType().contains("Week(s)") );
    }
}
