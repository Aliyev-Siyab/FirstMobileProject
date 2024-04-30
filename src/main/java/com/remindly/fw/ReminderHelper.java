package com.remindly.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReminderHelper extends BaseHelper{
    public ReminderHelper(AppiumDriver driver) {
        super(driver);
    }

    public void enterReminderTitle(String title) {
        type(By.id("reminder_title"),title);
    }

    public void saveReminder() {
        tap(By.id("save_reminder"));
    }

    public void tapOnDateField() {
        tap(By.id("date"));
    }

    public void swipeToMonth(String period, int number, String month) {
        pause(500);

        if(!getSelectedMonth().equals(month)){

            for (int i = 0; i <number ; i++) {
                if(period.equals("future")){
                    swipe(0.8,0.4);
                } else if (period.equals("past")) {
                    swipe(0.5,0.8);
                }
            }
        }
    }

    public String getSelectedMonth(){
        return driver.findElement(By.id("date_picker_month")).getText();
    }

    public void selectDate(int index) {
        List<WebElement> days = driver.findElements(By.className("android.view.View"));
        days.get(index).click();
    }

    public void tapOnYear() {
        tap(By.id("date_picker_year"));
    }

    public void swipeToYear(String period,String year) {
        pause(500);

        if(!getSelectedYear().equals("year")){
            if(period.equals("future")){
                swipeUntilNeededYear(year,0.6,0.5);
            } else if (period.equals("past")) {
                swipeUntilNeededYear(year,0.5,0.6);
            }
        }
        tap(By.id("month_text_view"));
    }

    private void swipeUntilNeededYear(String year, double startPoint, double stopPoint) {

        while (!getYear().equals(year)){
            swipeByElement(By.className("android.widget.ListView"),startPoint,stopPoint);
            getYear();
        }
    }

    public String getYear(){
        return driver.findElement(By.id("month_text_view")).getText();
    }

    public String getSelectedYear(){
        return driver.findElement(By.id("date_picker_year")).getText();
    }

    public void tapOnOk() {
        tap(By.id("ok"));
    }

    public void tapOnTimeField() {
        tap(By.id("time"));
    }

    public void selectTime(String timeOfDay,int xHour,int yHour,int xMin,int yMin) {
        pause(500);
        if(timeOfDay.equals("am")){
            tapWithCoordinates(285,1324);
        } else if (timeOfDay.equals("pm")) {
            tapWithCoordinates(804,1324);
        }
        tapWithCoordinates(xHour,yHour);
        tapWithCoordinates(xMin,yMin);
    }
}
