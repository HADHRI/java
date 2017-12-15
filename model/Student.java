package model;

import controller.GameManager;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class Student extends Person {


   // public static GameManager gameManager;
    private int capacity;
    private ArrayList history = new ArrayList();

    //Temporaire pour savoir la taille de l image , apres ça sera un attribut Image dans l etudiant
    ImageIcon ic = new ImageIcon("src/views/e2.png");

  /* // code temporaire heigth et width de la fenetre
    Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    int height = (int) dimension.getHeight();
    int width = (int) dimension.getWidth();
    //*/

    public Student(float x, float y) {
        pos = new Point2D.Float(x, y);
        speed = new Point2D.Float();
        posInter= (Point2D.Float) pos.clone();
        widthImage = ic.getIconWidth();
        heigthImage = ic.getIconHeight();
    }



    /*public Rectangle getBounds() {
        return new Rectangle((int) posInter.getX(), (int) (posInter.getY()), widthImage, heigthImage);
    }*/

    // sert à changer le vecteur vitesse
    /*public void ChangeDirection(Student s) {
        //nbTours=nbrTourmax;

        // 2 eme methode
        newDirection(speed);
        s.speed.setLocation(-speed.getX(), -speed.getY());
    }*/

    private float probability(int difficulty) {
        final float a = 1f / 225f, b = 1f / 15f;
        final int delta = capacity - difficulty;
        float res;
        System.out.println(delta);

        if (delta < -15) {
            res = 0f;
        } else if (delta > 15) {
            res = 1f;
        } else if (delta == 0) {
            res = 0.5f;
        } else if (delta < 0) {
            res = +(0.5f) * a * delta * delta + b * delta + (0.5f);
        } else {
            res = ((-0.5f) * a * delta * delta + b * delta) + 0.5f;
        }
        return (res);
    }
}





