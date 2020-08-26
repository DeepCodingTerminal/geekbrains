package Tictac;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WIN_WIDTH = 507;
    private static final int WIN_HEIGHT = 555;
    private static final int WIN_POSX = 650;
    private static final int WIN_POSY = 250;
    private Map map;
    private SettingsWindow settings;
    private Map map2;
    private GameInfo settings2;

    GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setLocation(WIN_POSX, WIN_POSY);
        setTitle("TicTacToe");
        setResizable(false);
        JButton btnStartGame = new JButton("Start new game");
        JButton btnGameInfo = new JButton("Game Info");
        map = new Map();
        settings = new SettingsWindow(this);
        map2 = new Map();
        settings2 = new GameInfo(this);
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });
        btnGameInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings2.setVisible(true);
            }
        });

        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new GridLayout(1, 2));
        panelBottom.add(btnStartGame);
        panelBottom.add(btnGameInfo);
        add(panelBottom, BorderLayout.SOUTH);
        add(map);
        setVisible(true);
    }
    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) { map.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);
    }
}