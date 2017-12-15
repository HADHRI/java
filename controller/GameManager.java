package controller;
import model.*;
import views.GameView;

import java.util.ArrayList;
import java.util.Vector;

import static java.lang.Thread.sleep;

public class GameManager implements Runnable {
    private GameView gameView;
    private boolean running=false;
    private Thread thread;


    private ArrayList<GameObject>gameObject=new ArrayList<GameObject>();

   private void  setPosition()
    {
        for(int i=0;i<gameObject.size();i++)
        {
            // désolé monsieur
            if((!gameObject.get(i).getOnCollision()) && (gameObject.get(i) instanceof Person))
            {
                ((Person) gameObject.get(i)).setFuturePosition();
            }
        }
        /*for(int i=0;i<6;i++)
        {   if(!student[i].getOnCollision())
            student[i].setFuturePosition();  // je definit les futures coordonnes
        }*/

    }

    //Test Student
    public void init()
    {
        //Random
        for(int i=0;i<10;i++)
        {
            gameObject.add(new Teacher(100*i,200*i));

        }
        /*gameObject.add(new Teacher(60,60));
        gameObject.add(new Teacher(30,30));*/
        //gameObject.add(new Teacher(60,60));

        //Donner la reference de GameManager au Classe Student
        GameObject.gameManager=this;
        gameView=new GameView("GAME",gameObject);
    }

    public synchronized void start() {
        if(running)
            return;
       running=true;
        thread=new Thread(this);
        thread.start();
    }


    @Override
    public void run() {
        // TODO Auto-generated method stub

        //Preparing the game Loop
        init();
        int fps=120;
        double timePerTick=1000000000/fps;
        double delta=0;
        long now;
        long lastTime=System.nanoTime(); // le temps courant

       // running=false;
        while(running)
        {
            now=System.nanoTime();
            delta+=(now-lastTime)/timePerTick; //sert à dire quand tu appelles les 2 methode pour update et dessiner
            lastTime=now;
            if(delta>=1)
            {
               // j appelle la methode qui gére les collissions
                try {
                    detectCollission();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                for(int i=0;i<gameObject.size();i++)
               {
                   gameObject.get(i).update();
               }
                gameView.repaint();
                delta--;

            }
            try {
                sleep(8,3333);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }


            }
        }
    public synchronized void  stop()
    {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
private void detectCollission() throws InterruptedException {
     setPosition();
            for(int i=0;i<gameObject.size();i++) {
                //desole Mr :p
                if ((!gameObject.get(i).getOnCollision())&& (gameObject.get(i) instanceof Person)){
                    for (int j = 0; j <gameObject.size(); j++) {
                        if(gameObject.get(i)==gameObject.get(j))
                            continue;
                        if((gameObject.get(i).getBounds().intersects(gameObject.get(j).getBounds())) &&(!gameObject.get(j).getOnCollision()))
                        {
                            System.out.println("Colision detected");


                            if (gameObject.get(i) instanceof Student) {
                                gameObject.get(i).setOnCollision(true);
                                gameObject.get(j).setOnCollision(true);
                                if(gameObject.get(j) instanceof UV)
                                {
                                    //todo meetUV

                                }
                                else if(gameObject.get(j) instanceof Teacher)
                                {
                                    //TODO MEET TEATCHER
                                    ((Person) gameObject.get(i)).ChangeDirection((Person) gameObject.get(j));

                                }
                                else if(gameObject.get(j) instanceof Student) {
                                    //TODO MEET STUDENT


                                    ((Person) gameObject.get(i)).ChangeDirection((Person) gameObject.get(j));
                                }

                            }
                            else if(gameObject.get(i) instanceof Teacher)
                            {
                                //Avoid3Collission
                                ((Person) gameObject.get(i)).AvoidThreeColision((Person)gameObject.get(j));
                            }

                        }



                        else
                        if((gameObject.get(i).getBounds().intersects(gameObject.get(j).getBounds())) &&(gameObject.get(j).getOnCollision()))
                        {
                            //je caclule la différence entre les absices et les ordonées !
                            /** Nouvelle x est la diff entre l x d objet 3 eme et l objet rencontre , et la y est la différence
                              entre y de l objet et y de le 3 eme**/
                            ((Person) gameObject.get(i)).AvoidThreeColision((Person)gameObject.get(j));

                        }



                    }
                }
            }
   }
}
