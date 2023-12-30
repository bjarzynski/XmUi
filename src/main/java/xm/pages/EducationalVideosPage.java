package xm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utils.DateUtils;
import utils.Waits;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EducationalVideosPage extends BasePage {
  @FindBy(css = "iframe.sproutvideo-player")
  private WebElement videoPlayer;
  @FindBy(css = "div.player")
  private WebElement playerDesc;

  public EducationalVideosPage(WebDriver driver) {
    super(driver);
  }

  public void openLesson(String lessonNumber) {
    WebElement lesson = driver.findElement(
            By.xpath("//*[@id='js-videoPlaylist']//*[@class='js-video-item'][text()='Lesson " + lessonNumber + " ']"));
    Waits.waitForElementToBeClickable(lesson, TIMEOUT, driver);
    lesson.click();
  }

  public void openPlaylistGroup(String groupName) {
    WebElement playlistGroup = driver.findElement(By.xpath("//*[@id='js-videoPlaylist']//button[text()='" + groupName + "']"));
    playlistGroup.click();
  }

  public void clickVideoPlayer() {
    driver.switchTo().frame(videoPlayer);
    playerDesc.click();
  }

  public void wait5secIfVideoIsPlaying() {
    Wait<WebDriver> wait =
            new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofMillis(300));

    LocalDateTime now = DateUtils.getCurrentTime();
    wait.until(d ->
    {
      assertThat(isVideoPlaying(), is(true));
      return ChronoUnit.SECONDS.between(now, DateUtils.getCurrentTime()) > 5;
    });
  }

  private boolean isVideoPlaying() {
    return playerDesc.getAttribute("class").contains("playing");
  }
}
