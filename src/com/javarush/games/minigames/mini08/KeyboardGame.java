package com.javarush.games.minigames.mini08;

import com.javarush.engine.cell.*;

/* 
Работа с клавиатурой
*/

public class KeyboardGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(3, 3);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                setCellColor(x, y, Color.WHITE);
            }
        }
    }

    //напишите тут ваш код
    @Override
    public void onKeyPress(Key key) {
        if (key == Key.LEFT) {
            for (int y = 0; y < 3; y++) {
                setCellColor(0, y, Color.GREEN);
            }
        }
        if (key == Key.RIGHT) {
            for (int y = 0; y < 3; y++) {
                setCellColor(2, y, Color.GREEN);
            }
        }
        if (key == Key.UP) {
            for (int x = 0; x < 3; x++) {
                setCellColor(x, 0, Color.GREEN);
            }
        }
        if (key == Key.DOWN) {
            for (int x = 0; x < 3; x++) {
                setCellColor(x, 2, Color.GREEN);
            }
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.LEFT || key == Key.RIGHT || key == Key.UP || key == Key.DOWN) {
            for (int x = 0; x < getScreenWidth(); x++) {
                for (int y = 0; y < getScreenHeight(); y++) {
                    setCellColor(x, y, Color.WHITE);
                }
            }
        }
    }
}
