package level;

import config.CONFIG;
import entity.Entity;
import entity.Player;
import graphics.Graphics;
import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by bubof on 09.07.2017.
 */
public class Level {

    private Map map;
    private Player player;
    private Screen screen;
    private boolean playerIsSet = false;
    private ArrayList<Entity> entities = new ArrayList<Entity>();
    private Line[] lines;
    public Level(Screen screen){
        this.screen = screen;
        map = new Map(CONFIG.NUMBER_OF_COLUMNS,CONFIG.NUMBER_OF_ROWS); //((screen.getRenderHeight()>>1)<<Game.TILE_BYTE_SIZE)+2*Game.TILESIZE --->> Y
        player = new Player(screen,map,-100,-100,CONFIG.TILE_WIDTH,CONFIG.TILE_HEIGHT,0,0,CONFIG.TILE_WIDTH-1,CONFIG.TILE_HEIGHT-1);
        screen.setBounds(map.getLevelWidth()<<CONFIG.TILE_WIDTH_BYTE,map.getLevelHeight()<<CONFIG.TILE_HEIGHT_BYTE);
        screen.center(100,100);
        lines = new Line[CONFIG.NUMBER_OF_COLUMNS+1 + CONFIG.NUMBER_OF_ROWS + 1];
        int y;
        for(y = 0;y < CONFIG.NUMBER_OF_ROWS+1;y++){
            lines[y] = new Line(screen,0,y*CONFIG.TILE_HEIGHT,CONFIG.NUMBER_OF_COLUMNS*CONFIG.TILE_WIDTH,y*CONFIG.TILE_HEIGHT);
        }
//        lines[y] = new Line(screen,0,y*CONFIG.TILE_HEIGHT,CONFIG.NUMBER_OF_COLUMNS*CONFIG.TILE_WIDTH,y*CONFIG.TILE_HEIGHT);
        int xx = 0;
        for(int x = y;x < lines.length;x++){
            lines[x] = new Line(screen,xx*CONFIG.TILE_WIDTH,0,xx*CONFIG.TILE_WIDTH,CONFIG.NUMBER_OF_ROWS*CONFIG.TILE_HEIGHT);
            xx++;
        }
    }

    public void draw(){
        screen.renderMap(this.map);
        if(playerIsSet)
            player.render();
//        screenX = (int)(rX - screen.getX());
//        screenY = (int)(rY - screen.getY());
//        Graphics.drawRectangle(screen,player.getScreenX(),player.getScreenY(),player.getCollisionWidth(),player.getCollisionHeight(), Color.YELLOW);
//        screen.drawLine(50,50,70,25, Color.black);
        if(CONFIG.SHOW_GRID){
//            for(int i = 0;i < lines.length;i++){
//                lines[i].draw(i);
//            }
        }
    }

    public void update(double delta){
//        screen.updateMap(this.map);
        if(playerIsSet)
            player.update(delta);
//        screen.center(player.getRenderX(),player.getRenderY());
    }

    public void keyPressed(int k){
        if(k == KeyEvent.VK_RIGHT){
            screen.setOffsetX(3);
//            player.setDirection(player.RIGHT);
//            player.setVelX(1);
        }
        if(k == KeyEvent.VK_LEFT){
            screen.setOffsetX(-3);
//            player.setDirection(player.LEFT);
//            player.setVelX(-1);
//            player.step(-2,0);
        }
        if(k == KeyEvent.VK_DOWN){
            screen.setOffsetY(3);
//            player.step(0,2);
        }
        if(k == KeyEvent.VK_UP){
            screen.setOffsetY(-3);
//            player.step(0,-2);
        }if(k == KeyEvent.VK_SPACE){
//            player.setJumping(true);
//            player.setVelY(-12);
        }
    }

    public void keyReleased(int k){
        if(k == KeyEvent.VK_UP){

        }
        if(k == KeyEvent.VK_DOWN){

        }
        if(k == KeyEvent.VK_RIGHT){
//            player.setVelX(0);
//            player.setDirection(player.IDLE);
        }
        if(k == KeyEvent.VK_LEFT){
//            player.setVelX(0);
//            player.setDirection(player.IDLE);
        }
    }

    public void keyTyped(int k){}

    /**
     * Checks wether camera can move
     * */
    private void checkScreenBounds(int newX,int newY){
        int currentRightPositionX = screen.getX() + screen.getWidth() + newX;
        int currentRightPositionY = screen.getY() + screen.getHeight() + newY;
        if(playerIsSet) {
            int playerOnScreenX = player.getRenderX() - screen.getX();
            int playerOnScreenY = player.getRenderY() - screen.getY();
            boolean isCentered = false;
            int direction = player.getCurrentDirection();


            /**wether player is centered on map*/
//        if(direction == player.UP || direction == player.DOWN){
//            if(playerOnScreenY == screen.getScreenMiddleY() + newY)
//                isCentered = true;
//        }
//        else

            if (direction == player.RIGHT || direction == player.LEFT) {
                if (playerOnScreenX == screen.getScreenMiddleX() + newX)
                    isCentered = true;
            }
        /**wether map is not out of bounds on map -> we dont want to draw Black Screen*/
            if (((currentRightPositionX + newX) <= (map.getLevelWidth() << CONFIG.TILE_WIDTH_BYTE)) && (screen.getX() + newX) >= 0 && isCentered)
                screen.setOffsetX(newX);

            if (((currentRightPositionY + newY) <= (map.getLevelHeight() << CONFIG.TILE_HEIGHT_BYTE)) && screen.getY() + newY >= 0 && isCentered)
                screen.setOffsetY(newY);
        }else{

            if(((currentRightPositionX + newX) <= (map.getLevelWidth()<<CONFIG.TILE_WIDTH_BYTE)) && (screen.getX() + newX) >= 0)
                screen.setOffsetX(newX);

            if(((currentRightPositionY + newY) <= (map.getLevelHeight()<<CONFIG.TILE_HEIGHT_BYTE)) && screen.getY() + newY >= 0)
                screen.setOffsetY(newY);
        }
    }


    public Screen getScreen(){
        return this.screen;
    }

    public Map getMap(){
        return this.map;
    }

    public void setTile(Tile tile,int col,int row){
        map.setTile(tile,col,row);
    }

}
