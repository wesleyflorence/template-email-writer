package edu.neu.ccs.cs5004;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TemplateWriterTest {
  public List<String> template = new ArrayList<>();
  public HashMap<String, String> members = new HashMap<>();

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

    members.put("email", "bob@yahoo.com");
    members.put("first_name", "Bob");
    members.put("last_name", "Jones");
  }

  @Test
  public void writeTemplate() throws IOException {
    TemplateWriter.writeTemplate(template, members, "TESToutput.txt");
  }
}