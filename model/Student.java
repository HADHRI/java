package model;

import controller.GameManager;
import model.GameObject.acteur;

import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

public class Student extends Person implements Comparable<Student> {

   // public static GameManager gameManager;
    private int capacity;
    private int ects;
    private ArrayList history = new ArrayList();
    private int lifeCounter=0;
    private static final int lifeMax=20000;

    //Temporaire pour savoir la taille de l image , apres ça sera un attribut Image dans l etudiant
    ImageIcon ic = new ImageIcon("src/views/e2.png");

  /* // code temporaire heigth et width de la fenetre
    Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    int height = (int) dimension.getHeight();
    int width = (int) dimension.getWidth();
    //*/



    public int getEcts(){
        return ects;
    }
    public int getCapacity(){
        return capacity;
    }

    public Student(acteur typeActeur, String name, float x, float y) {
    	super(typeActeur.STUDENT, name);
    	capacity = 10;
        pos = new Point2D.Float(x, y);
        speed = new Point2D.Float();
        posInter= (Point2D.Float) pos.clone();
        /** Temporaire
        widthImage = ic.getIconWidth();
        heigthImage = ic.getIconHeight();
         **/
        isAlive=true;
    }

    //methode pour update PosInter


    //Ajout d un autre constructeur
    public Student(acteur typeActeur, String name)
    {
        super(typeActeur.STUDENT, name);
        capacity = 10;
        speed = new Point2D.Float();
        pos=new Point2D.Float();
        posInter= (Point2D.Float) pos.clone();
        widthImage = ic.getIconWidth();
        heigthImage = ic.getIconHeight();
        isAlive=true;

    }

    public void setCapacity(int capacity) {
        if (capacity <=100 && capacity >= 0)
            this.capacity = capacity;
        else if( capacity >100)
            this.capacity = 100;
        else
            this.capacity = 0;
    }

    public boolean checkHistory(UV uv){
        boolean verif=false;
        for (int i = 0 ; i < history.size() ; i++){
            if (history.get(i) == uv.getNameUv()){
                verif=true;
            }
        }
        return verif;
    }

    //Methode qui sert à savoir si on peut virer l etudiant du screen
    public void testAlive()
    {
        lifeCounter++;
        if((lifeCounter>=lifeMax) &&(!getOnCollision())) // On donne la chance à terminer sa colission afin de le virer !
        {
            isAlive=false;
        }
    }

    // interaction lors de la rencontre avec une uv
    public void meet(UV uv){
        Random r = new Random();
        if (probability(capacity, uv.getDifficulty()) > r.nextInt(100)){
            ects+=uv.getEcts();
            //TODO TRUE IL A EU L UV TU RAJOUTE LE ELSE
            history.add(uv.getNameUv());
        }

    }

    public boolean getDrinktogether(){
        return drinkTogether;
    }

    // interaction lors de la rencontre avec un Student
    public void meet(Student s){
        Random r = new Random();
        if (probability(capacity, s.capacity) > r.nextInt(100)){
            // Etudie ensemble et leur augmntation de capacity dépend de la capacité de l'autre Student
            setCapacity(capacity+s.capacity/10);
            s.setCapacity(s.capacity+capacity/10);
            System.out.println(capacity);

        }
        else {
            drinkTogether = true;
            s.drinkTogether=true;
        }
        //System.out.println(id + ". " + capacity + " " + s.id + ". " + s.capacity);
    }

    // interaction lors de la rencontre d'un Teacher
    public void meet(Teacher t){
        Random r = new Random();
        if (probability(t.getTeachingLevel(), capacity) > r.nextInt()){
            setCapacity(capacity+t.getTeachingLevel()/10);
        }
        System.out.println(id + ". " + capacity + " " + t.id + ". " + t.getTeachingLevel());
    }

    // loi de probabilité maison
    private float probability(int d, int e) {
        final float a = 1f / 225f, b = 1f / 15f;
        final int delta = d - e;
        float res;

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
        return (res*100);
    }



    @Override
    public int compareTo(Student o) {
        return o.capacity-capacity;
    }
}





