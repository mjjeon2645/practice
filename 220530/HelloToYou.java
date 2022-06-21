// 1. static main, non-static run
// 2. HelloWorld와 기본 포맷은 동일하게 진행
// 3. JTextField 이용하여 입력값 받을 수 있는 field 설정
// 4. JLabel과 JTextField가 동시에 보일 수 있도록 레이아웃 조절
// 5. JButton 이용하여 버튼 생성하기
// 6. 버튼을 눌렀을 때의 동작을 람다 이용하여 설정해주기
// 7. 중복을 제거해주기

import javax.swing.*;
import java.awt.*;

public class HelloToYou {
    private static String name = "World";

    public static void main(String[] args) {
        HelloToYou application = new HelloToYou();
        application.run();
    }

    public void run() {
        JFrame frame = new JFrame("Hello to you");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(400, 300);

        JLabel label = new JLabel(greetingMessage());
        frame.add(label);

        JTextField textField = new JTextField(10);
        frame.add(textField);

        JButton button = new JButton("확인");
        button.addActionListener(event -> {
            name = textField.getText();
            label.setText(greetingMessage());
        });
        frame.add(button);

        frame.setVisible(true);
    }

    private static String greetingMessage() {
        return "Hello, " + name + "!";
    }
}
