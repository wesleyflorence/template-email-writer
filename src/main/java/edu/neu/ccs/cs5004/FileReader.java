package edu.neu.ccs.cs5004;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Class for reading a file and passing it off to the parser, one line at a time.
 */
public class FileReader {

  /** Reads a file and passes it off to the parser.
   *
   * @param path the provided path for the file to be read from
   * @param parser the parser to be used for this type of file
   * @throws IOException if there is an issue interacting with the file system, input/output
   */
  public static void readFile(String path, IParser parser) throws IOException {
    try (Stream<String> stream = Files.lines(Paths.get(path))) {
      stream.forEach(parser::parse);
    } catch (IOException e) {
      throw new IOException("IO Exception");
    }
  }
}
