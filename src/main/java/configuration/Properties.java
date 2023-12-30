package configuration;

import java.util.Objects;

public class Properties {
  private Properties() {

  }

  public static String getStringValue(PropertyName property) {
    String propertyValue = System.getProperty(property.name());
    Objects.requireNonNull(propertyValue,
            property + " property is required in configuration.");
    return propertyValue;
  }

  public static long getLongValue(PropertyName property) {
    String propertyValue = getStringValue(property);
    return Long.parseLong(propertyValue);
  }
}