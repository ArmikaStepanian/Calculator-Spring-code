package ru.stepanian.calc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 1 on 12.12.2015.
 */
public class CalculatorListener implements ActionListener {

    private JTextField field1;   //связываем с нашим калькулятором (передача данных между классами)
    private JTextField field2;
    private JTextField fieldResult;

    public CalculatorListener() {
    }

    public CalculatorListener(JTextField field1, JTextField field2, JTextField fieldResult) {//связываем с нашим калькулятором (передача данных между классами)
        this.field1 = field1;
        this.field2 = field2;
        this.fieldResult = fieldResult;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton clickedButton = (JButton) e.getSource();  // Получить источник текущего действия.

        String textFromField1 = field1.getText();    // Получить текущий текст из поля

        double value1 = Double.parseDouble(textFromField1); //Записать это значение (которое типа String) в виде типа double

        String textFromField2 = field2.getText();  // Получить текущий текст из поля

        double value2 = Double.parseDouble(textFromField2);   //Записать это значение (которое типа String) в виде типа double

        if (clickedButton.getActionCommand().equals("+")) {
            fieldResult.setText("" + Operations.add(value1, value2)); //всю математику выносим в отдельный класс, клевая идея
        }
        if (clickedButton.getActionCommand().equals("-")) {
            fieldResult.setText("" + Operations.minus(value1, value2)); //как известно, пустоту прибавляем для конвертации в строку
        }
        if (clickedButton.getActionCommand().equals("*")) {
            fieldResult.setText(String.valueOf(Operations.multiply(value1, value2))); //Или можно так конвертировать в строку
        }
        if (clickedButton.getActionCommand().equals("/")) {
            fieldResult.setText("" + Operations.divide(value1, value2));
        }
        if (clickedButton.getActionCommand().equals("C")) {
            field1.setText("");
            field2.setText("");
            fieldResult.setText("");
        }


    }
}
