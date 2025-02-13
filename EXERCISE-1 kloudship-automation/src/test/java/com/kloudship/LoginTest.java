package com.kloudship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://ecspro-qa.kloudship.com");
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("kloudship.qa.automation@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("Password1");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        Thread.sleep(3000);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
