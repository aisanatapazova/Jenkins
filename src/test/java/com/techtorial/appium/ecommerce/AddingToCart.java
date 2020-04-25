package com.techtorial.appium.ecommerce;

import com.techtorial.appium.pages.ecommercePages.AddingToCartPage;
import com.techtorial.appium.pages.ecommercePages.LoginPage;
import com.techtorial.appium.utils.AndroidDriverUtil;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;

public class AddingToCart {

    AndroidDriver<AndroidElement> driver;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities= AndroidDriverUtil.setupDesiredCapabilities("ecommerceApp");
        driver=AndroidDriverUtil.getAndroidDriver(desiredCapabilities);

    }

    @Test
    public void addingToCart() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        AddingToCartPage page=new AddingToCartPage(driver);
        //loginPage.country.click();
        //loginPage.bolivia.click();
        loginPage.nameField.sendKeys("techtorial");
        if(driver.isKeyboardShown()){
            driver.hideKeyboard();
        }
        loginPage.female.click();
        loginPage.shopButton.click();
        page.airShoes.click();
        page.addToCart.click();
        page.cartBtn.click();
        Assert.assertTrue(page.airShoes.isDisplayed());
        TouchAction touchAction=new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withDuration(Duration.ofSeconds(2))
                .withElement(ElementOption.element(page.termsBtn))).perform();
        Assert.assertEquals("Terms Of Conditions", page.termsText.getText());
        page.closeBtn.click();
        Set<String> contextHandles=driver.getContextHandles();
        System.out.println(contextHandles);
        page.visitWebBtn.click();
        Thread.sleep(3000);
        Set<String> contextHandles1=driver.getContextHandles();
        System.out.println(contextHandles1);
    }
}
