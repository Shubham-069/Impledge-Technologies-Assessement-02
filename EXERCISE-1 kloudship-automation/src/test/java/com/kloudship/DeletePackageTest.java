package com.kloudship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeletePackageTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://ecspro-qa.kloudship.com");
        driver.manage().window().maximize();
    }

    @Test
    public void testDeletePackage() throws InterruptedException {
        // Login
        driver.findElement(By.id("email")).sendKeys("kloudship.qa.automation@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("Password1");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        Thread.sleep(3000);

        // Navigate to Package Types
        driver.findElement(By.xpath("//a[contains(text(),'Package Types')]")).click();
        Thread.sleep(2000);

        // Find the package by name and click delete
        driver.findElement(By.xpath("//td[contains(text(),'John_Doe')]/following-sibling::td/button[contains(text(),'Delete')]")).click();
        Thread.sleep(2000);

        // Confirm Delete
        driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
        Thread.sleep(3000);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
