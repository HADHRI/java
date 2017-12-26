package model;

import controller.GameManager;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

public class GameObject {
    protected int id = nb; // identifiant de chaque objet
    private static int nb=0; // compte le nombre de chaque objet
    protected String name;
    protected Point2D.Float pos; // Toujours initialiser pos
    protected boolean onCollision = false; //savoir si l etudiant est en collission ou non
    public static GameManager gameManager; // c est utile??
    public enum acteur{STUDENT,TEACHER,UV};
    protected acteur typeActeur;

    protected Point2D.Float speed; // Toujours initialiser speed
    protected Point2D.Float posInter=new Point2D.Float();

    /** ADDING FROM PERSON **/
    protected int countLimit = 150;
    protected int count = 0; //conteur pour la variable onCollission


    // code temporaire heigth et width de la fenetre
    Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    int height = (int) dimension.getHeight();
    int width = (int) dimension.getWidth();
    //
    protected int widthImage;
    protected int heigthImage;
    protected boolean isAlive=true;

    
    public GameObject(acteur typeActeur, String name) {
		super();
		this.typeActeur = typeActeur;
		this.name = name;
        nb++;
	}

	public boolean getisAlive(){
        return isAlive;
    }

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

    
    public acteur getTypeActeur() {
		return typeActeur;
	}

	public void setTypeActeur(acteur typeActeur) {
		this.typeActeur = typeActeur;
	}

	public void testAlive(){ //Methode qui fait rien mais qui permet d eviter instance of pour l etudiant

    }

    //Vérifie si le point est dans l'écran si non le modifie pour qu'il y soit
    public void onScreenVerification(Point2D.Float p) {
        if (p.getX() < 0)
            p.setLocation(width -201, p.getY());
        else if (p.getX() >= width-200)
            p.setLocation(0, p.getY());
        else if (p.getY() < 0)
            p.setLocation(p.getX(), height - 1);
        else if (p.getY() >= height)
            p.setLocation(p.getX(), 0);
    }

    // Nouvelle direction aléatoire
    //oN VA LA DEPLACER DANS LA CLASSE PERSONNE
    public void newDirection(Point2D.Float p) {
        Random r = new Random();
        int theta = r.nextInt(359);
        p.setLocation(Math.cos(theta), Math.sin(theta));
    }
    public Rectangle getBounds() {
        return new Rectangle((int) pos.getX(), (int) (pos.getY()), widthImage, heigthImage);
    }

    // set une position aléatoire
    public void setPosition(){
        Random r = new Random();
        pos.setLocation(r.nextInt(width), r.nextInt(height));
    }

    public void AvoidThreeColision(GameObject gameObject)
    {
        Point2D.Float p = new Point2D.Float();
        p.setLocation(posInter.getX() - gameObject.posInter.getX() , posInter.getY()-gameObject.posInter.getY());
        float module = (float)Math.sqrt(p.getX()*p.getX() + p.getY()*p.getY());
        speed.setLocation(p.getX()/module,p.getY()/module);
        pos.setLocation(pos.getX() + speed.getX(),pos.getY()+speed.getY());

    }

    public void setPosInter(int x,int y)
    {
        posInter.setLocation(x,y);

    }

}

