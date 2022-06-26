package utils;

import models.ListElement;

public class ListPageGenerator extends PageGenerator{

  private final ListElement listElement;

  public ListPageGenerator(ListElement listElement) {
    super();

    this.listElement = listElement;
  }

  @Override
  public String html() {
    return "" +
        "<!DOCTYPE html>\n" +
        "<html>\n" +
        "<head>\n" +
        "<meta charset=\"UTF-8\" />\n" +
        "<title>TODO LIST</title>\n" +
        "</head>\n" +
        "<body>\n" +
        "<h1>TODO LIST</h1>\n" +
        "<form method=\"POST\" />" +
        "<span>Todo</span>\n" +
        "<input type=\"text\" name=\"typedlist\" />\n" +
        "<button type=\"submit\" name=\"create\">Create</button>\n" +
        "</form>" +
        "<p>" + listElement.listByUser() + "\n" +
        "<button type=\"submit\" name=\"delete\">X</button></p>\n" +
        "</body>\n" +
        "</html>";
  }
}
