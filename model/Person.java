package model;

import java.awt.*;
import java.awt.geom.Point2D;

public class Person extends GameObject{
    protected int nbTours = 300;
    private int countLimit = 150;
    private int count = 0; //conteur pour la variable onCollission
    private static final int nbrTourmax = 300;
    protected Point2D.Float speed; // Toujours initialiser pos
    protected Point2D.Float posInter=new Point2D.Float(); //TODO: changer pour l'initialiser à la construction

    public void setFuturePosition() {
        if (nbTours == nbrTourmax) {
            nbTours = 0;
            newDirection(speed);
        }
        // Position future
        posInter.setLocation(pos.getX() + speed.getX(), pos.getY() + speed.getY());
        onScreenVerification(posInter);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) posInter.getX(), (int) (posInter.getY()), widthImage, heigthImage);
    }
    // sert à changer le vecteur vitesse
    public void ChangeDirection(Person personne) {
        //nbTours=nbrTourmax;

        // 2 eme methode
        newDirection(speed);
        personne.speed.setLocation(-speed.getX(), -speed.getY());
    }

    //methode ajouté pour test
    public void KillDirection()
    {
        pos.setLocation(20,20);


    }
    public void update() {
        if (onCollision) {
            count++;
            System.out.println(count);
            if (count > countLimit) {
                onCollision = false;
                System.out.println("je suis pas collision");
                count = 0;
            }
        } else {
            // je recupere les futures positions et je les mets dans x,y
            pos.setLocation(posInter);
            // j incremente le nbr de tours
            nbTours++;
        }
    }

    public void AvoidThreeColision(Person person)
    {
        double x=posInter.getX()-person.posInter.getX();
        //double y=person.posInter.getY()-posInter.getY();
        double y=posInter.getY()-person.posInter.getY();
        double module=Math.sqrt(x*x+y*y);
        speed.setLocation(x/module,y/module);
        pos.setLocation(pos.getX() + speed.getX(),pos.getY()+speed.getY());

    }



}
