package com.techtorial.appium.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class AccessibilityPage {


    public AccessibilityPage(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "android:id/text1")
    AndroidElement nodeProvider;

    @AndroidFindBy(accessibility = "Accessibility Node Querying")
    AndroidElement nodeQuerying;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Accessibility Service']")
    AndroidElement accessibilityService;

    @AndroidFindBy(accessibility = "Custom View")
    AndroidElement customView;

}
