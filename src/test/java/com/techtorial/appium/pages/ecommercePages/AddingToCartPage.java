package com.techtorial.appium.pages.ecommercePages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class AddingToCartPage {

    public AddingToCartPage(AndroidDriver driver){

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector())" +
            " .scrollIntoView(text(\"Air Jordan 9 Retro\"));")
    public AndroidElement airShoes;

    @AndroidFindBy(uiAutomator = "text(\"ADD TO CART\")")
    public AndroidElement addToCart;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    public AndroidElement cartBtn;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    public AndroidElement termsBtn;

    @AndroidFindBy(uiAutomator = "text(\"Terms Of Conditions\")")
    public AndroidElement termsText;

    @AndroidFindBy(uiAutomator = "text(\"CLOSE\")")
    public AndroidElement closeBtn;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    public AndroidElement visitWebBtn;

}
