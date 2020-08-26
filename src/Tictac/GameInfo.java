package Tictac;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameInfo extends JFrame {
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 270;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String FIELD_SIZE_PREFIX = "  Your total score: ";
    private static final String WIN_LENGTH_PREFIX = "  Opponent total score: ";

    private GameWindow gameWindow;
    private JRadioButton humVSAI;
    private JRadioButton humVShum;
    private JSlider slideWinLen;
    private JSlider slideFieldSize;

    GameInfo(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);
        setTitle("Information about all games");
        setLayout(new GridLayout(10, 1));
        addGameModeControls();
        JButton btnStart = new JButton("Ok");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartClick();
            }
        });
        add(btnStart);
    }


    private void addGameModeControls() {
        add(new JLabel("  Choose game mode:"));
        humVSAI = new JRadioButton("Human vs. AI", true);
        humVShum = new JRadioButton("Human vs. Human");
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humVSAI);
        gameMode.add(humVShum);
        add(humVSAI);
        add(humVShum);
        add(new JLabel("  Your total score:"));
        add(new JLabel("  Opponent total score:"));
    }


    private void btnStartClick() {
        int fieldSize = slideFieldSize.getValue();
        int winLen = slideWinLen.getValue();

        int gameMode;
        if (humVSAI.isSelected()) {
            gameMode = Map.MODE_HVA;
        } else if (humVShum.isSelected()) {
            gameMode = Map.MODE_HVH;
        } else {
            throw new RuntimeException("Unexpected game mode!");
        }

        gameWindow.startNewGame(gameMode, fieldSize, fieldSize, winLen);

        setVisible(false);
    }
}