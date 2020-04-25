package com.techtorial.appium.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ApiDemosMainPage {

    public ApiDemosMainPage(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), ApiDemosMainPage.class);
    }

    @AndroidFindBy(id="Accessibility")
    AndroidElement accessibility;

    @AndroidFindBy(accessibility = "Animation")
    AndroidElement animation;

    @AndroidFindBy(uiAutomator = "text(\"App\")")
    AndroidElement app;

    @AndroidFindBy(id = "android:id/text1")
    AndroidElement content;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Graphics']")
    AndroidElement graphics;

    @AndroidFindBy(accessibility = "Media")
    AndroidElement media;

    @AndroidFindBy(accessibility = "NFC")
    AndroidElement nfc;

    @AndroidFindBy(accessibility = "OS")
    AndroidElement os;

    @AndroidFindBy(accessibility = "Preference")
    AndroidElement preference;

    @AndroidFindBy(uiAutomator = "text(\"Text\")")
    AndroidElement text;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Views']")
    AndroidElement views;

}
