// 1. 서버를 생성한 뒤, 본인의 이름을 Path로 입력하고 그 이름을 받아 Hello, 이름 문구를 출력
// 2. makaobank 기본 기능 3가지 구현
//  1) account 생성하여 계좌 관리(계좌번호, 이름, 잔액)
//  2) transfer -> 계좌번호로 계좌 구분
//              -> 어떻게 송금? map?
//              -> 송금이 이루어지면 transactions에 반영
//  3) transactions -> list로 관리

// account 생성 -> messageGenerator -> pagegenerator로 변경하고 이를 추상화하여 사용
// AccountPageGenerator에서 html 줄 것


import com.sun.net.httpserver.HttpServer;
import models.Account;
import utils.AccountPageGenerator;
import utils.GreetingPageGenerator;
import utils.PageGenerator;
import utils.MessageWriter;

import java.io.IOException;
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

      // 입력
      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();

      // 처리
      PageGenerator pageGenerator = new GreetingPageGenerator();

      if (path.equals("/account")) {
        Account account = new Account("1234", "Ashal", 3000);
         pageGenerator= new AccountPageGenerator(account);
      }

      String content = pageGenerator.html();

      // 출력
      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(content);
    });

    httpServer.start();
    System.out.println("http://localhost:8000/");
  }
}
