package views;
import controller.GameManager;
import model.GameObject;
import model.Person;
import model.Student;
import model.Teacher;
import model.GameObject.acteur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;


//import com.sun.glass.events.MouseEvent;

public class GameView extends Display {

	private BufferedImage testPlayer;
	private JPanel cote; // le panel qui va contenir le classement et l interaction
	private JPanel classement;
	private JPanel gestionUser;
	private acteur obj;
	private JTextArea jtextArea;
	private JScrollPane jsp;


	//private JComboBox listStu = new JComboBox();

	JLabel labelEtudiant = new JLabel("Action sur un étudiant :", JLabel.LEFT);
	//private JTextField nameStudent = new JTextField("");

	JButton Ajouter = new JButton("Ajouter un étudiant ");
	JButton Modifier = new JButton("Modifier un étudiant");
	JButton Supprimer = new JButton("Supprimer un étudiant");
	JDialog name;

	//test etudiant
	private ArrayList<GameObject> gameObject;
	private ArrayList<Student>student;





	public GameView(String title, GameManager gameManager) {
		super(title);
		// TODO Auto-generated constructor stub
		this.gameObject = gameManager.getgameObject();
		this.student=gameManager.getsudent();
		Ajouter.setPreferredSize(new Dimension(150, 40));
		Modifier.setPreferredSize(new Dimension(150, 40));
		Supprimer.setPreferredSize(new Dimension(155, 40));
		principal.setLayout(new BorderLayout());
		principal.add(this, BorderLayout.CENTER);

		cote = new JPanel();
		classement = new JPanel();
		gestionUser = new JPanel();

		//Mettre en place les deux panel classement et gestionUser dans le panel cote
		cote.setLayout(new BorderLayout());
		cote.setBackground(Color.blue);
		classement.setBackground(Color.red);

		cote.add(classement, BorderLayout.CENTER);
		cote.add(gestionUser, BorderLayout.SOUTH);

		gestionUser.add(labelEtudiant);
		gestionUser.add(Ajouter);
		gestionUser.add(Modifier);
		gestionUser.add(Supprimer);

		///pour test



		cote.setPreferredSize(new Dimension(200, height));
		classement.setPreferredSize(new Dimension(height - 200, height - 200));
		gestionUser.setPreferredSize(new Dimension(200, 200));

		jtextArea=new JTextArea(height-200,height-200);
		jtextArea.setEditable(false);
		classement.add(jtextArea);
		jsp=new JScrollPane(jtextArea);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);



		classement.setLayout(new GridLayout(1,1));

		classement.add(jsp);



		/*cote.add(labelEtudiant);
		cote.add(Ajouter);
		cote.add(Modifier);
		cote.add(Supprimer);*/
		//cote.add(listStu);
		//cote.add(nameStudent);
		//nameStudent.setSize(140, 30);
		labelEtudiant.setForeground(Color.BLACK);

		Ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//récuperer le nom de l'etudiant
				String name = JOptionPane.showInputDialog(frame, "Quel est le nom de l'étudiant ?");
				// On ajoute un étudiant si il on à pas dépasser la limite

				if (student.size() < 30) {//TODO Mettre un nombre max fix au lieu de 30
					gameManager.addStudent(name);
					
				}
			}
		});

		Modifier.addActionListener(new ActionListener() {
			int count = 0;

			public void actionPerformed(ActionEvent e) {
				//TODO action du bouton modifier
				count++;
				if (count % 2 == 0) {
					cote.setBackground(Color.red);
				} else {
					cote.setBackground(Color.green);
				}
			}
		});

		Supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean findStu = false;
				do {
					String name = JOptionPane.showInputDialog(frame, "Quel est le nom de l'étudiant ?");
					for (int i = 0; i < gameObject.size(); i++) {
						if (gameObject.get(i).getName() == name) {
							findStu = true;
							try {
								gameManager.deletStudent((Student) gameObject.get(i));
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

					}

				} while (!findStu);
          	/*
			//TODO action du bouton supprimer
			  addMouseListener(new MouseAdapter() {
		            public void mouseClicked(Student e) {

		            }
		        });*/
			}
		});

		principal.add(cote, BorderLayout.EAST);
		// c est ce que j ai ajoutÃ© pour avoir les dimensions corectes de mon panel cote
		frame.setContentPane(principal);
		//frame.setVisible(true);
	}

	ImageIcon icone = new ImageIcon("src/views/e2.png");
	ImageIcon icone1 = new ImageIcon("src/views/prof.png");
	ImageIcon icone2 = new ImageIcon("src/views/livre.png");
	Image im = icone.getImage();
	Image im1 = icone1.getImage();
	Image im2 = icone2.getImage();

	ImageIcon back = new ImageIcon("views/map.jpg");
	Image background = back.getImage();

	private void afficheClassement(){
		jtextArea.setText("");

		for(int i=0;i<student.size();i++)
		{
			jtextArea.append(student.get(i).getName()+"      "+(student.get(i)).getCapacity()+"\n");
		}
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		afficheClassement();

		g.drawImage(background, 0, 0, width - 200, height, null); // Pour dessiner l image  , sauf que il faut le size du
		for (int i = 0; i < gameObject.size(); i++) {
			if (gameObject.get(i).getisAlive()) {
				if (((gameObject.get(i).getTypeActeur() == obj.STUDENT) && gameObject.get(i).getOnCollision()) && (((Student) gameObject.get(i)).getDrinktogether()))
					{

					}
					else if ((gameObject.get(i).getTypeActeur() == obj.STUDENT)  &&(((Student) gameObject.get(i)).getDrinktogether()==false))
					{
						//TODO METTRE L IMAGE NORMAL
						g.drawImage(im, Math.round(gameObject.get(i).getX()), Math.round(gameObject.get(i).getY()), null);
					}

				 else if (gameObject.get(i).getTypeActeur() == obj.TEACHER) {
					g.drawImage(im1, Math.round(gameObject.get(i).getX()), Math.round(gameObject.get(i).getY()), null);
				}
				else if(gameObject.get(i).getTypeActeur()==obj.UV){
					g.drawImage(im2, Math.round(gameObject.get(i).getX()), Math.round(gameObject.get(i).getY()), null);
			        }
			}
		}
	}



	}



