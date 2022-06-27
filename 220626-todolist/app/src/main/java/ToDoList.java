// 1. http 생성

import com.sun.net.httpserver.HttpServer;
import models.Task;
import utils.ListPageGenerator;
import utils.MainPageGenerator;
import utils.MessageWriter;
import utils.PageGenerator;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class ToDoList {
  private List<Task> tasks = new ArrayList<>();;

  public ToDoList() {
    Stream.of(
        new Task("양치하기", 1),
        new Task("물마시기", 2)
    ).forEach(task -> {
      tasks.add(task);
    });

  }

  public static void main(String[] args) throws IOException {
    ToDoList application = new ToDoList();
    application.run();
  }

  public void run() throws IOException {
    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", (exchange) -> {

      // 처리
      String method = exchange.getRequestMethod();

      InputStream inputStream = exchange.getRequestBody();

      Scanner scanner = new Scanner(inputStream);

      String taskTitle = "";

      if (scanner.hasNextLine()) {
        String keyAndValue = scanner.nextLine();
        String[] pairs = keyAndValue.split("=");
        taskTitle = pairs[1];

        System.out.println(taskTitle);
      }

      PageGenerator pageGenerator = process(method, taskTitle);

      String content = pageGenerator.html();





      // 출력(http로 메시지를 보내는 것)
      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(content);

    });

    httpServer.start();
    System.out.println("http://localhost:8000/");
  }

  public PageGenerator process(String method, String taskTitle) {
//    return switch (method) {
//      case "POST" -> processListPost();
//      default -> processListGet();
//    };

    if(method.equals("POST")) {
      Task task = new Task(taskTitle, 2);
      tasks.add(task);
//      tasks.stream().forEach(i -> System.out.println(i.title()));
    }

    return new ListPageGenerator(tasks);
  }
//
//  public ListPageGenerator processListPost() {
//    //TODO : 진짜 처리
//
//    return new ListPageGenerator(tasks);
//  }
//
//  public MainPageGenerator processListGet() {
//    return new MainPageGenerator();
//  }
}
