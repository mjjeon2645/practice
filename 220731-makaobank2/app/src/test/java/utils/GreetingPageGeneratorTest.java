package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GreetingPageGeneratorTeset {
  @Test
  void defaultText() {
    PageGenerator pageGenerator = new GreetingPageGenerator();
    String content = pageGenerator.content();

    assertTrue(content.contains("Hello, world!"));
  }

  @Test
  void messageWithName() {
    PageGenerator pageGenerator = new GreetingPageGenerator("Ashal");
    String content = pageGenerator.content();

    assertTrue(content.contains("Hello, Ashal!"));
  }

  @Test
  void messageWithBlank() {
    PageGenerator pageGenerator = new GreetingPageGenerator("    ");
    String content = pageGenerator.content();

    assertTrue(content.contains("Hello, world!"));
  }
}
