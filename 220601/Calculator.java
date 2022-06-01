import javax.swing.*;
import java.awt.*;

public class Calculator {
    private JTextField textField;
    private long currentNumber = 0;
    private long accumulator = 0;
    private String currentOperator = "";

    private static final String[] OPERATORS = new String[] {"+", "-", "*", "/", "="};
    private JFrame frame;
    private JPanel panel;

    public static void main(String[] args) {
        Calculator application = new Calculator();
        application.run();
    }

    public void run() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));

        textField = new JTextField(10);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        updateDisplay(currentNumber);

        frame.add(textField, BorderLayout.PAGE_START);

        initNumberButtons();
        initOperatorButtons();

        frame.pack();
        frame.setVisible(true);
    }

    public void initNumberButtons() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 3));
        frame.add(panel);
        for (int i = 0; i < 10; i += 1) {
            int number = (i + 1) % 10;
            JButton button = new JButton(Integer.toString(number));
            button.addActionListener(event -> {
                addNumber(number);
                updateDisplay(currentNumber);
            });
            panel.add(button);
        }
    }

    public void initOperatorButtons() {
        for (String operator : OPERATORS) {
            JButton button = new JButton(operator);
            button.addActionListener(event -> {
                calculate();
                currentOperator = operator;
                currentNumber = 0;
                updateDisplay(accumulator);
            });
            panel.add(button);
        }
    }

    public void calculate() {
        switch (currentOperator) {
            case "" -> accumulator = currentNumber;
            case "+" -> accumulator += currentNumber;
            case "-" -> accumulator -= currentNumber;
            case "*" -> accumulator *= currentNumber;
            case "/" -> accumulator /= currentNumber;
        }
    }

    public void updateDisplay(long number) {
        textField.setText(Long.toString(number));
    }

    public void addNumber(int number) {
        currentNumber *= 10;
        currentNumber += number;
    }
}
