package edu.neu.ccs.cs5004;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The contact data structure to hold patron information.
 */

public class ContactBook {

  private Map<Integer, HeaderValues> contacts;


  /**
   * Creates an empty contact book.
   */
  public ContactBook() {
    this.contacts = new HashMap<Integer, HeaderValues>();
  }

  /**
   * Creates instance of contacts.
   * @param contacts the contacts to create an instance with
   */
  public ContactBook(Map<Integer, HeaderValues> contacts) {
    this.contacts = contacts;
  }

  /**
   * Returns the contact book's data structure.
   * @return the contact book's data structure
   */
  public Map<Integer, HeaderValues> getContacts() {
    return contacts;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    ContactBook that = (ContactBook) obj;
    return Objects.equals(contacts, that.contacts);
  }

  @Override
  public int hashCode() {

    return Objects.hash(contacts);
  }

  @Override
  public String toString() {
    return "ContactBook{"
        + "contacts=" + contacts
        + '}';
  }
}
