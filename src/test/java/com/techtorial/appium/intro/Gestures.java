package com.techtorial.appium.intro;

import com.techtorial.appium.utils.AndroidDriverUtil;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Gestures {

    DesiredCapabilities desiredCapabilities;
    AndroidDriver<AndroidElement> driver;
    URL appiumServerUrl;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps= AndroidDriverUtil.setupDesiredCapabilities("ApiDemos-debug");
        driver=AndroidDriverUtil.getAndroidDriver(caps);
    }

    @Test
    public void tapGestures(){
        AndroidElement media=driver.findElementByAndroidUIAutomator("text(\"Media\")");
        TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(media))).perform();

    }

    @Test
    public void tapGestures2(){
        AndroidElement views=driver.findElement(By.xpath(("//android.widget.TextView[@text='Views']")));
        TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(views))).perform();
        AndroidElement list=driver.findElementByAccessibilityId("Expandable Lists");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(list))).perform();
        AndroidElement custom=driver.findElementByAccessibilityId("1. Custom Adapter");
        custom.click();
        AndroidElement catNames=driver.findElement(By.xpath("//android.widget.TextView[@text='Cat Names']"));
        Assert.assertEquals(catNames.getText(), "Cat Names");
    }

    @Test
    public void longPress(){
        AndroidElement views=driver.findElement(By.xpath(("//android.widget.TextView[@text='Views']")));
        TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(views))).perform();
        AndroidElement list=driver.findElementByAccessibilityId("Expandable Lists");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(list))).perform();
        AndroidElement custom=driver.findElementByAccessibilityId("1. Custom Adapter");
        custom.click();
        AndroidElement peopleNames=driver.findElementByAndroidUIAutomator("text(\"People Names\")");
        touchAction.longPress(LongPressOptions.longPressOptions().withDuration(Duration.ofSeconds(2))
                .withElement(ElementOption.element(peopleNames))).perform();
        AndroidElement sampleMenu=driver.findElementByAndroidUIAutomator("text(\"Sample menu\")");
        Assert.assertEquals(sampleMenu.getText(), "Sample menu");
        Assert.assertTrue("Failed to verify text", sampleMenu.isDisplayed());

    }

    @Test
    public void longPress1() {
        AndroidElement views = driver.findElement(By.xpath(("//android.widget.TextView[@text='Views']")));
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(views))).perform();
        AndroidElement list = driver.findElementByAccessibilityId("Expandable Lists");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(list))).perform();
        AndroidElement custom = driver.findElementByAccessibilityId("1. Custom Adapter");
        custom.click();
        AndroidElement fishNames = driver.findElementByAndroidUIAutomator("text(\"Fish Names\")");
        fishNames.click();
        List<AndroidElement> fishes = new ArrayList<>();
        AndroidElement bubbles = driver.findElementByAndroidUIAutomator("text(\"Bubbles\")");
        AndroidElement goldy = driver.findElementByAndroidUIAutomator("text(\"Goldy\")");
        fishes.add(bubbles);
        fishes.add(goldy);
        for (AndroidElement element : fishes) {
            Assert.assertTrue(element.isDisplayed());
            touchAction.longPress(LongPressOptions.longPressOptions().withDuration(Duration.ofSeconds(2))
                    .withElement(ElementOption.element(fishNames))).perform();

        }
    }
}
