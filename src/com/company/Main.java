package com.company;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Main extends KeyAdapter {

   static  int width = 1280;
   static int height = 716;



    //магический код
    public static void main(String[] args) {
        JFrame frame = new JFrame("Distribution of numbers");
        frame.setBackground(Color.black);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.createBufferStrategy(2);
        frame.addKeyListener(new Main());
        //frame.add
        while (true) {
            BufferStrategy bs = frame.getBufferStrategy();
            Graphics g = bs.getDrawGraphics();
            g.clearRect(0, 0, width, height);
            paint(g);
            bs.show();
            g.dispose();
        }

    }

    //Тут добавляем данные которые храним между кадрами
    static long lastFrame = System.currentTimeMillis();
    static double zoom = 1;
    static int number = 3000;
    //Тут обновялем данные и рисуем
    public static void paint(Graphics g) {
         int[] daSet = new int[number];
        {
            for (int i = 0; i <daSet.length ; i++) {
                daSet[i] = i+1;
            }
        }
        //вычисляем длинну кадра
        long currentFrame = System.currentTimeMillis();
        double dt = (currentFrame - lastFrame) / 1000.0;
        lastFrame = currentFrame;


        //рисуем

        g.setColor(Color.BLUE);
        for (int i = 0; i <daSet.length ; i++) {
            new Vektor(0,0).polar(daSet[i], daSet[i]).umnojenie(zoom).summ(new Vektor(width/2, height/2)).drawer(g);
        }

        g.setColor(Color.WHITE);
        g.drawString("+,-:"+Double.toString(zoom), width - 60, 50);
        g.drawString("M,L:"+Integer.toString(number), width - 70, 70);



    }
    public void keyPressed(KeyEvent e) {
       if (e.getKeyCode() == KeyEvent.VK_UP){
           if (zoom != 1) zoom += 0.005;
       }
       else{
           if (e.getKeyCode() == KeyEvent.VK_DOWN){
               if (zoom !=0){
                   zoom -= 0.005;
               }
           }
       }
       if (e.getKeyCode() == KeyEvent.VK_M){
           number += 500;
       }else{
           if (e.getKeyCode() == KeyEvent.VK_L){
                if (number != 0) number -= 500;
           }
       }
    }


   }