package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageGeneratorTest {
  @Test
  void navigation() {
   PageGenerator pageGenerator = new PageGenerator() {
     @Override
     public String content() {
       return "";
     }
   };

   String html = pageGenerator.html();

   assertTrue(html.contains("<a href=\"/\">홈으로"), "홈으로 버튼 문제");
  }
}