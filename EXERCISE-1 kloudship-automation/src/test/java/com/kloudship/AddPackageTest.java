package com.kloudship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class AddPackageTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://ecspro-qa.kloudship.com");
        driver.manage().window().maximize();
    }

    @Test
    public void testAddPackage() throws InterruptedException {
        // Login
        driver.findElement(By.id("email")).sendKeys("kloudship.qa.automation@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("Password1");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        Thread.sleep(3000);

        // Navigate to Package Types
        driver.findElement(By.xpath("//a[contains(text(),'Package Types')]")).click();
        Thread.sleep(2000);

        // Click Add Manually
        driver.findElement(By.xpath("//button[contains(text(),'Add Manually')]")).click();
        Thread.sleep(2000);

        // Enter Package Details
        driver.findElement(By.id("packageName")).sendKeys("John_Doe");

        // Generate Random Dimensions
        Random rand = new Random();
        int dimension = rand.nextInt(20); // Random int less than 20
        driver.findElement(By.id("packageDimension")).sendKeys(String.valueOf(dimension));

        // Save Package
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
        Thread.sleep(3000);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
