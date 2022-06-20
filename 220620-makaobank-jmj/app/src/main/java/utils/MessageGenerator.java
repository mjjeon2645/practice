package utils;

public class MessageGenerator {
  private final String name;

  public MessageGenerator() {
    this.name = "world";
  }

  public MessageGenerator(String name) {
    if (name.isBlank()) {
      this.name = "world";
      return;
    }
    this.name = name;
  }

  public String text() {
    return "Hello, " + name + "!";
  }
}
