import com.sun.net.httpserver.HttpServer;
import models.Account;
import utils.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;

public class MakaoBank {
  public static void main(String[] args) throws IOException {
    MakaoBank makaoBank = new MakaoBank();
    makaoBank.run();
  }

  public void run() throws IOException {
    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", (exchange) -> {

      // 1. 입력
      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();

      // 2. 처리

      Account account = new Account("1234", "Ashal", 3000);

      PageGenerator pageGenerator = switch (path) {
        case "/account" ->  new AccountPageGenerator(account);
        case "/transfer" ->  new TransferPageGenerator(account);
        default -> new GreetingPageGenerator();
      };

      String content = pageGenerator.html();

      // 3. 출력
      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(content);
    });

    httpServer.start();

    System.out.println("http://localhost:8000/");
  }
}
