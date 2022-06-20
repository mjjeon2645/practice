package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingPageGeneratorTest {
  @Test
  void defaultName() {
    PageGenerator pageGenerator = new GreetingPageGenerator();

    assertEquals("Hello, world!", pageGenerator.html());
  }

  @Test
  void inputAshalName() {
    PageGenerator pageGenerator = new GreetingPageGenerator("Ashal");

    assertEquals("Hello, Ashal!", pageGenerator.html());
  }

  @Test
  void inputEmptyName() {
    PageGenerator pageGenerator = new GreetingPageGenerator("");

    assertEquals("Hello, world!", pageGenerator.html());
  }

  @Test
  void inputBlankName() {
    PageGenerator pageGenerator = new GreetingPageGenerator("   ");

    assertEquals("Hello, world!", pageGenerator.html());
  }
}
