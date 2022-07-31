import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class MakaoBank {
  public static void main(String[] args) throws IOException {
    MakaoBank makaoBank = new MakaoBank();
    makaoBank.run();
  }

  public void run() throws IOException {
    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", (exchange) -> {
      String content = "Hello, world!";

      exchange.sendResponseHeaders(200, content.getBytes().length);

      OutputStream outputStream = exchange.getResponseBody();

      outputStream.write(content.getBytes());
      outputStream.flush();
      outputStream.close();
    });

    httpServer.createContext("/ashal", (exchange) -> {
      String content = "Hello, ashal!";

      exchange.sendResponseHeaders(200, content.getBytes().length);

      OutputStream outputStream = exchange.getResponseBody();

      outputStream.write(content.getBytes());
      outputStream.flush();
      outputStream.close();
    });

    httpServer.start();

    System.out.println("http://localhost:8000/");
  }
}
