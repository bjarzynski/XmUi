package utils;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.TemporalAdjusters.next;

public class DateUtils {
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMM dd");

  private DateUtils() {
  }

  public static String getTodayDate() {
    return LocalDateTime.now().format(formatter);
  }

  public static LocalDateTime getCurrentTime() {
    return LocalDateTime.now();
  }

  public static String getTomorrowDate() {
    return LocalDateTime.from(LocalDateTime.now().plusDays(1)).format(formatter);
  }

  public static String getFirstDayOfNextWeekDate() {
    return LocalDateTime.now().with(next(DayOfWeek.MONDAY)).format(formatter);
  }
}
