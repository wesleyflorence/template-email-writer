package edu.neu.ccs.cs5004;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TemplateTest {

  private Template testTemplate;
  private String template1 = "Add me";
  private String template2 = "Second one";
  private ArrayList<String> compare;
  private Template equalsTemplate;
  private Template transTemplate;
  private Template failTemplate;

  @Before
  public void setUp() throws Exception {
    this.testTemplate = new Template();
    this.testTemplate.getTemplatesLines().add(template1);
    this.testTemplate.getTemplatesLines().add(template2);
    this.compare = new ArrayList<>(Arrays.asList(template1, template2));
    this.equalsTemplate = new Template();
    this.equalsTemplate.getTemplatesLines().add(template1);
    this.equalsTemplate.getTemplatesLines().add(template2);
    this.transTemplate = new Template();
    this.transTemplate.getTemplatesLines().add(template1);
    this.transTemplate.getTemplatesLines().add(template2);
    this.failTemplate = new Template();
  }

  @Test
  public void getTemplatesLines() {
    Assert.assertEquals(this.compare, this.testTemplate.getTemplatesLines());
  }

  @Test
  public void equals() {
    Assert.assertEquals(true, this.testTemplate.equals(testTemplate));
    Assert.assertEquals(true, this.testTemplate.equals(this.equalsTemplate));
    Assert.assertEquals(true, this.equalsTemplate.equals(this.transTemplate));
    Assert.assertEquals(true, this.testTemplate.equals(this.transTemplate));
    Assert.assertEquals(false, this.testTemplate.equals(null));
    Assert.assertEquals(false, this.testTemplate.equals(compare));
    Assert.assertEquals(false, this.testTemplate.equals(this.failTemplate));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(this.testTemplate.hashCode(), this.testTemplate.hashCode());
    Assert.assertEquals(this.testTemplate.hashCode(), this.equalsTemplate.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("Template{"
        + "templatesLines=" + this.testTemplate.getTemplatesLines()
        + '}', this.testTemplate.toString());
  }
}