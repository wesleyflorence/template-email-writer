package edu.neu.ccs.cs5004;

import java.io.IOException;
import java.util.HashMap;

/**
 * Main method class, runs the application.
 */
public class AutomatedContactSystem {

  /**
   * Main method, takes in a String array of arguments and produces
   * a directory with the parsed template files in them.
   * @param args arguments for the argument parser
   * @throws IOException if there is an error reading or writing to files
   */
  public static void main(String[] args) throws IOException {
    ArgumentParser arguments = new ArgumentParser(args);
    arguments.validate();
    Contacts patrons = new Contacts();
    FileReader.readFile(arguments.getCsv(), patrons);
    TemplateParser template = new TemplateParser();
    FileReader.readFile(arguments.getTemplate(), template);

    BatchTemplateWriter.writeTemplates(template.getCorrespondence().getTemplatesLines(),
        (HashMap<Integer, HeaderValues>) patrons.getContacts().getContacts(),
        arguments.getOutputDirectory());
  }

}
