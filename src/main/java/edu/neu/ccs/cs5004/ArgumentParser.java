package edu.neu.ccs.cs5004;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * This class helps us validate the inputs on the command line. It throws an exception if the inputs
 * are not valid. Otherwise, its all good.
 */
public class ArgumentParser {

  private String templateFlag; //--email OR --letter
  private String template; //ends in .txt
  private String csv; //ends in .csv
  private String outputDirectory; //must be a valid directory? ASK TAMARA
  private String[] arguments;

  /**
   * This creates an instance of an argument parser.
   *
   * @param commandLineArguments the input from the command line.
   * @throws IllegalArgumentException if the inputs are not valid.
   */
  ArgumentParser(String[] commandLineArguments) throws IllegalArgumentException {
    if (commandLineArguments.length > 7) {
      throw new IllegalArgumentException("Too many arguments!");
    } else if (commandLineArguments.length < 7) {
      throw new IllegalArgumentException("Too few arguments!");
    } else {
      this.arguments = commandLineArguments;
    }
  }

  /**
   * Retrieves the template from the argument parser.
   *
   * @return String representation of the file template.
   */
  public String getTemplate() {
    return template;
  }

  /**
   * Retrieves the csv file from the argument parser.
   *
   * @return String representation of the csv file.
   */
  public String getCsv() {
    return csv;
  }

  /**
   * Retrieves the output directory from the argument parser.
   *
   * @return String representation of the output directory.
   */
  public String getOutputDirectory() {
    return outputDirectory;
  }

  /**
   * Searches and helps validate the template flag.
   *
   * @throws IllegalArgumentException if an appropriate flag is not found.
   */
  protected void setTemplateFlag() throws IllegalArgumentException {
    for (String item : this.arguments) {
      if (item.equals("--email") || item.equals("--letter")) {
        this.templateFlag = item;
        return;
      }
    }
    /*for(int i = 0; i <this.arguments.length; i++){
      if(arguments[i].equals("--email") || arguments[i].equals("--letter")) {
        this.templateFlag = arguments[i];
        return;
      }
    }*/
    throw new IllegalArgumentException("input arguments must contain a --email or --letter flag");
  }

  /**
   * Sets the template to the appropriate value.
   *
   * @throws IllegalArgumentException if the template flag does not match.
   */
  protected void setTemplate() throws IllegalArgumentException {
    if (this.templateFlag.equals("--email")) {
      for (int i = 0; i < arguments.length - 1; i++) {
        if (arguments[i].equals("--email-template")
            && arguments[i + 1].endsWith(".txt")) {
          this.template = arguments[i + 1];
          return;
        }
      }
      throw new IllegalArgumentException("the flag was --email but input arguments "
          + "lacked --email-template and a .txt file");
    } else if (this.templateFlag.equals("--letter")) {
      for (int i = 0; i < arguments.length - 1; i++) {
        if (arguments[i].equals("--letter-template")
            && arguments[i + 1].endsWith(".txt")) {
          this.template = arguments[i + 1];
          return;
        }
      }
      throw new IllegalArgumentException("the flag was --letter but input arguments "
          + "lacked --letter-template and a .txt file");
    }
  }

  /**
   * Sets the csv file to the appropriate value.
   *
   * @throws IllegalArgumentException if the csv is not found.
   */
  protected void setCsvFile() throws IllegalArgumentException {
    for (int i = 0; i < arguments.length - 1; i++) {
      if (arguments[i].equals("--csv-file")
          && arguments[i + 1].endsWith(".csv")) {
        this.csv = arguments[i + 1];
        return;
      }
    }
    throw new IllegalArgumentException("lacked the appropiate --csv-file flag followed"
        + "by a csv file");
  }

  /**
   * Sets the output directory to the correct name.
   *
   * @throws IllegalArgumentException if the appropriate output directory is not put in.
   */
  protected void setOutputDirFlag() throws IllegalArgumentException {
    for (int i = 0; i < arguments.length - 1; i++) {
      if (arguments[i].equals("--output-dir")) {
        this.outputDirectory = arguments[i + 1];
        return;
      }
    }
    throw new IllegalArgumentException("lacked the appropiate --output-dir flag followed"
        + "by the output directory. --output-dir flag cannot be the last argument");
  }

  /**
   * Validates the arguments.
   *
   * @throws IllegalArgumentException if files and directories are not valid.
   */
  protected void validate() throws IllegalArgumentException {
    this.setTemplateFlag();
    this.setTemplate();
    this.setCsvFile();
    this.setOutputDirFlag();
    File csv = new File(this.getCsv());
    if (!csv.isFile()) {
      throw new IllegalArgumentException("Csv file was not valid");
    }
    File template = new File(this.getTemplate());
    if (!template.isFile()) {
      throw new IllegalArgumentException("template was not a valid file");
    }
//    File outputDirectory = new File(this.getOutputDirectory());
//    if (!outputDirectory.isDirectory()) {
//      throw new IllegalArgumentException("Output directory was not valid");
//    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof ArgumentParser)) {
      return false;
    }
    ArgumentParser that = (ArgumentParser) obj;
    return Objects.equals(templateFlag, that.templateFlag)
        && Objects.equals(template, that.template)
        && Objects.equals(csv, that.csv)
        && Objects.equals(outputDirectory, that.outputDirectory)
        && Arrays.equals(arguments, that.arguments);
  }

  @Override
  public int hashCode() {

    int result = Objects
        .hash(templateFlag, template, csv, outputDirectory);
    result = 31 * result + Arrays.hashCode(arguments);
    return result;
  }

  @Override
  public String toString() {
    return "ArgumentParser{"
        + "templateFlag='" + templateFlag + '\''
        + ", template='" + template + '\''
        + ", csv='" + csv + '\''
        + ", outputDirectory='" + outputDirectory + '\''
        + ", arguments=" + Arrays.toString(arguments)
        + '}';
  }
}
