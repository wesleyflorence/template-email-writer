package edu.neu.ccs.cs5004;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The data structure holding the user's information based on the header.
 */

public class HeaderValues {

  private Map<String, String> userValues;

  /**
   * Creates and empty header value map.
   */
  public HeaderValues() {
    this.userValues = new HashMap<String, String>();
  }

  /**
   * Creates instance of header values.
   * @param userValues the hashmap to create
   */
  public HeaderValues(Map<String, String> userValues) {
    this.userValues = userValues;
  }


  /**
   * Returns the user's information.
   * @return the user's information
   */
  public Map<String, String> getUserValues() {
    return userValues;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    HeaderValues that = (HeaderValues) obj;
    return Objects.equals(userValues, that.userValues);
  }

  @Override
  public int hashCode() {

    return Objects.hash(userValues);
  }

  @Override
  public String toString() {
    return "HeaderValues{"
        + "userValues=" + userValues
        + '}';
  }
}
