package com.company;

import java.awt.*;
import java.util.Vector;

public class Vektor {
    double vX;
    double vY;

    public Vektor(double vX, double vY) {
        this.vX = vX;
        this.vY = vY;
    }

    public void writer() {
        System.out.println("[" + vX + "," + vY + "]");
    }

    public Vektor summ(Vektor other) {
        return new Vektor(vX + other.vX, vY + other.vY);
    }//Сумма двух векторов

    public double length() {
        return Math.sqrt((vX) * (vX) + (vY) * (vY));
    }//Длина \ модуль вектора

    public Vektor umnojenie(double skalar) {
        return new Vektor((vX * skalar), (vY * skalar));
    }//Умножение на скаляр

    public Vektor minus(Vektor other) {
        return summ(other.umnojenie(-1));
    }//Вычитание двух векторов

    public double skalarnoe(Vektor other) {
        return vX * other.vX + vY * other.vY;
    }//Скалярное произведение

    public Vektor kUmn(Vektor other) {
        return new Vektor(vX + other.vX, vY + other.vY);
    }//Покоординатное умножение

    public Vektor makeNormal() {
        return umnojenie(1 / length());
    }//Нормализация

    public double angle(Vektor other) {
        if (vX * other.vY - vY * other.vX >= 0) {
            return Math.acos((skalarnoe(other)) / (length() * other.length()));
        } else {
            return -Math.acos((skalarnoe(other)) / (length() * other.length()));
        }

    }//Угол между векторами

    public void drawer (Graphics g){
        g.fillOval((int) vX,(int) vY,3,3);
    }//рисуем

    public Vektor polar (double length, double angel){
        return new Vektor(Math.cos(angel)*length , Math.sin(angel)*length);
    }//Задание вектора полярными координатами

    public Vektor rotator(double angel) {
        return new Vektor(vX * Math.cos(angel) + vY * (-Math.sin(angel)), vX * Math.sin(angel) + vY * Math.cos(angel));
    }//Поворот


}
