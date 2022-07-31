package utils;

import models.Account;

public class AccountPageGenerator extends PageGenerator {
  private final Account account;

  public AccountPageGenerator(Account account) {
    super();
    
    this.account = account;
  }

  @Override
  public String html() {
    return "" +
        "<!DOCTYPE html>\n" +
        "<html lang=\"ko\">\n" +
        "<head>\n" +
        "<meta charset=\"UTF-8\">\n" +
        "<title>마카오 뱅크</title>\n" +
        "</head>\n" +
        "<body>\n" +
        "<p>계좌번호: " + account.identifier() + "</p>\n" +
        "<p>이름: " + account.name() + "</p>\n" +
        "<p>잔액: " + account.amount() + "</p>\n" +
        "</body>\n" +
        "</html>";
  }
}
