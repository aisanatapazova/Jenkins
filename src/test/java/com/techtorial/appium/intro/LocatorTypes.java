package com.techtorial.appium.intro;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LocatorTypes {

    DesiredCapabilities desiredCapabilities;
    AndroidDriver<AndroidElement> driver;
    URL appiumServerUrl;
    @Before
    public void setup() throws MalformedURLException {
        File apkFile=new File("src/test/resources/ApiDemos-debug.apk");
        desiredCapabilities=new DesiredCapabilities();
        //device name to connect
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Appium Intro");
        //platform name
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        //automation name
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        //android application to test
        desiredCapabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
        //setting the url server to connect to
        appiumServerUrl=new URL("http://localhost:4723/wd/hub");
        //instantiating the driver
        driver=new AndroidDriver(appiumServerUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void locators(){
        AndroidElement accessibility=driver.findElementByAccessibilityId("Accessibility");
        accessibility.click();
        AndroidElement customView=driver.findElement(By.xpath("//android.widget.TextView[@text='Custom View']"));
        customView.click();
    }

    @Test
    public void locators2(){
        //resource-id==id in selenium
        AndroidElement views=driver.findElement(By.xpath(("//android.widget.TextView[@text='Views']")));
        views.click();

        //"attribute("value")"
        AndroidElement chronometer=driver.findElementByAndroidUIAutomator("text(\"Chronometer\")");
        chronometer.click();

    }

}
