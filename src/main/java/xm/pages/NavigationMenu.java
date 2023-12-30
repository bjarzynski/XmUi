package xm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Waits;

public class NavigationMenu extends BasePage {
  @FindBy(css = "li.main_nav_research")
  private WebElement researchEducationMenuItem;
  @FindBy(css = "li.menu-research > a[href*=economicCalendar]")
  private WebElement economicCalendarMenuItem;
  @FindBy(css = "li.menu-tutorials > a[href*=educational-videos]")
  private WebElement educationalVideosMenuItem;

  public NavigationMenu(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public void openResearchEducationMenu() throws InterruptedException {
    Waits.waitForElementVisibility(researchEducationMenuItem, 5L, driver);
    Waits.waitForElementToBeClickable(researchEducationMenuItem, 5L, driver);
    Thread.sleep(1000);
    researchEducationMenuItem.click();
  }

  public EconomicCalendarPage openEconomicCalendarPage() {
    Waits.waitForElementVisibility(economicCalendarMenuItem, 5L, driver);
    economicCalendarMenuItem.click();
    return PageFactory.initElements(driver, EconomicCalendarPage.class);
  }

  public EducationalVideosPage openEducationalVideos() {
    educationalVideosMenuItem.click();
    return PageFactory.initElements(driver, EducationalVideosPage.class);
  }

}
