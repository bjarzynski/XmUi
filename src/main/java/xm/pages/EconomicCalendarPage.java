package xm.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EconomicCalendarPage extends BasePage {
  @FindBy(css = "mat-slider[role=slider]")
  private WebElement calendarSlider;
  @FindBy(css = "span.tc-finalval-tmz > div")
  private WebElement calendarLabel;
  @FindBy(css = "#economic-calendar-list > div > div:nth-child(1) span[class*=left-title]")
  private WebElement dateTitle;

  public EconomicCalendarPage(WebDriver driver) {
    super(driver);
  }

  public void moveRightSlider() {
    calendarSlider.sendKeys(Keys.RIGHT);
  }

  public String getCalendarLabelTxt() {
    return calendarLabel.getText();
  }

  public String getDateTitle() {
    return dateTitle.getText();
  }

  public void switchToBodyFrame() {
    driver.switchTo().frame("iFrameResizer0");
  }

  public void switchToMainFrame() {
    driver.switchTo().defaultContent();
  }
}
