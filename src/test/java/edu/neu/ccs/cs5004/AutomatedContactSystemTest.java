package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class AutomatedContactSystemTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void main() {
    String[] args = new String[]{"--email", "--email-template", "emailtemplate.txt", "--output-dir", "MainOutputTest", "--csv-file", "theater_company_members_small.csv"};
    try {
      AutomatedContactSystem.main(args);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}