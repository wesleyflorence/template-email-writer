package edu.neu.ccs.cs5004;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The list of strings that contains the template.
 */

public class Template {

  private List<String> templatesLines;

  /**
   * Creates an empty template list.
   */
  public Template() {
    this.templatesLines = new ArrayList<String>();
  }

  /**
   * Returns the list for the template.
   * @return the list for the template
   */
  public List<String> getTemplatesLines() {
    return templatesLines;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Template template = (Template) obj;
    return Objects.equals(templatesLines, template.templatesLines);
  }

  @Override
  public int hashCode() {

    return Objects.hash(templatesLines);
  }

  @Override
  public String toString() {
    return "Template{"
        + "templatesLines=" + templatesLines
        + '}';
  }
}
