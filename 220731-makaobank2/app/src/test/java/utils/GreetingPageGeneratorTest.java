package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingPageGeneratorTest {
  @Test
  void defaultText() {
    PageGenerator pageGenerator = new GreetingPageGenerator();

    assertEquals("Hello, world!", pageGenerator.html());
  }

  @Test
  void messageWithName() {
    PageGenerator pageGenerator = new GreetingPageGenerator("Ashal");

    assertEquals("Hello, Ashal!", pageGenerator.html());
  }

  @Test
  void messageWithBlank() {
    PageGenerator pageGenerator = new GreetingPageGenerator("    ");

    assertEquals("Hello, world!", pageGenerator.html());
  }
}
