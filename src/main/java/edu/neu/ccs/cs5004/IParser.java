package edu.neu.ccs.cs5004;

/**
 * Parser for documents.
 */

public interface IParser {

  /**
   * Reads a line and fills in the appropriate data structure.
   *
   * @param line the line being read and put into our data structure.
   */
  void parse(String line);

}
