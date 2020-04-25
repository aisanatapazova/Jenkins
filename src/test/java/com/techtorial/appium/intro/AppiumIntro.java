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

public class AppiumIntro {

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
    public void firstCall() {
        AndroidElement preference =driver.findElementByAccessibilityId("Preference");
        preference.click();
        AndroidElement defaultValues=driver.findElementByAccessibilityId("4. Default values");
        defaultValues.click();
        AndroidElement checkBox=driver.findElement(By.id("android:id/checkbox"));
        checkBox.click();
    }

   @Test
    public void secondCall(){
        AndroidElement media=driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Media']"));
        media.click();
   }
}
