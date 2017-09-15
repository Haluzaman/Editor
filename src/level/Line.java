package level;

import graphics.Screen;

import java.awt.*;

/**
 * Created by bubof on 30.08.2017.
 */
public class Line {

    public static Color color = Color.BLACK;

    private int x;
    private int y;
    private int targetX;
    private int targetY;

    private int screenX;
    private int screenY;
    private Screen screen;
    private boolean isVertical;
    public Line(Screen screen,int x,int y,int targetX,int targetY){
        this.screen = screen;
        this.x = x;
        this.y = y;
        this.targetX = targetX;
        this.targetY = targetY;
        this.isVertical = isVertical();
    }

    public void draw(int i){
//        System.out.println("drawing");
        if(isOnScreen()){
//            System.out.println("drawing on screen " + i + " " + isVertical);
            screen.drawStraightLine(screenX,screenY,screen.getWidth(),screen.getHeight(),Line.color,isVertical);
        }else{
//            System.out.println("na mieste " + i + "isVertical");
        }

    }

    public boolean isOnScreen(){
        if(isVertical){
            this.screenX = this.x - screen.getX();
            if(this.screenX < 0 || this.screenX > screen.getX()+screen.getWidth())
                return false;
            this.screenY = this.y - screen.getY();
            if(this.screenY < 0)
                this.screenY = 0;
        }else{
            this.screenY = this.y - screen.getY();
            if(this.screenY < 0 || this.screenY > screen.getY()+screen.getHeight())
                return false;
            this.screenX = this.x - screen.getX();
            if(this.screenX < 0)
                this.screenX = 0;
        }
        return true;
    }

    private boolean isVertical(){
        if(this.x == this.targetX){
            return true;
        }else if(this.y == this.targetY){
            return false;
        }else {
            System.out.println("Line, isVertical: weird statement");
            return true;
        }
    }
}
