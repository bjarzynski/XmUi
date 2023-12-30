package xm.base;

import configuration.Browser;
import configuration.Properties;
import configuration.PropertyName;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
  protected WebDriver driver;
  private static final String HOME_PAGE_URL = Properties.getStringValue(PropertyName.BASE_URL);
  private static final long TIMEOUT = Properties.getLongValue(PropertyName.TIMEOUT);

  @BeforeMethod
  public void beforeTestSetup() {
    setUpDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
    driver.manage().window().maximize();
    driver.get(HOME_PAGE_URL);
  }

  @AfterMethod
  public void afterTestTeardown() {
    driver.quit();
  }

  private void setUpDriver() {
    Browser browser = Browser.fromString(Properties.getStringValue(PropertyName.BROWSER));
    setUpLocalDriver(browser);
  }

  private void setUpLocalDriver(Browser browser) {
    switch (browser) {
      case CHROME -> this.driver = WebDriverManager.chromedriver().create();
      case EDGE -> this.driver = WebDriverManager.edgedriver().create();
      case FIREFOX -> this.driver = WebDriverManager.firefoxdriver().create();
      default -> throw new UnsupportedOperationException("Unsupported browser");
    }
  }
}
