package edu.neu.ccs.cs5004;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Class for writing all messages, based on a single template for all contacts.
 */
public class BatchTemplateWriter {

  /**
   * Writes all messages, based on a single template for all contacts into a provided directory.
   *
   * @param template a provided list of strings, with [[keywords]] to be filled in
   * @param contactBook each member has an ID key and a hashmap of keywords and values
   * @param directoryPath the desired directory. "Output"
   * @throws IOException if there is an issue interacting with the file system, input/output
   */
  public static void writeTemplates(List<String> template,
      HashMap<Integer, HeaderValues> contactBook, String directoryPath)
      throws IOException {

    final String extension = new String(".txt");
    final String name = new String("message");
    final AtomicInteger counter = new AtomicInteger();
    File file = new File(directoryPath);
    file.mkdir();

    contactBook.entrySet().stream().forEach(member -> {
      try {
        TemplateWriter.writeTemplate(template,
            (HashMap<String, String>) member.getValue().getUserValues(),
            directoryPath + "//" + name + counter.getAndIncrement() + extension);
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
  }
}
