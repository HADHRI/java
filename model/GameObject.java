package model;

import controller.GameManager;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

public class GameObject {
    private int id=0;
    private String name;
    protected Point2D.Float pos; // Toujours initialiser pos
    protected boolean onCollision = false; //savoir si l etudiant est en collission ou non
    public static GameManager gameManager; // c est utile??

    // code temporaire heigth et width de la fenetre
    Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    int height = (int) dimension.getHeight();
    int width = (int) dimension.getWidth();
    //
    protected int widthImage;
    protected int heigthImage;

    // est ce que on la met abstract?
    public void update(){

    }



    public String getName() {
        return name;
    }
    // Pas forcément utile si on le set dans le constructeur
    public void setName(String name) {
        this.name = name;
    }

    public boolean getOnCollision() {
        return onCollision;
    }

    public void setOnCollision(boolean b) {
        onCollision = b;
    }

    public float getX() {
        return (float) pos.getX();
    }

    public void setX(float x) {
        this.pos.setLocation(x, pos.getY());
    }

    public void setY(float y) {
        this.pos.setLocation(pos.getX(), y);
    }

    public float getY() {
        return (float) pos.getY();
    }

    //Vérifie si le point est dans l'écran si non le modifie pour qu'il y soit
    public void onScreenVerification(Point2D.Float p) {
        if (p.getX() < 0)
            p.setLocation(width - 1, p.getY());
        else if (p.getX() >= width)
            p.setLocation(0, p.getY());
        else if (p.getY() < 0)
            p.setLocation(p.getX(), height - 1);
        else if (p.getY() >= height)
            p.setLocation(p.getX(), 0);
    }

    // Nouvelle direction aléatoire
    public void newDirection(Point2D.Float p) {
        Random r = new Random();
        int theta = r.nextInt(359);
        p.setLocation(Math.cos(theta), Math.sin(theta));
    }
    public Rectangle getBounds() {
        return new Rectangle((int) pos.getX(), (int) (pos.getY()), widthImage, heigthImage);
    }

}

