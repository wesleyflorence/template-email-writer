package edu.neu.ccs.cs5004;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Populates the patron's hashmap with attached values by parsing lines.
 */

public class Contacts implements IParser {

  private ContactBook contacts;
  private List<String> headerFields;
  private Integer lineCount;


  /**
   * Creates an instance of contacts.
   */
  public Contacts() {
    this.contacts = new ContactBook();
    this.headerFields = new ArrayList<String>();
    this.lineCount = 0;
  }

  /**
   * Returns the contact book.
   *
   * @return the contact book
   */
  public ContactBook getContacts() {
    return contacts;
  }

  /**
   * Returns the header fields list.
   *
   * @return the header fields list
   */
  public List<String> getHeaderFields() {
    return headerFields;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void parse(String line) {
    Iterator<String> headerIter = this.headerFields.iterator();
    Pattern csvParse = Pattern.compile("\".*?\"");
    Matcher matcher1 = csvParse.matcher(line);
    if (this.headerFields.isEmpty()) {
      while (matcher1.find()) {
        this.headerFields.add(matcher1.group().replace("\"", ""));
      }
    } else {
      while (matcher1.find()) {
        this.contacts.getContacts().putIfAbsent(this.lineCount, new HeaderValues());
        this.contacts.getContacts().get(this.lineCount).getUserValues()
            .putIfAbsent(headerIter.next(),
                matcher1.group().replace("\"", ""));
      }
      this.lineCount++;
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Contacts contacts1 = (Contacts) obj;
    return Objects.equals(contacts, contacts1.contacts)
        && Objects.equals(headerFields, contacts1.headerFields);
  }

  @Override
  public int hashCode() {

    return Objects.hash(contacts, headerFields);
  }

  @Override
  public String toString() {
    return "Contacts{"
        + "contacts=" + contacts
        + ", headerFields=" + headerFields
        + '}';
  }
}
