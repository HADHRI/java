package model;

import javax.swing.*;
import model.GameObject.acteur;

import java.awt.geom.Point2D;

public class Teacher extends Person{
    private int teachingLevel;

    //Temporaire pour savoir la taille de l image , apres ça sera un attribut dans la view
    ImageIcon ic = new ImageIcon("src/views/e2.png");

    public Teacher(acteur typeActeur, String name, float x, float y) {
    	super(typeActeur.TEACHER, name);
    	teachingLevel = 12;
        pos = new Point2D.Float(x, y);
        speed = new Point2D.Float();
        posInter= (Point2D.Float) pos.clone();
        widthImage = ic.getIconWidth();
        heigthImage = ic.getIconHeight();
    }

    public int getTeachingLevel() {
        return teachingLevel;
    }
}
