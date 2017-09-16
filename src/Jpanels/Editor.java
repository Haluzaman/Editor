package Jpanels;

import graphics.Screen;
import level.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Created by bubof on 27.05.2017.
 */
public class Editor extends JPanel implements Runnable{

    private Thread thread;
    private final int FPS = 60;
    private boolean isRunning;

    private Graphics2D g;

    private final long targetTime = 1000/FPS;
    private int[] pixels;
    private BufferedImage image;

    private Screen screen;
    private Level level;
    public Editor(){
        Dimension d = new Dimension(EditorPanel.WIDTH*EditorPanel.SCALE,EditorPanel.HEIGHT*EditorPanel.SCALE);
        setPreferredSize(d);
        setFocusable(true);
        requestFocus();
        requestFocusInWindow();
        init();

    }

    public void init(){
        screen = new Screen(EditorPanel.WIDTH,EditorPanel.HEIGHT);
        image = new BufferedImage(EditorPanel.WIDTH,EditorPanel.HEIGHT,BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
        isRunning = true;
        level = new Level(screen);
        System.out.println(isRunning);
        if(thread == null){
            thread = new Thread(this);
            thread.start();
            System.out.println("Running Editor");
        }
    }


    public void draw(){
        screen.clear();
        level.draw();
        int pix[] = screen.getPixels();
        //drawing screen pixels actually on our screen
        for(int i = 0; i < pix.length;i++)
            this.pixels[i] = pix[i];

    }

    public void drawToScreen(){
        Graphics g2 = getGraphics();
        if(g2 == null) {
            System.out.println("returning null");
            return;
        }
        g2.drawImage(image,0,0,EditorPanel.WIDTH*EditorPanel.SCALE,EditorPanel.HEIGHT*EditorPanel.SCALE,null);
        g2.dispose();
    }

    public void update(){

    }


    public void run(){
        long start;
        long elapsed;
        long wait;
        while(isRunning){
            start = System.nanoTime();
            update();
            draw();
            drawToScreen();
            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed / 1000000;
            if(wait < 0) wait = 5;
            try{
                thread.sleep(wait);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void keyPressed(int key){
        level.keyPressed(key);
    }
    public void keyReleased(KeyEvent k){
        level.keyReleased(k.getKeyCode());
    }
    public void keyTyped(KeyEvent k){
        level.keyTyped(k.getKeyCode());
    }
}
