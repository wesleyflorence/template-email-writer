package edu.neu.ccs.cs5004;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class BatchTemplateWriterTest {

  public List<String> template = new ArrayList<>();
  public HashMap<String, String> member1 = new HashMap<>();
  public HashMap<String, String> member2 = new HashMap<>();
  public HashMap<String, String> member3 = new HashMap<>();
  public HashMap<Integer, HeaderValues> contacts = new HashMap<>();

  public HeaderValues header1 = new HeaderValues(member1);
  public HeaderValues header2 = new HeaderValues(member2);
  public HeaderValues header3 = new HeaderValues(member3);

  public ContactBook book = new ContactBook(contacts);

  @Before
  public void setUp() throws Exception {
    template.add("From:thetheatercompany@tc.com\n");
    template.add("To:[[email]]\n");
    template.add("Subject:Information on this years members only show!\n");
    template.add("\n");
    template.add("Dear [[first_name]] [[last_name]], \n");
    template.add("\n");
    template.add("   This year's members only theater show will showcase \"A Streetcar\n");
    template.add("   Named Desire\" directed by John Jarmush and Susan Mae at our New\n");
    template.add("   York location between March 1st and April 10th.  Your complementary\n");
    template.add("   tickets for the show are on their way through mail and should\n");
    template.add("   reach you within the next couple of days.\n");
    template.add("\n");
    template.add("   Sincerely, \n");

    member1.put("email", "bob@yahoo.com");
    member1.put("first_name", "Bob");
    member1.put("last_name", "Jones");

    member2.put("email", "carly@yahoo.com");
    member2.put("first_name", "Carly");
    member2.put("last_name", "Jones");

    member2.put("email", "eric@gmail.com");
    member2.put("first_name", "Eric");
    member2.put("last_name", "Cunningham");

    contacts.put(0, header1);
    contacts.put(1, header2);
    contacts.put(2, header3);
  }

  @Test
  public void writeTemplates() throws IOException {
    BatchTemplateWriter.writeTemplates(template, contacts, "BatchWriterTest");
  }
}