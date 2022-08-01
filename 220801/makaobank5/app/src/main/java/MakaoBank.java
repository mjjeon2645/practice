import com.sun.net.httpserver.HttpServer;
import models.Account;
import services.TransferService;
import utils.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class MakaoBank {
  private final FormParser formParser;
  private final Account account;
  private final List<Account> accounts;
  private final TransferService transferService;

  public static void main(String[] args) throws IOException {
    MakaoBank makaoBank = new MakaoBank();
    makaoBank.run();
  }

  public MakaoBank() {
    formParser = new FormParser();

    accounts = List.of(
        new Account("1234", "Ashal", 3000),
        new Account("2345", "JOKER", 1000)
    );

    account = accounts.get(0);

    transferService = new TransferService(accounts);
  }

  public void run() throws IOException {
    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", (exchange) -> {

      // 1. 입력
      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();

      String method = exchange.getRequestMethod();

      String requestBody = new RequestBodyReader(exchange).body();

      Map<String, String> formData = formParser.parse(requestBody);

      // 2. 처리

      PageGenerator pageGenerator = process(path, method, formData);

      // 3. 출력
      new MessageWriter(exchange).write(pageGenerator.html());
    });

    httpServer.start();

    System.out.println("http://localhost:8000/");
  }

  public PageGenerator process(String path, String method,
                               Map<String, String> formData) {

    String[] steps = path.substring(1).split("/");
    return switch (steps[0]) {
      case "account" -> processAccount(steps.length > 1 ? steps[1] : "");
      case "transfer" -> processTransfer(method, formData);
      default -> new GreetingPageGenerator();
    };
  }

  public AccountPageGenerator processAccount(String identifier) {
    Account found = accounts.stream()
        .filter(account -> account.identifier().equals(identifier))
        .findFirst()
        .orElse(account);
    return new AccountPageGenerator(found);
  }

  public PageGenerator processTransfer(String method,
                                       Map<String, String> formData) {
    if (method.equals("GET")) {
      return processTransferGet();
    }

    return TransferProcessPost(formData);
  }

  public TransferPageGenerator processTransferGet() {
    return new TransferPageGenerator(account);
  }

  public TransferSuccessPageGenerator TransferProcessPost(
      Map<String, String> formData) {
    transferService.transfer(
        account.identifier(),
        formData.get("to"),
        Long.parseLong(formData.get("amount")));

    return new TransferSuccessPageGenerator(account);
  }
}
