package xm.education;

import org.testng.annotations.Test;
import utils.DateUtils;
import xm.base.TestBase;
import xm.pages.EconomicCalendarPage;
import xm.pages.EducationalVideosPage;
import xm.pages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CalendarVideoTest extends TestBase {
  @Test
  public void checkCalendarAndVideo() throws InterruptedException {
    HomePage homePage = new HomePage(driver);
    homePage.acceptCookies();
    homePage.getNavigationMenu().openResearchEducationMenu();
    EconomicCalendarPage economicCalendarPage = homePage.getNavigationMenu().openEconomicCalendarPage();
    economicCalendarPage.switchToBodyFrame();
    economicCalendarPage.moveRightSlider();
    assertThat(economicCalendarPage.getCalendarLabelTxt(), is("Today"));
    assertThat(economicCalendarPage.getDateTitle(), is(DateUtils.getTodayDate()));
    economicCalendarPage.moveRightSlider();
    assertThat(economicCalendarPage.getCalendarLabelTxt(), is("Tomorrow"));
    assertThat(economicCalendarPage.getDateTitle(), is(DateUtils.getTomorrowDate()));
    economicCalendarPage.moveRightSlider();
    economicCalendarPage.moveRightSlider();
    assertThat(economicCalendarPage.getCalendarLabelTxt(), is("Next Week"));
    assertThat(economicCalendarPage.getDateTitle(), is(DateUtils.getFirstDayOfNextWeekDate()));
    economicCalendarPage.switchToMainFrame();
    homePage.getNavigationMenu().openResearchEducationMenu();
    EducationalVideosPage educationalVideosPage = homePage.getNavigationMenu().openEducationalVideos();
    educationalVideosPage.openPlaylistGroup("Intro to the Markets");
    educationalVideosPage.openLesson("1.1");
    educationalVideosPage.clickVideoPlayer();
    educationalVideosPage.wait5secIfVideoIsPlaying();
  }
}
