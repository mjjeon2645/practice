package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GreetingPageGeneratorTest {
  @Test
  void creation() {
    PageGenerator pageGenerator = new GreetingPageGenerator();

    assertTrue(pageGenerator.html().contains("Hello, world!"));
  }

  @Test
  void nameAshal() {
    PageGenerator pageGenerator = new GreetingPageGenerator("Ashal");

    assertTrue(pageGenerator.html().contains("Hello, Ashal!"));
  }

  @Test
  void inputEmptyName() {
    PageGenerator pageGenerator = new GreetingPageGenerator("");

    assertTrue(pageGenerator.html().contains("Hello, world!"));
  }

  @Test
  void inputBlankName() {
    PageGenerator pageGenerator = new GreetingPageGenerator("   ");

    assertTrue(pageGenerator.html().contains("Hello, world!"));
  }
}
