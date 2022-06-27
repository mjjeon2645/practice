package models;

public class Task {
  private String title;
  private int identifier;

  public Task(String title, int identifier) {
    this.title = title;
    this.identifier = identifier;
  }

  public String title() {
    return title;
  }

  public int identifier() {
    return identifier;
  }
}
