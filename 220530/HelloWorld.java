// 1. 기존의 방식대로 "Hello, world!"를 출력해보았음.
// 2. Swing의 개념을 배우고 window 창을 띄워 동일한 문구를 출력해보았음.
// 3. non-static run 메소드 생성(refactor - abstract methods 이용).

import javax.swing.*;

public class HelloWorld {
    public static void main(String[] args) {
        HelloWorld application = new HelloWorld();
        application.run();
    }

    public void run() {
        JFrame frame = new JFrame("Hello, World!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JLabel label = new JLabel("Hello, World!");
        frame.add(label);

        frame.setVisible(true);
    }
}
