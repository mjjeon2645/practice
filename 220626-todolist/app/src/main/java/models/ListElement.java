package models;

public class ListElement {

  private String listByUser;
  private int identifier;

  public ListElement(String listByUser, int identifier) {
    this.listByUser = listByUser;
    this.identifier = identifier;
  }

  public String listByUser() {
    return listByUser;
  }

  public int identifier() {
    return identifier;
  }
}
