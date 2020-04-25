package com.techtorial.appium.intro;

import com.techtorial.appium.utils.AndroidDriverUtil;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class SwipeAction {

    AndroidDriver<AndroidElement>driver;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps= AndroidDriverUtil.setupDesiredCapabilities("ApiDemos-debug");
        driver=AndroidDriverUtil.getAndroidDriver(caps);
    }
    @Test
    public void swipe(){
        AndroidElement views=driver.findElement(By.xpath(("//android.widget.TextView[@text='Views']")));
        TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(views))).perform();
        AndroidElement dateWidgets=driver.findElementByAccessibilityId("Date Widgets");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(dateWidgets))).perform();
        AndroidElement inline=driver.findElement(By.xpath("//android.widget.TextView[@text='2. Inline']"));
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(inline))).perform();
        AndroidElement num5=driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='5']"));
        num5.click();

        AndroidElement num15=driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='15']"));
        AndroidElement num40=driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='40']"));
//        touchAction.longPress(LongPressOptions.longPressOptions().withDuration(Duration.ofSeconds(2)).withElement(ElementOption.element(num15)))
//                .moveTo(ElementOption.element(num40)).perform();
        touchAction.press(ElementOption.element(num15)).moveTo(ElementOption.element(num40)).perform();
        AndroidElement hours=driver.findElementById("android:id/hours");
        AndroidElement minutes=driver.findElementById("android:id/minutes");
        AndroidElement column=driver.findElementById("android:id/separator");
        Assert.assertEquals("5:40", hours.getText()+column.getText()+minutes.getText());
    }
}
