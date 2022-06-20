//  서버 생성 -> 본인 이름을 패스로 받아 문구 출력에 사용

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import utils.MessageGenerator;
import utils.MessageWriter;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

public class MakaoBank {
  public static void main(String[] args) throws IOException {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  public void run() throws IOException {
    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", (exchange) -> {
      String name = nameFromPath(exchange);

      MessageGenerator messageGenerator = new MessageGenerator(name);
      String content = messageGenerator.text();

      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(content);
    });

    httpServer.start();
    System.out.println("http://localhost:8000");
  }

  public String nameFromPath(HttpExchange exchange) {
    URI requestURI = exchange.getRequestURI();
    String path = requestURI.getPath();

    String name = path.substring(1);
    return name;
  }
}
