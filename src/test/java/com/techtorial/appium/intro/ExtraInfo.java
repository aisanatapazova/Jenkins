package com.techtorial.appium.intro;

import com.techtorial.appium.utils.AndroidDriverUtil;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class ExtraInfo {

    AndroidDriver<AndroidElement> driver;
    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = AndroidDriverUtil.setupDesiredCapabilities("ApiDemos-debug");
        driver = AndroidDriverUtil.getAndroidDriver(desiredCapabilities);
    }
        @Test
    public void getInfo(){
            System.out.println(driver.getContext());
            System.out.println(driver.getBatteryInfo().getState());
            System.out.println(driver.getOrientation());
            System.out.println(driver.isDeviceLocked());
            System.out.println(driver.isKeyboardShown());
            System.out.println(driver.isBrowser());
    }
}
