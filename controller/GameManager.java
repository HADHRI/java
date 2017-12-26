package controller;

import model.*;
import model.GameObject.acteur;
import views.GameView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

import static java.lang.Thread.sleep;

public class GameManager implements Runnable {
    private GameView gameView;
    private boolean running = false;
    private Thread thread;
    private acteur obj;
    private UV.type nameUV;  //TODO CHANGE THIS TYPE !!!!
    private ArrayList<GameObject> gameObject = new ArrayList<GameObject>();
    private ArrayList<Student>student=new ArrayList<Student>();//utile pour le tri

    //gerer l init des etusiants
    // Rename addGameObject
    private void initStudent()
    {
        for(int i=0;i<1;i++)
            addStudent("toto");
    }

    private void initUV(){

        for(int i=0;i<30;i++){
            UV uv=createUV();
            //TODO LE CASE POUR METTRE LE TYPE D UV CORRESPONDANT
            uv.setTypeUV(nameUV.MT42);
            uv.setUvDifficulty(uv.getNameUv());
        }

    }

    private UV createUV(){
        Random r = new Random();
        int posx;
        int posy;
        UV uv=new UV(obj.UV,"to");
        gameObject.add(uv);
        do {
            posx=r.nextInt(gameView.getWidth()-200);
            posy=r.nextInt(gameView.getWidth()-200);
            uv.setX(posx);
            uv.setY(posy);
            uv.setPosInter(posx,posy); // Il faut mettre POSINTER CAR GETBOUNDS Renvoie le posInter qui n est pas initialise ici
        }while (!verifInit((gameObject.get(gameObject.size()-1)))); //VERIF INIT TO uv
        return uv;



       /*
        uv.setX(500);
        uv.setY(500);
        uv.setPosInter(500,500);
        gameObject.add(uv);

        UV uv1=new UV(obj.UV,"to",nameUV.MT45);
        uv1.setX(200);
        uv1.setY(200);
        uv1.setPosInter(200,200);
        gameObject.add(uv1);*/


       /* gameObject.add(new UV(obj.UV,"to",nameUV.LO43));
        gameObject.add(new UV(obj.UV,"to",nameUV.LE01));
        gameObject.add(new UV(obj.UV,"to",nameUV.LE02));
        gameObject.add(new UV(obj.UV,"to",nameUV.SP08));
        gameObject.add(new UV(obj.UV,"to",nameUV.LO44));*/

    }

    //
    private boolean verifInit(GameObject object)
    {
        boolean verif=true;
        for(int i=0;i<gameObject.size();i++)
        {
            if(gameObject.get(i)==object)
                continue;
            if(object.getBounds().intersects(gameObject.get(i).getBounds()))
                verif=false;
        }
        return  verif;
    }

    public void setGameView(GameView gameView) {
        this.gameView = gameView;

    }

    public GameManager() {
    }

    private void setPosition() {
        for (int i = 0; i < gameObject.size(); i++) {
            // désolé monsieur
            if ((!gameObject.get(i).getOnCollision()) && (gameObject.get(i).getTypeActeur() == obj.STUDENT || gameObject.get(i).getTypeActeur() == obj.TEACHER)) {
                ((Person) gameObject.get(i)).setFuturePosition();
            }
        }

    }

    //Test Student
    public void init() {
        gameView.getJFrame().setVisible(true);

       initStudent();
       initUV();
       GameObject.gameManager = this;
      SoundController s=new SoundController("/utilities/music.wav");
       s.playTempSound("/utilities/music.wav");

    }

    // initialise la position des GameObject en évitant que deux objets soit l'un sur l'autre
    //TODO ELLE FAIT QUOI DANS DETECT COLLISSION
    private void initialisePosition(GameObject o) {
        o.setPosition();
        if (gameObject.size() != 1) {
            for (int i = 0; i < gameObject.size(); i++) {
                if ((gameObject.get(i) != o) && (gameObject.get(i).getBounds().intersects(o.getBounds()))) {
                    initialisePosition(o);
                }
            }
        }
    }

    public ArrayList<GameObject> getgameObject() {
        return gameObject;
    }

    public ArrayList<Student> getsudent() {
        return student;
    }


    private void refreshStudents(){
        Collections.sort(student);

    }


    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        //Preparing the game Loop
        init();
        int fps = 100;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime(); // le temps courant

        // running=false;
        while (running) {


            for (int i = 0; i < gameObject.size(); i++) { // je teste si l etudiant il peut encore vivre
                gameObject.get(i).testAlive();
            }


            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick; //sert à dire quand tu appelles les 2 methode pour update et dessiner
            lastTime = now;
            if (delta >= 1) {
                // j appelle la methode qui gére les collissions
                try {
                    detectCollission();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                for (int i = 0; i < gameObject.size(); i++) {
                    if (gameObject.get(i).getisAlive()) {
                        gameObject.get(i).update();
                    }
                }

                //TODO TRI STUDENT

                refreshStudents();
                gameView.repaint();
                delta--;
                //TODO : mélanger le tableau de gameObject

            }
            try {
                sleep(8, 3333);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }


        }
    }

    public synchronized void stop() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void detectCollission() throws InterruptedException {
        setPosition();
        for (int i = 0; i < gameObject.size(); i++) {
            if ((!gameObject.get(i).getOnCollision()) && (gameObject.get(i).getTypeActeur() == obj.STUDENT || gameObject.get(i).getTypeActeur() == obj.TEACHER)) {
                for (int j = 0; j < gameObject.size(); j++) {
                    if (gameObject.get(i) == gameObject.get(j))
                        continue;
                    if ((gameObject.get(i).getBounds().intersects(gameObject.get(j).getBounds())) && (!gameObject.get(j).getOnCollision())) {
                        //System.out.println("Colision detected");


                        if (gameObject.get(i).getTypeActeur() == obj.STUDENT) {
                            gameObject.get(i).setOnCollision(true);
                            gameObject.get(j).setOnCollision(true);
                            if (gameObject.get(j).getTypeActeur() == obj.UV )
                            {
                                if(((Student) gameObject.get(i)).checkHistory((UV)gameObject.get(j))==false) {
                                ((Student) gameObject.get(i)).meet((UV) gameObject.get(j));

                            }
                            else
                                { /** il faut les mettre a false car l etudiant et l uv ne seront pas en collision dans le cas c la 2 eme fois qu il veut la meet**/
                                    gameObject.get(i).setOnCollision(false);
                                    gameObject.get(j).setOnCollision(false);
                                    System.out.println("je mange pas l uv 2 fois merde !!");

                                }
                                gameObject.get(i).AvoidThreeColision(gameObject.get(j));
                            }
                            else if (gameObject.get(j).getTypeActeur() == obj.TEACHER) {
                                ((Student) gameObject.get(i)).meet((Teacher) gameObject.get(j));

                                ((Person) gameObject.get(i)).ChangeDirection((Person) gameObject.get(j));

                            }
                            else if (gameObject.get(j).getTypeActeur() == obj.STUDENT) {
                                ((Student) gameObject.get(i)).meet((Student) gameObject.get(j));
                                ((Person) gameObject.get(i)).ChangeDirection((Person) gameObject.get(j));
                            }

                        }
                        else if (gameObject.get(i).getTypeActeur() == obj.TEACHER) {
                            //Avoid3Collission
                             gameObject.get(i).AvoidThreeColision(gameObject.get(j));
                        }

                    }
                    else if ((gameObject.get(i).getBounds().intersects(gameObject.get(j).getBounds())) && (gameObject.get(j).getOnCollision())) {
                        //je caclule la différence entre les absices et les ordonées !
                        /** Nouvelle x est la diff entre l x d objet 3 eme et l objet rencontre , et la y est la différence
                         entre y de l objet et y de le 3 eme**/
                         gameObject.get(i).AvoidThreeColision( gameObject.get(j));



                    }


                }
            }
        }
    }

    /** ADDING STUDENT**/

    public void addStudent(String name)  {
        Random r = new Random();
        int posx;
        int posy;
             Student s=new Student(obj.STUDENT,name);
            gameObject.add(s);
            student.add(s);
            do {
                posx=r.nextInt(gameView.getWidth()-200);
                posy=r.nextInt(gameView.getWidth()-200);
                s.setX(posx);
                s.setY(posy);
                s.setPosInter(posx,posy); // Il faut mettre POSINTER CAR GETBOUNDS Renvoie le posInter qui n est pas initialise ici
            }while (!verifInit((gameObject.get(gameObject.size()-1))));

    }

    /** ADDing UV **/
    public void addUV(String name)  {
        Random r = new Random();
        int posx;
        int posy;
      /*  Student s=new Student(obj.STUDENT,name);
        gameObject.add(s);
        student.add(s);
        do {
            posx=r.nextInt(800);
            posy=r.nextInt(800);
            s.setX(posx);
            s.setY(posy);
            s.setPosInter(posx,posy); // Il faut mettre POSINTER CAR GETBOUNDS Renvoie le posInter qui n est pas initialise ici
        }while (!verifInit((gameObject.get(gameObject.size()-1))));*/

    }





    public void deletStudent(Student stu) throws InterruptedException {

        detectCollission(); //TODO à modifer pour pas le supprimer pendant une collision
        for(int i=0;i<gameObject.size();i++) {
            if(gameObject.get(i)==stu) {
                gameObject.set(i, null);
            }
        }
    }


}
