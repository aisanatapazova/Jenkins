package com.techtorial.appium.pages.ecommercePages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    public LoginPage(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    public AndroidElement country;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector())" +
            ".scrollIntoView(text(\"Bolivia\"));")
    public AndroidElement bolivia;

    @AndroidFindBy(uiAutomator = "text(\"Enter name here\")")
    public AndroidElement nameField;

    @AndroidFindBy(uiAutomator = "text(\"Female\")")
    public AndroidElement female;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    public AndroidElement shopButton;

    @AndroidFindBy(xpath = "//android.widget.Toast")
    public AndroidElement toastMessage;
}
