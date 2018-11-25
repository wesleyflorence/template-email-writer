package edu.neu.ccs.cs5004;

import java.util.HashMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContactBookTest {

  private ContactBook testCB;
  private HeaderValues testHV;
  private String firstName;
  private String john;
  private ContactBook equalsCB;
  private HashMap<Integer, HeaderValues> testHM;
  private ContactBook transCB;
  private ContactBook failCB;

  @Before
  public void setUp() throws Exception {
    this.testCB = new ContactBook();
    this.testHV = new HeaderValues();
    this.firstName = "first_name";
    this.john = "John";
    this.testHV.getUserValues().put(firstName, john);
    this.testCB.getContacts().put(1, this.testHV);
    this.testHM = new HashMap<Integer, HeaderValues>();
    this.testHM.put(1, this.testHV);
    this.equalsCB = new ContactBook();
    this.equalsCB.getContacts().put(1, this.testHV);
    this.transCB = new ContactBook();
    this.transCB.getContacts().put(1, this.testHV);
    this.failCB = new ContactBook();

  }

  @Test
  public void getContacts() {
    Assert.assertEquals(this.testHM, this.testCB.getContacts());
    Assert.assertEquals(true, this.testCB.getContacts().containsKey(1));
    Assert.assertEquals(true, this.testCB.getContacts().containsValue(this.testHV));
  }

  @Test
  public void equals() {
    Assert.assertEquals(true, this.testCB.equals(testCB));
    Assert.assertEquals(true, this.testCB.equals(this.equalsCB));
    Assert.assertEquals(true, this.equalsCB.equals(this.transCB));
    Assert.assertEquals(true, this.testCB.equals(this.transCB));
    Assert.assertEquals(false, this.testCB.equals(null));
    Assert.assertEquals(false, this.testCB.equals(firstName));
    Assert.assertEquals(false, this.testCB.equals(this.failCB));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(this.testCB.hashCode(), this.testCB.hashCode());
    Assert.assertEquals(this.testCB.hashCode(), this.equalsCB.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("ContactBook{"
        + "contacts=" + this.testCB.getContacts()
        + '}', this.testCB.toString());
  }
}