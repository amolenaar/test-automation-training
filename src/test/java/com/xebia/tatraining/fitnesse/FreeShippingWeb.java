package com.xebia.tatraining.fitnesse;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FreeShippingWeb {
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

    public void setBooks(final int books) {
        final List<WebElement> products = driver.findElements(By.cssSelector(".product"));
        for (int i = 0; i < books; i++) {
            products.get(0).findElement(By.tagName("a" )).click();
        }
    }

    public String totalPrice() {
        driver.findElement(By.tagName("button")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();
        return text.substring(13, text.length() - 1);
    }

}
