package com.cydeo.test.day1_02_05_2022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        Thread.sleep(2000);//we can use throws and try & catch.

        driver.get("https://WWW.selenium.dev");

        String expectedURL = "https://WWW.selenium.dev/";
        String actualURL= driver.getCurrentUrl();
        if (expectedURL.equals(actualURL)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

      driver.close();




    }
}
