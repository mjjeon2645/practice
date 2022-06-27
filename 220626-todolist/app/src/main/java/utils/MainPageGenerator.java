package utils;


import models.Task;

public class MainPageGenerator extends PageGenerator {

  @Override
  public String html() {
    Task task = new Task("양치하기", 1);

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
        "</body>\n" +
        "</html>";
  }
}