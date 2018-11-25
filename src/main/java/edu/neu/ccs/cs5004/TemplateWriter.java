package edu.neu.ccs.cs5004;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for writing a message, based on a template for a single member.
 */
public class TemplateWriter {

  /**
   * Writes a message, based on a template for a single member.
   *
   * @param template a provided list of strings, with [[keywords]] to be filled in
   * @param member contact information for a member, corresponding keywords with values
   * @param outputPath the output path of the files, as a string. "Output//message1.txt"
   * @throws IOException if there is an issue interacting with the file system, input/output
   */
  public static void writeTemplate(List<String> template, HashMap<String, String> member,
      String outputPath)
      throws IOException {

    try {
      Files.write(Paths.get(outputPath),
          template.stream().map(line -> fillInFields(line, member)).collect(Collectors.toList()));
    } catch (IOException e) {
      throw new IOException("IO Exception");
    }
  }

  private static String fillInFields(String line, HashMap<String, String> member) {
    return member.keySet()
        .stream()
        .reduce(line, (temp, key) -> temp.replaceAll("\\[\\[" + key + "\\]\\]",
            member.get(key)));

  }

}
