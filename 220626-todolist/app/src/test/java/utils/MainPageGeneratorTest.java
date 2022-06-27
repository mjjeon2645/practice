package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainPageGeneratorTest {
  @Test
  void basicFormat() {
    PageGenerator pageGenerator = new MainPageGenerator();

    String text = pageGenerator.html();

    assertTrue(text.contains("TODO LIST"), "헤드라인 문제");
    assertTrue(text.contains("Todo"), "소제목 문제");
    assertTrue(text.contains("<input"), "입력값 라인 문제");
    assertTrue(text.contains("<button"), "버튼 문제");
  }

}