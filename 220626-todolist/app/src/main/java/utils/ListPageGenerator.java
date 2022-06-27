package utils;


import models.Task;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListPageGenerator extends PageGenerator {
  private final List<Task> tasks;

  public ListPageGenerator(List<Task> tasks) {
    super();

    this.tasks = tasks;
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
        "<input type=\"text\" name=\"title\" />\n" +
        "<button type=\"submit\">Create</button>\n" +
        "</form>" +
        "<ul>" +
        tasks() +
        "</body>\n" +
        "</html>";
  }

  public String tasks() {
    return tasks.stream().map(task -> "<li>" + task.title() +
            "<button type=\"submit\" name=\"delete\">X</button></p>\n" + "</li>\n")
        .collect(Collectors.joining());
  }
}
