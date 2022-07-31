// 0. static main, non-static run 메소드 선언
// 1. 계산기 기능을 GUI로 구현하기 위해 JFrame 사용하여 초기 세팅
// 2. 계산기 버튼을 눌렀을 때의 숫자, 결과값 등을 출력하기 위해 JTextField를 활용한다.
//    -> (1) textField이지만 텍스트 입력/수정 불가(결과값/숫자 등 값 출력만 가능한 컨트롤로 활용할 예정)
//       (2) 값은 우측 정렬, (3) 초기값은 "0"으로 세팅, (4) frame 상단에 위치하도록 함
// 3. 값 출력라인(textfield) 하단에 별도 구역을 정해 숫자/기능 버튼을 생성 -> JPanel 사용(버튼 정렬은 4x3으로 함)
// 4. 계산기의 숫자버튼을 구현하기 위하여 JButton 활용
//    -> 1~9, 0의 순서대로 숫자버튼을 만들기 위해 for문을 사용하여 버튼 생성 과정을 총 10번 반복
//    -> 버튼 누른 값을 textfield 영역에 출력하기 위해 람다 활용(단, 1과 3을 연달아 눌렀을 때 13이 출력되는 논리 설계 필요)
//    -> 숫자버튼 구현논리가 완성되면 initNumberButton 메서드로 추출하여 관심사의 분리 수행(추후 유지보수, 수정에 용이)
// 5. 계산기의 기능버튼을 구현하기 위하여 JButton 활용
//    -> +, -, *, /, = 만들기 위해 for문 사용
//    -> 숫자 입력 > 기능버튼 누름 > 추가 숫자 입력 순서. 추가숫자 입력 프로세스 시 기존에 입력한 숫자는 피신시켜야 하므로 accumulator 변수 활용
//    -> 사용자 시나리오 작성
//      13 입력시 accumulator = 0, currentNumber = 13, operators = ""
//      + 입력시 accumulator = 13, currentNumber = 0, operators = "+"
//      7 입력시 accumulator = 13, currentNumber = 7, operators = "+"
//      = 입력시 accumulator = 13 + 7 = 20, currentNumber = 0, operators = "="
//      =가 아닌 + 입력시 accumulator = 13 + 7 = 20, currentNumber = 0, operators = "+"

import javax.swing.*;
import java.awt.*;

public class Calculator2 {
    private long currentNumber = 0;
    private JTextField textField;
    private int number;

    public static void main(String[] args) {
        Calculator2 application = new Calculator2();
        application.run();
    }

    public void run() {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField(10);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setText("0");
        frame.add(textField, BorderLayout.PAGE_START);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 3));

        for (int i = 0; i < 10; i += 1) {
            number = (i + 1) % 10;
            JButton button = new JButton(Integer.toString(number));
            button.addActionListener(event -> {
                currentNumber *= 10;
                currentNumber += number;
                textField.setText(Long.toString(currentNumber));
            });
            panel.add(button);
        }
        //    initOperatorButtons();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

    /*    public void initOperatorButtons() {
        String[] operators = new String[] {"+", "-", "*", "/", "="};
        for (String operator : operators) {
            JButton button = new JButton(operator);
            button.addActionListener(event -> {

                accumulator = currentNumber;
                currentNumber = 0;
            });
            panel.add(button);
        }
    }*/
