package ru.stepanian.calc;

import com.jtattoo.plaf.texture.TextureLookAndFeel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by 1 on 11.12.2015.
 */
public class StartCalculator {

    public static final String INPUT_NUMBER = "add number";

    private JLabel labelNumber1;
    private JLabel labelNumber2;
    private JLabel labelResult;

    private JTextField field1;
    private JTextField field2;
    private JTextField fieldResult;

    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonDivide;
    private JButton buttonMultiply;
    private JButton buttonClean;

    private GridLayout gridLayout1;
    private GridLayout gridLayout2;
    private GridLayout gridLayout3;

    private JPanel p1;
    private JPanel p2;

    private CalculatorListener calculatorListener;
    private CalcFieldsFocusListener calcFieldsFocusListener1;
    private CalcFieldsFocusListener calcFieldsFocusListener2;

    private MyFrameGUI myFrameGUI;

    ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-listeners.xml"); //СОЗДАНИЕ ЭКЗЕМПЛЯРА КОНТЕКСТА

    private void createLabels() {
        labelNumber1 = (JLabel) context.getBean("labelNumber1");
        labelNumber2 = (JLabel) context.getBean("labelNumber2");
        labelResult = (JLabel) context.getBean("labelResult");
        labelNumber1.setText("Number 1:");
        labelNumber2.setText("Number 2:");
        labelResult.setText("Result:");
    }

    private void createTextFields() {
        field1 = (JTextField) context.getBean("field1");
        field2 = (JTextField) context.getBean("field2");
        fieldResult = (JTextField) context.getBean("fieldResult");
        field1.setText(INPUT_NUMBER);
        field2.setText(INPUT_NUMBER);
        fieldResult.setEditable(false);
        fieldResult.setFocusable(false);
    }

    private void createButtons() {
        buttonPlus = (JButton) context.getBean("buttonPlus");
        buttonMinus = (JButton) context.getBean("buttonMinus");
        buttonMultiply = (JButton) context.getBean("buttonMultiply");
        buttonDivide = (JButton) context.getBean("buttonDivide");
        buttonClean = (JButton) context.getBean("buttonClean");
        buttonPlus.setText("+");
        buttonMinus.setText("-");
        buttonMultiply.setText("*");
        buttonDivide.setText("/");
        buttonClean.setText("C");
    }

    private void createPanels() {
        p1 = (JPanel) context.getBean("p1");
        gridLayout1 = (GridLayout) context.getBean("gridLayout1");
        p1.setLayout(gridLayout1);
        p1.setBorder(LineBorder.createBlackLineBorder());
        p1.add(labelNumber1);
        p1.add(field1);
        p1.add(labelNumber2);
        p1.add(field2);
        p1.add(labelResult);
        p1.add(fieldResult);

        p2 = (JPanel) context.getBean("p2");
        gridLayout2 = (GridLayout) context.getBean("gridLayout2");
        p2.setLayout(gridLayout2);
        p2.setBorder(LineBorder.createBlackLineBorder());
        p2.add(buttonPlus);
        p2.add(buttonMinus);
        p2.add(buttonMultiply);
        p2.add(buttonDivide);
        p2.add(buttonClean);
    }

    private void createFrame() {
        myFrameGUI = (MyFrameGUI) context.getBean("myFrameGUI");
        gridLayout3 = (GridLayout) context.getBean("gridLayout3");
        p1 = (JPanel) context.getBean("p1");
        p2 = (JPanel) context.getBean("p2");
        myFrameGUI.setLayout(gridLayout3);
        myFrameGUI.getContentPane().add(p1);
        myFrameGUI.getContentPane().add(p2);
        myFrameGUI.setVisible(true);
    }

    private void addCalculatorListener() {   //Регистрация слушателя для кнопок
        calculatorListener = (CalculatorListener) context.getBean("calculatorListener"); //связываем с нашим калькулятором (передача данных между классами)
        buttonPlus.addActionListener(calculatorListener);
        buttonMinus.addActionListener(calculatorListener);
        buttonMultiply.addActionListener(calculatorListener);
        buttonDivide.addActionListener(calculatorListener);
        buttonClean.addActionListener(calculatorListener);
    }

    private void addFocusListener() {
        calcFieldsFocusListener1 = (CalcFieldsFocusListener) context.getBean("calcFieldsFocusListener1");
        calcFieldsFocusListener2 = (CalcFieldsFocusListener) context.getBean("calcFieldsFocusListener2");
        field1.addFocusListener(calcFieldsFocusListener1);
        field2.addFocusListener(calcFieldsFocusListener2);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel(new TextureLookAndFeel());
        JFrame.setDefaultLookAndFeelDecorated(true);

        StartCalculator start = new StartCalculator();

        start.createLabels();
        start.createTextFields();
        start.createButtons();
        start.createPanels();
        start.createFrame();
        start.addCalculatorListener();
        start.addFocusListener();

    }

}
















