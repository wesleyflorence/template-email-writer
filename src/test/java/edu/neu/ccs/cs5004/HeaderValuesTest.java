package edu.neu.ccs.cs5004;

import java.util.HashMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeaderValuesTest {

  private HeaderValues testHV;
  private String firstName;
  private String john;
  private HashMap<String, String> test;
  private HeaderValues equalsHV;
  private HeaderValues transHV;
  private HeaderValues failHV;

  @Before
  public void setUp() throws Exception {
    this.testHV = new HeaderValues();
    this.firstName = "first_name";
    this.john = "John";
    this.testHV.getUserValues().put(firstName, john);
    this.test = new HashMap<>();
    this.test.put(firstName, john);
    this.equalsHV = new HeaderValues();
    this.equalsHV.getUserValues().put(firstName, john);
    this.transHV = new HeaderValues();
    this.transHV.getUserValues().put(firstName, john);
    this.failHV = new HeaderValues();
  }

  @Test
  public void getUserValues() {
    Assert.assertEquals(this.test, this.testHV.getUserValues());
  }

  @Test
  public void equals() {
    Assert.assertEquals(true, this.testHV.equals(testHV));
    Assert.assertEquals(true, this.testHV.equals(this.equalsHV));
    Assert.assertEquals(true, this.equalsHV.equals(this.transHV));
    Assert.assertEquals(true, this.testHV.equals(this.transHV));
    Assert.assertEquals(false, this.testHV.equals(null));
    Assert.assertEquals(false, this.testHV.equals(firstName));
    Assert.assertEquals(false, this.testHV.equals(this.failHV));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(this.testHV.hashCode(), this.testHV.hashCode());
    Assert.assertEquals(this.testHV.hashCode(), this.equalsHV.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("HeaderValues{"
        + "userValues=" + this.testHV.getUserValues()
        + '}', this.testHV.toString());
  }
}