package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TemplateParserTest {

  private TemplateParser testParser;
  private Template testTemplate;
  private String template1 = "Add me";
  private String template2 = "Second one";
  private TemplateParser equalsTemplate;
  private TemplateParser transTemplate;
  private TemplateParser failTemplate;

  @Before
  public void setUp() throws Exception {
    this.testParser = new TemplateParser();
    this.testParser.parse(template1);
    this.testParser.parse(template2);
    this.testTemplate = new Template();
    this.testTemplate.getTemplatesLines().add(template1);
    this.testTemplate.getTemplatesLines().add(template2);
    this.equalsTemplate = new TemplateParser();
    this.equalsTemplate.parse(template1);
    this.equalsTemplate.parse(template2);
    this.transTemplate = new TemplateParser();
    this.transTemplate.parse(template1);
    this.transTemplate.parse(template2);
    this.failTemplate = new TemplateParser();
  }

  @Test
  public void getCorrespondence() {
    Assert.assertEquals(this.testTemplate, this.testParser.getCorrespondence());
  }

  @Test
  public void parse() {
    Assert.assertEquals(this.testTemplate, this.testParser.getCorrespondence());
  }

  @Test
  public void equals() {
    Assert.assertEquals(true, this.testParser.equals(testParser));
    Assert.assertEquals(true, this.testParser.equals(this.equalsTemplate));
    Assert.assertEquals(true, this.equalsTemplate.equals(this.transTemplate));
    Assert.assertEquals(true, this.testParser.equals(this.transTemplate));
    Assert.assertEquals(false, this.testParser.equals(null));
    Assert.assertEquals(false, this.testParser.equals(testTemplate));
    Assert.assertEquals(false, this.testParser.equals(this.failTemplate));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(this.testParser.hashCode(), this.testParser.hashCode());
    Assert.assertEquals(this.testParser.hashCode(), this.equalsTemplate.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("TemplateParser{"
        + "correspondence=" + this.testParser.getCorrespondence()
        + '}', this.testParser.toString());
  }
}