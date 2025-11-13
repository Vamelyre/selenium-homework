package com.mariami.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTests extends BaseTest {

    @Test
    public void alertWithTextboxTest() {
        driver.get("https://demo.automationtesting.in/Alerts.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate')]")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("Mariami Tsiklauri");
        alert.accept();


        WebElement result = driver.findElement(By.id("demo1"));
        Assert.assertTrue(result.getText().contains("Mariami Tsiklauri"));
    }
}
