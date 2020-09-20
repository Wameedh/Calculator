package edu.csc413.calculator.evaluator;
import edu.csc413.calculator.exceptions.InvalidTokenException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {

    private TextField expressionTextField = new TextField();
    private Panel buttonPanel = new Panel();

    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // bText[] array contains the text for corresponding buttons
    private static final String[] buttonText = {
        "7", "8", "9", "+", "4", "5", "6", "- ", "1", "2", "3",
        "*", "0", "^", "=", "/", "(", ")", "C", "CE"
    };

    /**
     * C  is for clear, clears entire expression
     * CE is for clear expression, clears last entry up until the last operator.
     */
    private Button[] buttons = new Button[buttonText.length];

    public static void main(String argv[]) {
        new EvaluatorUI();
    }

    public EvaluatorUI() {
        setLayout(new BorderLayout());
        this.expressionTextField.setPreferredSize(new Dimension(600, 50));
        this.expressionTextField.setFont(new Font("Courier", Font.BOLD, 28));

        add(expressionTextField, BorderLayout.NORTH);
        expressionTextField.setEditable(false);
        expressionTextField.setBackground(Color.white);
        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 4));

        //create 20 buttons with corresponding text in bText[] array
        Button tempButtonReference;
        for (int i = 0; i < EvaluatorUI.buttonText.length; i++) {
            tempButtonReference = new Button(buttonText[i]);
            tempButtonReference.setFont(new Font("Courier", Font.BOLD, 28));
            buttons[i] = tempButtonReference;
        }

        //add buttons to button panel
        for (int i = 0; i < EvaluatorUI.buttonText.length; i++) {
            buttonPanel.add(buttons[i]);
        }

        //set up buttons to listen for mouse input
        for (int i = 0; i < EvaluatorUI.buttonText.length; i++) {
            buttons[i].addActionListener(this);
        }

        setTitle("Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * This function is triggered anytime a button is pressed
     * on our Calculator GUI.
     * @param actionEventObject Event object generated when a
     *                    button is pressed.
     */
    public void actionPerformed(ActionEvent actionEventObject) {

        Evaluator evaluator = new Evaluator();
        int result = 0;

        if (actionEventObject.getSource() == buttons[0]) {
            expressionTextField.setText(expressionTextField.getText() + "7");
        } else if (actionEventObject.getSource() == buttons[1]) {
            expressionTextField.setText(expressionTextField.getText() + "8");
        } else if (actionEventObject.getSource() == buttons[2]) {
            expressionTextField.setText(expressionTextField.getText() + "9");
        } else if (actionEventObject.getSource() == buttons[3]) {
            expressionTextField.setText(expressionTextField.getText() + "+");
        } else if (actionEventObject.getSource() == buttons[4]) {
            expressionTextField.setText(expressionTextField.getText() + "4");
        } else if (actionEventObject.getSource() == buttons[5]) {
            expressionTextField.setText(expressionTextField.getText() + "5");
        } else if (actionEventObject.getSource() == buttons[6]) {
            expressionTextField.setText(expressionTextField.getText() + "6");
        } else if (actionEventObject.getSource() == buttons[7]) {
            expressionTextField.setText(expressionTextField.getText() + "-");
        } else if (actionEventObject.getSource() == buttons[8]) {
            expressionTextField.setText(expressionTextField.getText() + "1");
        } else if (actionEventObject.getSource() == buttons[9]) {
            expressionTextField.setText(expressionTextField.getText() + "2");
        } else if (actionEventObject.getSource() == buttons[10]) {
            expressionTextField.setText(expressionTextField.getText() + "3");
        } else if (actionEventObject.getSource() == buttons[11]) {
            expressionTextField.setText(expressionTextField.getText() + "*");
        } else if (actionEventObject.getSource() == buttons[12]) {
            expressionTextField.setText(expressionTextField.getText() + "0");
        } else if (actionEventObject.getSource() == buttons[13]) {
            expressionTextField.setText(expressionTextField.getText() + "^");
        } else if (actionEventObject.getSource() == buttons[14]) {
            try {
                result = evaluator.evaluateExpression(expressionTextField.getText());
            } catch (InvalidTokenException e) {
                e.printStackTrace();
            }
            expressionTextField.setText("");
            expressionTextField.setText(expressionTextField.getText() + result);
        } else if (actionEventObject.getSource() == buttons[15]) {
            expressionTextField.setText(expressionTextField.getText() + "/");
        } else if (actionEventObject.getSource() == buttons[16]) {
            expressionTextField.setText(expressionTextField.getText() + "(");
        } else if (actionEventObject.getSource() == buttons[17]) {
            expressionTextField.setText(expressionTextField.getText() + ")");
        } else if (actionEventObject.getSource() == buttons[18]) {
            expressionTextField.setText("");
        } else if (actionEventObject.getSource() == buttons[19]) {
            String expression = expressionTextField.getText();
            String subExpression = expression.substring(0, expression.length() - 1);
            expressionTextField.setText(subExpression);
        }

    }
}

