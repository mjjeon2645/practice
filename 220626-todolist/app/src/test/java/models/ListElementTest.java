package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListElementTest {
  @Test
  void creation() {
    ListElement listElement = new ListElement("양치하기", 1);

    assertEquals("양치하기", listElement.listByUser());
    assertEquals(1, listElement.identifier());
  }

}