package com.mariami.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormTests extends BaseTest {

    @Test
    public void fillFormTest() {
        driver.get("https://demoqa.com/automation-practice-form");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("firstName")).sendKeys("Mariami");
        driver.findElement(By.id("lastName")).sendKeys("Tsiklauri");
        driver.findElement(By.id("userEmail")).sendKeys("mariami@example.com");

        driver.findElement(By.xpath("//label[text()='Female']")).click();
        driver.findElement(By.id("userNumber")).sendKeys("555123456");

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", 
            driver.findElement(By.id("submit")));

        driver.findElement(By.xpath("//label[text()='Reading']")).click();

        
        driver.findElement(By.id("currentAddress")).sendKeys("Tbilisi, Georgia");

        driver.findElement(By.id("submit")).click();

        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.className("modal-content")));

        Assert.assertTrue(modal.getText().contains("Mariami"));
        Assert.assertTrue(modal.getText().contains("Tsiklauri"));
        Assert.assertTrue(modal.getText().contains("mariami@example.com"));
        Assert.assertTrue(modal.getText().contains("Female"));
        Assert.assertTrue(modal.getText().contains("555123456"));

        driver.findElement(By.id("closeLargeModal")).click();
    }
}
