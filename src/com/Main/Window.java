package com.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Window extends JFrame implements WindowListener, ActionListener {
    private final Font font1 = new Font("San Francisco", Font.PLAIN, 80);
    private final Font font2 = new Font("San Francisco", Font.PLAIN, 20);
    private final Font font3 = new Font("San Francisco", Font.PLAIN, 45);

    private final JLayeredPane homeLayer = new JLayeredPane();
    private final JTextField article = new JTextField("Tic-Tac-Toe Game");
    private final JButton playButton = new JButton("Play");
    private final JButton exitButton = new JButton("Exit");

    private final JLayeredPane menuLayer = new JLayeredPane();
    private final JButton withBot = new JButton("Play with a bot");
    private final JButton withFriend = new JButton("Play with a friend");
    private final JButton exitButton2 = new JButton("Exit");
    private boolean gameWithBot;

    private final JLayeredPane gameLayer = new JLayeredPane();
    private int emptyFieldCnt = 9;
    private boolean gotWinner = false;
    private JTextField xCnt = new JTextField();
    private JLabel xCntLabel = new JLabel();
    private JTextField oCnt = new JTextField();
    private JLabel oCntLabel = new JLabel();
    private int xCntInt = 0;
    private int oCntInt = 0;
    private JButton btn1 = new JButton("");
    private JButton btn2 = new JButton("");
    private JButton btn3 = new JButton("");
    private JButton btn4 = new JButton("");
    private JButton btn5 = new JButton("");
    private JButton btn6 = new JButton("");
    private JButton btn7 = new JButton("");
    private JButton btn8 = new JButton("");
    private JButton btn9 = new JButton("");
    private final JButton again = new JButton("Again");
    private final JButton menu = new JButton("Menu");
    private final JButton reset = new JButton("Reset");
    private JLabel result = new JLabel();

    private JButton[] btns = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};

    public Window () {
        setTitle("Tic-Tac-Toe Game");
        setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setSize(466, 680);
        setLocation(630, 230);
        getContentPane().setBackground(new Color(80, 80, 80));

//      -----------------homeLayer------------------------
        homeLayer.setBounds(0, 0, 466, 680);
        add(homeLayer);

        article.setSize(450, 150);
        article.setLocation(0, 150);
        article.setFont(font3);
        article.setBackground(new Color(146, 146, 146));
        article.setBorder(BorderFactory.createMatteBorder( 0, 0 , 0 ,0 , Color.BLACK));
        article.setEditable(false);
        article.setVisible(true);
        article.setHorizontalAlignment(SwingConstants.CENTER);
        article.setBorder(BorderFactory.createMatteBorder(
                4, 0, 4, 0, new Color(51, 51, 51)));
        homeLayer.add(article);

        playButton.setBackground(new Color(141, 255, 141));
        playButton.setBorder(BorderFactory.createMatteBorder(
                0, 0, 4, 4, new Color(51, 51, 51)));
        playButton.setSize(150, 50);
        playButton.setLocation(150, 450);
        playButton.setFont(font2);
        playButton.setVisible(true);
        homeLayer.add(playButton);
        playButton.addActionListener(this);
        playButton.setFocusPainted(false);

        exitButton.setBackground(new Color(255, 141, 141));
        exitButton.setBorder(BorderFactory.createMatteBorder(
                0, 0, 4, 4, new Color(51, 51, 51)));
        exitButton.setSize(150, 50);
        exitButton.setLocation(150, 505);
        exitButton.setFont(font2);
        exitButton.setVisible(true);
        homeLayer.add(exitButton);
        exitButton.addActionListener(this);
        exitButton.setFocusPainted(false);

//      -----------------menuLayer------------------------
        menuLayer.setBounds(0, 0, 466, 680);
        add(menuLayer);
        menuLayer.setVisible(false);

        withBot.setBackground(new Color(141, 255, 141));
        withBot.setBorder(BorderFactory.createMatteBorder(
                0, 0, 4, 4, new Color(51, 51, 51)));
        withBot.setSize(400, 60);
        withBot.setLocation(33, 167);
        withBot.setFont(font2);
        withBot.setVisible(true);
        menuLayer.add(withBot);
        withBot.addActionListener(this);
        withBot.setFocusPainted(false);

        withFriend.setBackground(new Color(141, 255, 141));
        withFriend.setBorder(BorderFactory.createMatteBorder(
                0, 0, 4, 4, new Color(51, 51, 51)));
        withFriend.setSize(400, 60);
        withFriend.setLocation(33, 232);
        withFriend.setFont(font2);
        withFriend.setVisible(true);
        menuLayer.add(withFriend);
        withFriend.addActionListener(this);
        withFriend.setFocusPainted(false);

        exitButton2.setBackground(new Color(255, 141, 141));
        exitButton2.setBorder(BorderFactory.createMatteBorder(
                0, 0, 4, 4, new Color(51, 51, 51)));
        exitButton2.setSize(150, 50);
        exitButton2.setLocation(150, 505);
        exitButton2.setFont(font2);
        exitButton2.setVisible(true);
        menuLayer.add(exitButton2);
        exitButton2.addActionListener(this);
        exitButton2.setFocusPainted(false);

//      -----------------gameLayer------------------------
        gameLayer.setBounds(0, 0, 466, 680);
        gameLayer.setVisible(false);
        add(gameLayer);

        xCntLabel.setText("<html><b>X score:</b></html>");
        xCntLabel.setFont(font2);
        xCntLabel.setForeground(new Color(255, 141, 141));
        xCntLabel.setSize(150, 50);
        xCntLabel.setLocation(0, -10);
        xCntLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gameLayer.add(xCntLabel);

        oCntLabel.setText("<html><b>O score:</b></html>");
        oCntLabel.setFont(font2);
        oCntLabel.setForeground(new Color(255, 141, 141));
        oCntLabel.setSize(150, 50);
        oCntLabel.setLocation(300, -10);
        oCntLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gameLayer.add(oCntLabel);

        xCnt.setText("0");
        xCnt.setFont(font2);
        xCnt.setBackground(new Color(51, 51, 51));
        xCnt.setForeground(new Color(146, 146, 146));
        xCnt.setBorder(BorderFactory.createMatteBorder(
                3, 3, 3, 3, new Color(255, 141, 141)));
        xCnt.setSize(77, 50);
        xCnt.setLocation(36, 30);
        xCnt.setHorizontalAlignment(SwingConstants.CENTER);
        xCnt.setFocusable(false);
        gameLayer.add(xCnt);

        result.setSize(150, 50);
        result.setLocation(150, 30);
        result.setFont(font2);
        result.setForeground(new Color(141, 255, 141));
        result.setBackground(Color.WHITE);
        result.setVisible(true);
        result.setHorizontalAlignment(SwingConstants.CENTER);
        gameLayer.add(result);

        oCnt.setText("0");
        oCnt.setFont(font2);
        oCnt.setBackground(new Color(51, 51, 51));
        oCnt.setForeground(new Color(146, 146, 146));
        oCnt.setBorder(BorderFactory.createMatteBorder(
                3, 3, 3, 3, new Color(255, 141, 141)));
        oCnt.setSize(77, 50);
        oCnt.setLocation(338, 30);
        oCnt.setHorizontalAlignment(SwingConstants.CENTER);
        oCnt.setFocusable(false);
        gameLayer.add(oCnt);

        btn1.setLocation(2, 100);
        btn2.setLocation(152, 100);
        btn3.setLocation(302, 100);
        btn4.setLocation(2, 250);
        btn5.setLocation(152, 250);
        btn6.setLocation(302, 250);
        btn7.setLocation(2, 400);
        btn8.setLocation(152, 400);
        btn9.setLocation(302, 400);

        for (var btn : btns) {
            btn.setSize(146, 146);
            btn.setBackground(Color.WHITE);
            btn.setFont(font1);
            btn.setVisible(true);
            gameLayer.add(btn);
            btn.addActionListener(this);
            btn.setFocusPainted(false);
            btn.setBackground(new Color(146, 146, 146));
            btn.setBorder(BorderFactory.createMatteBorder(
                    0, 0, 4, 4, new Color(51, 51, 51)));
        }

        reset.setSize(146, 50);
        reset.setLocation(302, 570);
        reset.setFont(font2);
        reset.setBackground(new Color(255, 141, 141));
        reset.setBorder(BorderFactory.createMatteBorder(
                0, 0, 4, 4, new Color(51, 51, 51)));
        reset.setVisible(true);
        reset.addActionListener(this);
        reset.setFocusPainted(false);
        gameLayer.add(reset);

        again.setSize(146, 50);
        again.setLocation(152, 570);
        again.setFont(font2);
        again.setBackground(new Color(255, 141, 141));
        again.setBorder(BorderFactory.createMatteBorder(
                0, 0, 4, 4, new Color(51, 51, 51)));
        again.setVisible(true);
        again.addActionListener(this);
        again.setFocusPainted(false);
        gameLayer.add(again);

        menu.setSize(146, 50);
        menu.setLocation(2, 570);
        menu.setFont(font2);
        menu.setBackground(new Color(255, 141, 141));
        menu.setBorder(BorderFactory.createMatteBorder(
                0, 0, 4, 4, new Color(51, 51, 51)));
        menu.setVisible(true);
        menu.addActionListener(this);
        menu.setFocusPainted(false);
        gameLayer.add(menu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            homeLayer.setVisible(false);
            menuLayer.setVisible(true);
        }

        if (e.getSource() == exitButton || e.getSource() == exitButton2) {
            System.exit(0);
        }

        if (e.getSource() == withBot) {
            result.setText("");
            gameWithBot = true;
            menuLayer.setVisible(false);
            gameLayer.setVisible(true);
        }

        if (e.getSource() == withFriend) {
            result.setText("<html><b>X turn</b></html>");
            gameWithBot = false;
            menuLayer.setVisible(false);
            gameLayer.setVisible(true);
        }

        for (var btn : btns) {
            if (e.getSource() == btn && gotWinner == false) {
                if (btn.getText() == "") {
                    if (gameWithBot) {
                        btn.setText("X");
                    } else {
                        result.setText("<html><b>X turn</b></html>");
                        if (emptyFieldCnt % 2 != 0) {
                            btn.setText("X");
                            result.setText("<html><b>O turn</b></html>");

                        } else {
                            btn.setText("O");
                            result.setText("<html><b>X turn</b></html>");
                        }
                    }
                    emptyFieldCnt--;
                    checkForResult();
                    if (gameWithBot) {
                        if (result.getText() == "" && emptyFieldCnt != 0) {
                            botStep();
                        }
                    }
                }
            }
        }

        if (e.getSource() == again) {
            clearField();
            gotWinner = false;
            emptyFieldCnt = 9;
        }

        if (e.getSource() == menu) {
            clearField();
            clearScore();
            gameLayer.setVisible(false);
            menuLayer.setVisible(true);
            gotWinner = false;
        }

        if (e.getSource() == reset) {
            clearField();
            clearScore();
            gotWinner = false;
        }
    }

    public void clearScore() {
        xCntInt = 0;
        oCntInt = 0;
        xCnt.setText(String.valueOf(xCntInt));
        oCnt.setText(String.valueOf(oCntInt));
    }

    public void clearField() {
        for (var btn : btns) {
            btn.setText("");
            btn.setBackground(new Color(146, 146, 146));
        }
        if (gameWithBot) {
            result.setText("");
        } else {
            result.setText("<html><b>X turn</b></html>");
        }
        emptyFieldCnt = 9;
    }

    public int findRandNum() {
        return (int) (Math.random() * 9);
    }

    public void botStep() {
        if (btn1.getText()== "O" && btn2.getText()== "O" && btn3.getText()== "") {
            btn3.setText("O");
        } else if (btn4.getText()== "O" && btn5.getText()== "O" && btn6.getText()== "") {
            btn6.setText("O");
        } else if (btn7.getText()== "O" && btn8.getText()== "O" && btn9.getText()== "") {
            btn9.setText("O");
        } else if (btn1.getText()== "" && btn2.getText()== "O" && btn3.getText()== "O") {
            btn1.setText("O");
        } else if (btn4.getText()== "" && btn5.getText()== "O" && btn6.getText()== "O") {
            btn4.setText("O");
        } else if (btn7.getText()== "" && btn8.getText()== "O" && btn9.getText()== "O") {
            btn7.setText("O");
        }else if (btn1.getText()== "O" && btn2.getText()== "" && btn3.getText()== "O") {
            btn2.setText("O");
        } else if (btn4.getText()== "O" && btn5.getText()== "" && btn6.getText()== "O") {
            btn5.setText("O");
        } else if (btn7.getText()== "O" && btn8.getText()== "" && btn9.getText()== "O") {
            btn8.setText("O");
        } else if (btn1.getText()== "O" && btn4.getText()== "O" && btn7.getText()== "") {
            btn7.setText("O");
        } else if (btn2.getText()== "O" && btn5.getText()== "O" && btn8.getText()== "") {
            btn8.setText("O");
        } else if (btn3.getText()== "O" && btn6.getText()== "O" && btn9.getText()== "") {
            btn9.setText("O");
        } else if (btn1.getText()== "" && btn4.getText()== "O" && btn7.getText()== "O") {
            btn1.setText("O");
        } else if (btn2.getText()== "" && btn5.getText()== "O" && btn8.getText()== "O") {
            btn2.setText("O");
        } else if (btn3.getText()== "" && btn6.getText()== "O" && btn9.getText()== "O") {
            btn3.setText("O");
        } else if (btn1.getText()== "O" && btn4.getText()== "" && btn7.getText()== "O") {
            btn4.setText("O");
        } else if (btn2.getText()== "O" && btn5.getText()== "" && btn8.getText()== "O") {
            btn5.setText("O");
        } else if (btn3.getText()== "O" && btn6.getText()== "" && btn9.getText()== "O") {
            btn6.setText("O");
        } else if (btn1.getText()== "O" && btn5.getText()== "O" && btn9.getText()== "") {
            btn9.setText("O");
        } else if (btn1.getText()== "" && btn5.getText()== "O" && btn9.getText()== "O") {
            btn1.setText("O");
        } else if (btn1.getText()== "O" && btn5.getText()== "" && btn9.getText()== "O") {
            btn5.setText("O");
        } else if (btn3.getText()== "O" && btn5.getText()== "O" && btn7.getText()== "") {
            btn7.setText("O");
        } else if (btn3.getText()== "" && btn5.getText()== "O" && btn7.getText()== "O") {
            btn3.setText("O");
        } else if (btn3.getText()== "O" && btn5.getText()== "" && btn7.getText()== "O") {
            btn5.setText("O");
        }
        
        else if (btn1.getText()== "X" && btn2.getText()== "X" && btn3.getText()== "") {
            btn3.setText("O");
        } else if (btn4.getText()== "X" && btn5.getText()== "X" && btn6.getText()== "") {
            btn6.setText("O");
        } else if (btn7.getText()== "X" && btn8.getText()== "X" && btn9.getText()== "") {
            btn9.setText("O");
        } else if (btn1.getText()== "" && btn2.getText()== "X" && btn3.getText()== "X") {
            btn1.setText("O");
        } else if (btn4.getText()== "" && btn5.getText()== "X" && btn6.getText()== "X") {
            btn4.setText("O");
        } else if (btn7.getText()== "" && btn8.getText()== "X" && btn9.getText()== "X") {
            btn7.setText("O");
        }else if (btn1.getText()== "X" && btn2.getText()== "" && btn3.getText()== "X") {
            btn2.setText("O");
        } else if (btn4.getText()== "X" && btn5.getText()== "" && btn6.getText()== "X") {
            btn5.setText("O");
        } else if (btn7.getText()== "X" && btn8.getText()== "" && btn9.getText()== "X") {
            btn8.setText("O");
        } else if (btn1.getText()== "X" && btn4.getText()== "X" && btn7.getText()== "") {
            btn7.setText("O");
        } else if (btn2.getText()== "X" && btn5.getText()== "X" && btn8.getText()== "") {
            btn8.setText("O");
        } else if (btn3.getText()== "X" && btn6.getText()== "X" && btn9.getText()== "") {
            btn9.setText("O");
        } else if (btn1.getText()== "" && btn4.getText()== "X" && btn7.getText()== "X") {
            btn1.setText("O");
        } else if (btn2.getText()== "" && btn5.getText()== "X" && btn8.getText()== "X") {
            btn2.setText("O");
        } else if (btn3.getText()== "" && btn6.getText()== "X" && btn9.getText()== "X") {
            btn3.setText("O");
        } else if (btn1.getText()== "X" && btn4.getText()== "" && btn7.getText()== "X") {
            btn4.setText("O");
        } else if (btn2.getText()== "X" && btn5.getText()== "" && btn8.getText()== "X") {
            btn5.setText("O");
        } else if (btn3.getText()== "X" && btn6.getText()== "" && btn9.getText()== "X") {
            btn6.setText("O");
        } else if (btn1.getText()== "X" && btn5.getText()== "X" && btn9.getText()== "") {
            btn9.setText("O");
        } else if (btn1.getText()== "" && btn5.getText()== "X" && btn9.getText()== "X") {
            btn1.setText("O");
        } else if (btn1.getText()== "X" && btn5.getText()== "" && btn9.getText()== "X") {
            btn5.setText("O");
        } else if (btn3.getText()== "X" && btn5.getText()== "X" && btn7.getText()== "") {
            btn7.setText("O");
        } else if (btn3.getText()== "" && btn5.getText()== "X" && btn7.getText()== "X") {
            btn3.setText("O");
        } else if (btn3.getText()== "X" && btn5.getText()== "" && btn7.getText()== "X") {
            btn5.setText("O");
        }
        else {
            int num = 0;
            do {
                num = findRandNum();
            } while (btns[num].getText() != "");
            btns[num].setText("O");
        }
        emptyFieldCnt--;
        checkForResult();
    }

    public void checkForResult() {
        if (btn1.getText()== "X" && btn2.getText()== "X" && btn3.getText()== "X") {
            xWins(1, 2, 3);
        } 
        if (btn4.getText()== "X" && btn5.getText()== "X" && btn6.getText()== "X") {
            xWins(4, 5, 6);
        }
        if (btn7.getText()== "X" && btn8.getText()== "X" && btn9.getText()== "X") {
            xWins(7, 8, 9);
        }
        if (btn1.getText()== "X" && btn4.getText()== "X" && btn7.getText()== "X") {
            xWins(1, 4, 7);
        }
        if (btn2.getText()== "X" && btn5.getText()== "X" && btn8.getText()== "X") {
            xWins(2, 5, 8);
        }
        if (btn3.getText()== "X" && btn6.getText()== "X" && btn9.getText()== "X") {
            xWins(3, 6, 9);
        }
        if (btn1.getText()== "X" && btn5.getText()== "X" && btn9.getText()== "X") {
            xWins(1, 5, 9);
        }
        if (btn3.getText()== "X" && btn5.getText()== "X" && btn7.getText()== "X") {
            xWins(3, 5, 7);
        }

        if (btn1.getText()== "O" && btn2.getText()== "O" && btn3.getText()== "O") {
            oWins(1, 2, 3);
        }
        if (btn4.getText()== "O" && btn5.getText()== "O" && btn6.getText()== "O") {
            oWins(4, 5, 6);
        }
        if (btn7.getText()== "O" && btn8.getText()== "O" && btn9.getText()== "O") {
            oWins(7, 8, 9);
        }
        if (btn1.getText()== "O" && btn4.getText()== "O" && btn7.getText()== "O") {
            oWins(1, 4, 7);
        }
        if (btn2.getText()== "O" && btn5.getText()== "O" && btn8.getText()== "O") {
            oWins(2, 5, 8);
        }
        if (btn3.getText()== "O" && btn6.getText()== "O" && btn9.getText()== "O") {
            oWins(3, 6, 9);
        }
        if (btn1.getText()== "O" && btn5.getText()== "O" && btn9.getText()== "O") {
            oWins(1, 5, 9);
        }
        if (btn3.getText()== "O" && btn5.getText()== "O" && btn7.getText()== "O") {
            oWins(3, 5, 7);
        }

        if (emptyFieldCnt == 0 && gotWinner == false) {
            draw();
        }
    }

    public void xWins(int num1, int num2, int num3) {
        btns[num1 - 1].setBackground(new Color(141, 255, 141));
        btns[num2 - 1].setBackground(new Color(141, 255, 141));
        btns[num3 - 1].setBackground(new Color(141, 255, 141));
        result.setText("<html><b>X won!</b></html>");
        xCntInt++;
        xCnt.setText(String.valueOf(xCntInt));
        gotWinner = true;
    }

    public void oWins(int num1, int num2, int num3) {
        btns[num1 - 1].setBackground(new Color(141, 255, 141));
        btns[num2 - 1].setBackground(new Color(141, 255, 141));
        btns[num3 - 1].setBackground(new Color(141, 255, 141));
        result.setText("<html><b>O won!</b></html>");
        oCntInt++;
        oCnt.setText(String.valueOf(oCntInt));
        gotWinner = true;
    }

    public void draw() {
        result.setText("<html><b>Draw!</b></html>");
        gotWinner = true;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}

