package com.techtorial.appium.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidDriverUtil {

    public static AndroidDriver getAndroidDriver(DesiredCapabilities caps) throws MalformedURLException {
       URL appiumServerUrl=new URL("http://localhost:4723/wd/hub");
        //instantiating the driver
       AndroidDriver driver=new AndroidDriver(appiumServerUrl, caps);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public static DesiredCapabilities setupDesiredCapabilities(String appName){
        File apkFile=new File("src/test/resources/"+appName+".apk");
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        //device name to connect
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Appium Intro");
        //platform name
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        //automation name
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        //android application to test
        desiredCapabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
        //setting the url server to connect to
        return desiredCapabilities;
    }
}
