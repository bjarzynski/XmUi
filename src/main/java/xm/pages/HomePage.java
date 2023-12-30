package xm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Waits;

public class HomePage extends BasePage {
  private final NavigationMenu navigationMenu;

  @FindBy(css = "div[class*=defaultBlock] button.js-acceptDefaultCookie")
  private WebElement acceptCookiesBtn;

  public HomePage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
    this.navigationMenu = new NavigationMenu(driver);
  }

  public NavigationMenu getNavigationMenu() {
    return navigationMenu;
  }

  public void acceptCookies() {
    Waits.waitForElementToBeClickable(acceptCookiesBtn, 5L, driver);
    acceptCookiesBtn.click();
    Waits.waitForElementInVisibility(acceptCookiesBtn, 5L, driver);
  }
}

