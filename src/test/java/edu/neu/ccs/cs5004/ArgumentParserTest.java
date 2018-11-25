package edu.neu.ccs.cs5004;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class ArgumentParserTest {
  String[] badInput1 = new String[10];
  String[] badInput2 = new String[5];
  String[] badInput3 = new String[7];
  String[] goodInput = new String[7];
  String[] goodInput2 = new String[7];
  String[] goodInput3 = new String[7];
  String[] goodInput4 = new String[7];
  ArgumentParser good;
  ArgumentParser good2;
  ArgumentParser good3;
  ArgumentParser good4;


  @Before
  public void setUp() throws Exception {
    goodInput[0] = "--letter"; goodInput[1] = "--letter-template"; goodInput[2] = "letter.txt";
    goodInput[3] = "--output-dir"; goodInput[4] = "output";
    goodInput[5] = "--csv-file"; goodInput[6] = "cust.csv";
    good = new ArgumentParser(goodInput); good.setTemplateFlag(); good.setTemplate();
    good.setCsvFile(); good.setOutputDirFlag();

    goodInput2[0] = "--email"; goodInput2[1] = "--email-template"; goodInput2[2] = "email.txt";
    goodInput2[3] = "--output-dir"; goodInput2[4] = "output";
    goodInput2[5] = "--csv-file"; goodInput2[6] = "cust.csv";
    good2 = new ArgumentParser(goodInput2); good2.setTemplateFlag(); good2.setTemplate();
    good2.setCsvFile(); good2.setOutputDirFlag();

    goodInput3[0] = "--letter"; goodInput3[1] = "--letter-template"; goodInput3[2] = "letter.txt";
    goodInput3[3] = "--output-dir"; goodInput3[4] = "outpu";
    goodInput3[5] = "--csv-file"; goodInput3[6] = "cust.csv";
    good3 = new ArgumentParser(goodInput3); good3.setTemplateFlag(); good3.setTemplate();
    good3.setCsvFile(); good3.setOutputDirFlag();

    goodInput4[0] = "--letter"; goodInput4[1] = "--letter-template"; goodInput4[2] = "letter.txt";
    goodInput4[3] = "--output-dir"; goodInput4[4] = "output";
    goodInput4[5] = "--csv-file"; goodInput4[6] = "customer.csv";
    good4 = new ArgumentParser(goodInput4); good4.setTemplateFlag(); good4.setTemplate();
    good4.setCsvFile(); good4.setOutputDirFlag();

  }

  @Test (expected = IllegalArgumentException.class)
  public void tooMany() {
    ArgumentParser fail = new ArgumentParser(badInput1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void tooFew() {
    ArgumentParser fail = new ArgumentParser(badInput2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void noFlag() {
    String[] blah = new String[7];
    blah[0] = "-flag"; blah[1] = "flag"; blah[2] = "hello"; blah[3] = "yup"; blah[4] = "nope";
    blah[5] = "butt"; blah[6] = "nope";

    ArgumentParser fail = new ArgumentParser(blah);
    fail.setTemplateFlag();
  }

  @Test (expected = IllegalArgumentException.class)
  public void emailToLetter() {
    badInput3[0] = "--email"; badInput3[1] = "--letter-template"; badInput3[2] = "letter.txt";
    badInput3[3] = "--output-dir"; badInput3[4] = "output";
    badInput3[5] = "--csv-file"; badInput3[6] = ".csv";
    ArgumentParser fail = new ArgumentParser(badInput3);
    fail.setTemplateFlag();
    fail.setTemplate();
  }

  @Test (expected = IllegalArgumentException.class)
  public void emailToLetter2() {
    badInput3[0] = "--email"; badInput3[1] = "--letter-template"; badInput3[2] = "letter.tx";
    badInput3[3] = "--output-dir"; badInput3[4] = "output";
    badInput3[5] = "--csv-file"; badInput3[6] = ".csv";
    ArgumentParser fail = new ArgumentParser(badInput3);
    fail.setTemplateFlag();
    fail.setTemplate();
  }

  @Test (expected = IllegalArgumentException.class)
  public void letterToEmail() {
    badInput3[0] = "--letter"; badInput3[1] = "--email-template"; badInput3[2] = "letter.txt";
    badInput3[3] = "--output-dir"; badInput3[4] = "output";
    badInput3[5] = "--csv-file"; badInput3[6] = ".csv";
    ArgumentParser fail = new ArgumentParser(badInput3);
    fail.setTemplateFlag();
    fail.setTemplate();
  }
  @Test (expected = IllegalArgumentException.class)
  public void letterToEmail2() {
    badInput3[0] = "--letter"; badInput3[1] = "--email-template"; badInput3[2] = "letter.tx";
    badInput3[3] = "--output-dir"; badInput3[4] = "output";
    badInput3[5] = "--csv-file"; badInput3[6] = ".csv";
    ArgumentParser fail = new ArgumentParser(badInput3);
    fail.setTemplateFlag();
    fail.setTemplate();
  }

  @Test (expected = IllegalArgumentException.class)
  public void noCSVFlag() {
    badInput3[0] = "--email"; badInput3[1] = "--email-template"; badInput3[2] = "letter.txt";
    badInput3[3] = "--output-dir"; badInput3[4] = "output";
    badInput3[5] = "--csvfile"; badInput3[6] = ".csv";
    ArgumentParser fail = new ArgumentParser(badInput3);
    fail.setTemplateFlag();
    fail.setTemplate();
    fail.setCsvFile();
  }
  @Test (expected = IllegalArgumentException.class)
  public void noCSVFlag2() {
    badInput3[0] = "--email"; badInput3[1] = "--email-template"; badInput3[2] = "letter.txt";
    badInput3[3] = "--output-dir"; badInput3[4] = "output";
    badInput3[5] = "--csv-file"; badInput3[6] = ".cv";
    ArgumentParser fail = new ArgumentParser(badInput3);
    fail.setTemplateFlag();
    fail.setTemplate();
    fail.setCsvFile();
  }

  public void noOutputFlag() {
    badInput3[0] = "--email"; badInput3[1] = "--email-template"; badInput3[2] = "letter.txt";
    badInput3[3] = "--outputdir"; badInput3[4] = "output";
    badInput3[5] = "--csv-file"; badInput3[6] = ".csv";
    ArgumentParser fail = new ArgumentParser(badInput3);
    fail.setTemplateFlag();
    fail.setTemplate();
    fail.setCsvFile();
  }

  @Test
  public void getTemplate() {
    assertEquals("letter.txt", good.getTemplate());
  }

  @Test
  public void getCsv() {
    assertEquals("cust.csv", good.getCsv());
  }

  @Test
  public void getOutputDirectory() {
    assertEquals("output", good.getOutputDirectory());
  }

  @Test
  public void setTemplateFlag() {
    ArgumentParser good2 = new ArgumentParser(goodInput);
    good2.setTemplateFlag();
    good2.setTemplate();
    good2.setCsvFile();
    good2.setOutputDirFlag();
    assertEquals(good2, good);
  }

  @Test
  public void setTemplate() {
    ArgumentParser good2 = new ArgumentParser(goodInput);
    good2.setTemplateFlag();
    good2.setTemplate();
    good2.setCsvFile();
    good2.setOutputDirFlag();
    assertEquals(good2, good);
  }

  @Test
  public void setCsvFile() {
    ArgumentParser good2 = new ArgumentParser(goodInput);
    good2.setTemplateFlag();
    good2.setTemplate();
    good2.setCsvFile();
    good2.setOutputDirFlag();
    assertEquals(good2, good);
  }

  @Test
  public void setOutputDirFlag() {
    ArgumentParser good2 = new ArgumentParser(goodInput);
    good2.setTemplateFlag();
    good2.setTemplate();
    good2.setCsvFile();
    good2.setOutputDirFlag();
    assertEquals(good2, good);
  }

  @Test
  public void validate() {
    ArgumentParser good2 = new ArgumentParser(goodInput);
    good2.setTemplateFlag();
    good2.setTemplate();
    good2.setCsvFile();
    good2.setOutputDirFlag();
    assertEquals(good2, good);
  }

  @Test
  public void equals() {
    assertFalse(good.equals(null));
    assertFalse(good.equals(good2));
    assertFalse(good.equals(good3));
    assertFalse(good.equals(good4));
  }

  @Test
  public void hashCodeTest() {
    badInput3[0] = "--email"; badInput3[1] = "--email-template"; badInput3[2] = "letter.txt";
    badInput3[3] = "--outputdir"; badInput3[4] = "output";
    badInput3[5] = "--csv-file"; badInput3[6] = ".csv";
    ArgumentParser fail = new ArgumentParser(badInput3);
    assertEquals(fail.hashCode(), fail.hashCode());
  }

  @Test
  public void toStringTest() {
    badInput3[0] = "--email"; badInput3[1] = "--email-template"; badInput3[2] = "letter.txt";
    badInput3[3] = "--outputdir"; badInput3[4] = "output";
    badInput3[5] = "--csv-file"; badInput3[6] = ".csv";
    ArgumentParser fail = new ArgumentParser(badInput3);
    assertEquals("ArgumentParser{templateFlag='null', templa"
        + "te='null', csv='null', outputDirectory='null', arguments=[--email, --e"
        + "mail-template, letter.txt, --outputdir, output, --csv-file, .csv]}", fail.toString());
  }
}