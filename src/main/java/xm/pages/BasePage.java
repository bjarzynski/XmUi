package xm.pages;

import configuration.Properties;
import configuration.PropertyName;
import org.openqa.selenium.WebDriver;

public class BasePage {
  protected WebDriver driver;
  protected static final long TIMEOUT = Properties.getLongValue(PropertyName.TIMEOUT);

  public BasePage(WebDriver driver) {
    this.driver = driver;
  }
}
