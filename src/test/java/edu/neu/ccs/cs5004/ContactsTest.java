package edu.neu.ccs.cs5004;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContactsTest {

  private Contacts testContacts;
  private ContactBook testCB;
  private String headerLine;
  private String firstLine;
  private ArrayList<String> headerArray;
  private String secondLine;
  private Contacts equalsContacts;
  private Contacts transContacts;
  private Contacts failContacts;

  @Before
  public void setUp() throws Exception {
    this.testContacts = new Contacts();
    this.testCB = new ContactBook();
    this.headerLine = "\"first_name\",\"last_name\",\"company_name\",\"address\",\"city\",\"county\",\"state\",\"zip\",\"phone1\",\"phone2\",\"email\",\"web\"";
    this.headerArray = new ArrayList<String>(Arrays.asList("first_name","last_name","company_name","address","city","county","state","zip","phone1","phone2","email","web"));
    this.firstLine = "\"James\",\"Butt\",\"Benton, John B Jr\",\"6649 N Blue Gum St\",\"New Orleans\",\"Orleans\",\"LA\",\"70116\",\"504-621-8927\",\"504-845-1427\",\"jbutt@gmail.com\",\"http://www.bentonjohnbjr.com\"";
    this.secondLine = "\"Josephine\",\"Darakjy\",\"Chanay, Jeffrey A Esq\",\"4 B Blue Ridge Blvd\",\"Brighton\",\"Livingston\",\"MI\",\"48116\",\"810-292-9388\",\"810-374-9840\",\"josephine_darakjy@darakjy.org\",\"http://www.chanayjeffreyaesq.com\"";
    this.equalsContacts = new Contacts();
    this.transContacts = new Contacts();
    this.failContacts = new Contacts();
  }

  @Test
  public void getContacts() {
    Assert.assertEquals(this.testCB, this.testContacts.getContacts());
  }

  @Test
  public void getHeaderFields() {
    this.testContacts.parse(this.headerLine);
    Assert.assertEquals(this.headerArray, this.testContacts.getHeaderFields());
  }

  @Test
  public void parse() {
    this.testContacts.parse(this.headerLine);
    this.testContacts.parse(this.firstLine);
    Assert.assertEquals("James", this.testContacts.getContacts().getContacts().get(0).getUserValues().get("first_name"));
    Assert.assertEquals("Butt", this.testContacts.getContacts().getContacts().get(0).getUserValues().get("last_name"));
    Assert.assertEquals("Benton, John B Jr", this.testContacts.getContacts().getContacts().get(0).getUserValues().get("company_name"));
    Assert.assertEquals("6649 N Blue Gum St", this.testContacts.getContacts().getContacts().get(0).getUserValues().get("address"));
    this.testContacts.parse(secondLine);
    Assert.assertEquals("Josephine", this.testContacts.getContacts().getContacts().get(1).getUserValues().get("first_name"));
    Assert.assertEquals("Darakjy", this.testContacts.getContacts().getContacts().get(1).getUserValues().get("last_name"));

  }

  @Test
  public void equals() {
    this.testContacts.parse(this.headerLine);
    this.testContacts.parse(this.firstLine);
    this.testContacts.parse(secondLine);
    this.equalsContacts.parse(headerLine);
    this.equalsContacts.parse(firstLine);
    this.equalsContacts.parse(secondLine);
    this.transContacts.parse(headerLine);
    this.transContacts.parse(firstLine);
    this.transContacts.parse(secondLine);

    Assert.assertEquals(true, this.testContacts.equals(testContacts));
    Assert.assertEquals(true, this.testContacts.equals(this.equalsContacts));
    Assert.assertEquals(true, this.equalsContacts.equals(this.transContacts));
    Assert.assertEquals(true, this.testContacts.equals(this.transContacts));
    Assert.assertEquals(false, this.testContacts.equals(null));
    Assert.assertEquals(false, this.testContacts.equals(firstLine));
    Assert.assertEquals(false, this.testContacts.equals(this.failContacts));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(this.testContacts.hashCode(), this.testContacts.hashCode());
    Assert.assertEquals(this.testContacts.hashCode(), this.equalsContacts.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("Contacts{"
        + "contacts=" + this.testContacts.getContacts()
        + ", headerFields=" + this.testContacts.getHeaderFields()
        + '}', this.testContacts.toString());
  }
}