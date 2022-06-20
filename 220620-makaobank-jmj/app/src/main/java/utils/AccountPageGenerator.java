package utils;

import models.Account;

public class AccountPageGenerator extends PageGenerator {
  private Account account;

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
           "<title>MakaoBank</title>\n" +
           "</head>\n" +
           "<body>\n" +
           "<p>계좌번호: \n" + account.identifier() + "</p>\n" +
             "<p>이름: \n" + account.name() + "</p>\n" +
             "<p>잔액: \n" + account.amount() + "원</p>\n" +
           "</body>\n" +
           "</html>";
  }
}
