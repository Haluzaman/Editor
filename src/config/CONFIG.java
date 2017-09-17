package config;

import level.Tile;

/**
 * Created by bubof on 30.08.2017.
 */
public class CONFIG {

    public static int NUMBER_OF_ROWS;

    public static int NUMBER_OF_COLUMNS;

    public static int TILE_WIDTH;

    public static int TILE_HEIGHT;

    public static boolean SHOW_GRID;

    public static int TILE_WIDTH_BYTE;

    public static int TILE_HEIGHT_BYTE;

    public static double FRICTION = 0.6;

    public static double GRAVITY = 0.6;

    public static Tile CURRENT_TILE = Tile.allTiles.get(0);

    public static short SCALE_CURRENT_TILE_LABEL = 5;

    public static short SCALE_TILES_PANEL = 3;
    public static void computeByteSizes(){
        TILE_WIDTH_BYTE = (int)Math.sqrt(TILE_WIDTH);
        TILE_HEIGHT_BYTE = (int)Math.sqrt(TILE_HEIGHT);
    }
}
