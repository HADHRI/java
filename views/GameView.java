package views;
import model.GameObject;
import model.Student;
import model.Teacher;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

public class GameView extends Display {

	private BufferedImage testPlayer;
	private JPanel cote; // le panel qui va contenir le classement

	//test etudiant
	private ArrayList<GameObject>gameObject;

	public GameView(String title, ArrayList<GameObject>gameObject) {
		super(title);
		// TODO Auto-generated constructor stub
		this.gameObject=gameObject;

		//setBackground(Color.WHITE);
		//frame.setContentPane(this);
		principal.setLayout(new BorderLayout());
		principal.add(this,BorderLayout.CENTER);
		cote=new JPanel();
		cote.setBackground(Color.RED);
		principal.add(cote,BorderLayout.EAST);
		// c est ce que j ai ajouté pour avoir les dimensions corectes de mon panel cote
		frame.setContentPane(principal);
		frame.setVisible(true);



	}
	ImageIcon icone=new ImageIcon("src/views/e2.png");
	ImageIcon icone1=new ImageIcon("src/views/prof.png");
	Image im=icone.getImage();
	Image im1=icone1.getImage();
	//Image im1=icone1.getImage();
	 public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 for (int i = 0; i <gameObject.size(); i++) {
			 if (gameObject.get(i) instanceof Student) {
				 g.drawImage(im, Math.round(gameObject.get(i).getX()), Math.round(gameObject.get(i).getY()), null);

			 }
			 else if(gameObject.get(i) instanceof Teacher)
			 {
				 g.drawImage(im1, Math.round(gameObject.get(i).getX()), Math.round(gameObject.get(i).getY()), null);
			 }
		 }
	 }





	  }
	
	
	

