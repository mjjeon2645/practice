package utils;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransferPageGeneratorTest {
  @Test
  void form() {
    Account account = new Account("1234", "Ashal", 3000);

    PageGenerator pageGenerator = new TransferPageGenerator(account);

    String html = pageGenerator.html();

    assertTrue(html.contains("잔액: 3000원"), "잔액 문제");
    assertTrue(html.contains("보낼 계좌: <input"), "계좌 입력 문제");
    assertTrue(html.contains("보낼 금액: <input"), "보낼 금액 문제");
    assertTrue(html.contains("확인</button>"), "확인버튼 문제");
  }
}
