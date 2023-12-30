package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

  private Waits() {

  }

  public static void waitForElementVisibility(WebElement element, long seconds, WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  public static void waitForElementToBeClickable(WebElement element, long seconds, WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  public static void waitForElementInvisibility(WebElement element, long seconds, WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    wait.until(ExpectedConditions.invisibilityOf(element));
  }
}
