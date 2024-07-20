package com.javarush.games.minigames.mini05;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

/* 
Цвета радуги
*/

public class RainbowGame extends Game {

    //напишите тут ваш код

    @Override
    public void initialize() {
        setScreenSize(10, 7);

        for (int x = 0; x < getScreenWidth(); x++) {
            setCellColor(x, 0, Color.RED);
            setCellColor(x, 1, Color.ORANGE);
            setCellColor(x, 2, Color.YELLOW);
            setCellColor(x, 3, Color.GREEN);
            setCellColor(x, 4, Color.BLUE);
            setCellColor(x, 5, Color.INDIGO);
            setCellColor(x, 6, Color.VIOLET);
        }
    }
}
