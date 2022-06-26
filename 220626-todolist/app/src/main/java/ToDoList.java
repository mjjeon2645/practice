// 1. http 생성

import com.sun.net.httpserver.HttpServer;
import models.ListElement;
import utils.*;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ToDoList {
  private ListElement listElement;

  public static void main(String[] args) throws IOException {
    ToDoList application = new ToDoList();
    application.run();
  }

  public void run() throws IOException {

    listElement = new ListElement("양치하기", 1);

    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", (exchange) -> {

      // 처리
      String method = exchange.getRequestMethod();

      PageGenerator pageGenerator = process(method);

      String content = pageGenerator.html();


      // 출력(http로 메시지를 보내는 것)
      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(content);

    });

    httpServer.start();
    System.out.println("http://localhost:8000/");
  }

  public PageGenerator process(String method) {
    return switch (method) {
      case "POST" -> processListPost();
      default -> processListGet();
    };
  }

  public ListPageGenerator processListPost() {
    //TODO : 진짜 처리

    return new ListPageGenerator(listElement);
  }

  public MainPageGenerator processListGet() {
    return new MainPageGenerator();
  }
}
