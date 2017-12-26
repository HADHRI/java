package model;

import java.awt.*;
import java.awt.geom.Point2D;

public class Person extends GameObject{
    protected int nbTours = 300;

    /** je le met dans gameObject
    private int countLimit = 150;
    private int count = 0; //conteur pour la variable onCollission
     **/
    private static final int nbrTourmax = 300;
    protected boolean drinkTogether=false;

    /** j ai enlever ça Pour UV
    protected Point2D.Float speed; // Toujours initialiser speed
    protected Point2D.Float posInter=new Point2D.Float(); //TODO: changer pour l'initialiser à la construction
     **/

    //Ajout de setPosInter

    /** Remonter ça a GameObject**/
/*    public void setPosInter(int x,int y)
    {
        posInter.setLocation(x,y);

    }*/

    public Person(acteur typeActeur, String name) {
		super(typeActeur, name);
	}

	public void setFuturePosition() {
        if (nbTours == nbrTourmax) {
            nbTours = 0;
            newDirection(speed);     //Pourquoi tu passe speed en paramétre ????
        }
        // Position future
        posInter.setLocation(pos.getX() + speed.getX(), pos.getY() + speed.getY());
        onScreenVerification(posInter);
    }

    public Rectangle getBounds() {
       // System.out.println(posInter.getX()+posInter.getY());
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
            //System.out.println(count);
            if (count > countLimit) {
                onCollision = false;
                drinkTogether=false;
                //System.out.println("je suis pas collision");
                count = 0;
                //TODO SETDRINKTOGETHER A FALSE

            }
        } else {
            // je recupere les futures positions et je les mets dans x,y
            pos.setLocation(posInter);
            // j incremente le nbr de tours
            nbTours++;
        }
    }

    /** Remonter cette methode a GameObject**/

  /*  public void AvoidThreeColision(Person person)
    {
        Point2D.Float p = new Point2D.Float();
        p.setLocation(posInter.getX() - person.posInter.getX() , posInter.getY()-person.posInter.getY());
        float module = (float)Math.sqrt(p.getX()*p.getX() + p.getY()*p.getY());
        speed.setLocation(p.getX()/module,p.getY()/module);
        pos.setLocation(pos.getX() + speed.getX(),pos.getY()+speed.getY());

    }
    */

}
