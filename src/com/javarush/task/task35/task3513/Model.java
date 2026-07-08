package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;

    public Model() {
        resetGameTiles();
     }

    private List<Tile> getEmptyTiles() {
        List<Tile> listEmptyTiles = new ArrayList<>();
        Arrays.stream(gameTiles).forEach(tile -> Arrays.stream(tile)
                .filter(Tile::isEmpty)
                .forEach(listEmptyTiles::add));
        return listEmptyTiles;
    }

    private void addTile() {
        List<Tile> listEmptyTiles = getEmptyTiles();
        if (!listEmptyTiles.isEmpty()) {
            Tile emptyTile = listEmptyTiles.get((int) (listEmptyTiles.size() * Math.random()));
            emptyTile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    void resetGameTiles () {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }
}
