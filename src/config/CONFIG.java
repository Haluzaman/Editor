package config;

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

    public static void computeByteSizes(){
        TILE_WIDTH_BYTE = (int)Math.sqrt(TILE_WIDTH);
        TILE_HEIGHT_BYTE = (int)Math.sqrt(TILE_HEIGHT);
    }
}