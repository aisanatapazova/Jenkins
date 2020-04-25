package com.techtorial.appium.ecommerce;

import com.techtorial.appium.pages.ecommercePages.AddingToCartPage;
import com.techtorial.appium.pages.ecommercePages.LoginPage;
import com.techtorial.appium.utils.AndroidDriverUtil;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class EcommerceIntro {

    AndroidDriver<AndroidElement> driver;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities= AndroidDriverUtil.setupDesiredCapabilities("ecommerceApp");
        driver=AndroidDriverUtil.getAndroidDriver(desiredCapabilities);

    }

    @Test
    public void test1(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.country.click();
        loginPage.bolivia.click();
        loginPage.nameField.sendKeys("techtorial");
        if(driver.isKeyboardShown()){
            driver.hideKeyboard();
        }
        loginPage.female.click();
        loginPage.shopButton.click();
    }

    @Test
    public void negativeTest(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.shopButton.click();
        String message=loginPage.toastMessage.getAttribute("name");
        Assert.assertEquals("Please enter your name", message);
    }




}
