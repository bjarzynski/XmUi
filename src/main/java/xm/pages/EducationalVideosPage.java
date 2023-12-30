package xm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class EducationalVideosPage extends BasePage {
  @FindBy(css = "iframe.sproutvideo-player")
  private WebElement videoPlayer;
  @FindBy(css = "div.player")
  private WebElement playerDesc;

  public EducationalVideosPage(WebDriver driver) {
    super(driver);
  }

  public void openLesson(String lessonNumber) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    WebElement lesson = driver.findElement(
            By.xpath("//*[@id='js-videoPlaylist']//*[@class='js-video-item'][text()='Lesson " + lessonNumber + " ']"));
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
                    .withTimeout(Duration.ofSeconds(5))
                    .pollingEvery(Duration.ofMillis(300));

    wait.until(d -> isVideoPlaying());
  }

  private boolean isVideoPlaying() {
    return playerDesc.getAttribute("class").contains("playing");
  }
}
