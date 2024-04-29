package com.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LicensesTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        app.getMainScreen().confirm();
    }

    @Test
    public void tapLicensesPositiveTest(){
        app.getMainScreen().tapOnMoreOptions();
        app.getMainScreen().tapOnLicenses();
        Assert.assertTrue(app.getLicenses().isLicensesTextPresent().contains("NOTICES FOR LIBRARIES"));
    }
}
