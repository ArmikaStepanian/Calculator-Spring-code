package ru.stepanian.calc;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by 1 on 12.12.2015.
 */
public class CalcFieldsFocusListener implements FocusListener {

    private JTextField field;

    public CalcFieldsFocusListener() {
    }

    public CalcFieldsFocusListener(JTextField field) {
        this.field = field;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (field.getText().equals(StartCalculator.INPUT_NUMBER)) {
            field.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (field.getText().equals("")) {
            field.setText(StartCalculator.INPUT_NUMBER);
        }
    }
}
