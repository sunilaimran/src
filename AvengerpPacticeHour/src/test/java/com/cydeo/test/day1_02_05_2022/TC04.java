package com.cydeo.test.day1_02_05_2022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.IllegalFormatCodePointException;

public class TC04 {
    private static WebDriver driver;
    public static void main(String[] args) {

       //- Go to "https://app.vytrack.com/user/login"
        forEachVerification("https://app.vytrack.com/user/login");

        //- Verify the url contains "vytrack"
        verifyingURLContains("vytrack");


        //- Verify the title contains "Login"
        verifyingTitleContains("Login");



        //- Verify the label "Login"
        verifyingLable("Login");

        //login
        login("abcd","abcd");


        //- Verify the message "Invalid user name or password"
          verifyingMessage("Invalid user name and password.");

        driver.close();



    }

    private static void verifyingMessage(String expectedMessage) {
        WebElement messageElement =driver.findElement(By.className("alert"));
        String actualMessage= messageElement.getText();

        if (actualMessage.equals(expectedMessage)){
            System.out.println("Message is passed!");
        }else{
            System.out.println("Failed");
        }

    }

    private static void login(String userName, String pasword) {
        WebElement usernameWebElement = driver.findElement(By.name("_username"));
        usernameWebElement.sendKeys(userName);

        WebElement passWordWebElement = driver.findElement(By.id("prependedInput2"));
        passWordWebElement.sendKeys(pasword);


    }

    private static void verifyingLable(String expectedLable) {
        WebElement lableElement = driver.findElement(By.tagName("h2"));
        String actualLabletext = lableElement.getText();
        if (actualLabletext.contains(expectedLable)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
    }

    private static void verifyingTitleContains(String excpectedWord) {
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(excpectedWord)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
    }

    private static void verifyingURLContains(String expectedWord) {

        String actualURL = driver.getCurrentUrl();
        if (actualURL.contains(expectedWord)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
    }


    private static void forEachVerification(String url) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
}
