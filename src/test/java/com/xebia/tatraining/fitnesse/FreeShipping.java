package com.xebia.tatraining.fitnesse;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FreeShipping {
    private FirefoxDriver driver;

    public void beginTable() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8000");
    }

    public void endTable() {
        driver.quit();
    }

    public void reset() {
        driver.navigate().refresh();
    }

}
