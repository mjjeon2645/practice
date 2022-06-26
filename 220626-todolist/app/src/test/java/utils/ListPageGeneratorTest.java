package utils;

import models.ListElement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListPageGeneratorTest {
  @Test
  void creation() {
    ListElement listElement = new ListElement("양치하기", 1);

    PageGenerator pageGenerator = new ListPageGenerator(listElement);

    String html = pageGenerator.html();

    assertTrue(html.contains("양치하기"), "리스트 문제");
  }

}