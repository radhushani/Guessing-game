package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessingGame extends  JFrame{

    private JPanel panel;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JButton guessButton;
    private JLabel label3;
    private JLabel label4;
    private JButton exitButton;
    private  int rand;

    public GuessingGame(){
        rand =(int)(Math.random() * 100 + 1);

        this.guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredNum = textField1.getText();

                try {
                    int num = Integer.parseInt(enteredNum);
                    if (num == rand) {
                        label4.setText("You win!!play again...");
                        textField1.setText(null);
                        newGame();
                    } else if (num < rand) {
                        label4.setText(num + " is too low,try again!");
                        textField1.setText(null);
                    } else  {
                        label4.setText(num + " is too high,try again!");
                        textField1.setText(null);
                    }
                }catch (Exception e1){
                    label4.setText("Enter a whole number between 1 and 100.");
                }
            }
        });
        this.exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    //method for play again
    public void newGame() {
        rand = (int)(Math.random() * 100 + 1);
    }

    //main method
    public static void main(String[] args) {
        JFrame frame = new JFrame("Radhushani's Hi-Lo Game!!!");
        frame.setContentPane(new GuessingGame().panel);
        frame.setVisible(true);
        frame.setSize(50,50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

    }

}
