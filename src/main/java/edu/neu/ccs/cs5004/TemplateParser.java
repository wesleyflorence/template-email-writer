package edu.neu.ccs.cs5004;

import java.util.Objects;

/**
 * The parser for a template to be used in correspondence.
 */
public class TemplateParser implements IParser {

  private Template correspondence;

  /**
   * Creates an empty template.
   */
  public TemplateParser() {
    this.correspondence = new Template();
  }

  /**
   * Returns the correspondence template list.
   * @return the correspondence template list
   */
  public Template getCorrespondence() {
    return correspondence;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void parse(String line) {
    this.correspondence.getTemplatesLines().add(line);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    TemplateParser that = (TemplateParser) obj;
    return Objects.equals(correspondence, that.correspondence);
  }

  @Override
  public int hashCode() {

    return Objects.hash(correspondence);
  }

  @Override
  public String toString() {
    return "TemplateParser{"
        + "correspondence=" + correspondence
        + '}';
  }
}
