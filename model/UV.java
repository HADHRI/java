package model;

import javax.swing.*;
import java.awt.geom.Point2D;

public class UV extends GameObject {
    private int difficulty;
    private int ects;
    public enum type{MT45,MT42,MI41,LO43,LO44,HT08,SP08,MR01,LE01,LE02,LE03,LG00};
    private type nameUv;

    /** Temporaire pour l image**/
	ImageIcon ic = new ImageIcon("src/views/livre.png");

    //Est ce qu'on peut utiliser name du GameObject à la place de nameUv
    public UV(acteur typeActeur, String name) {
		super(typeActeur.UV, name);
		/**temporaire**/
		widthImage = ic.getIconWidth();
		heigthImage = ic.getIconHeight();
		 //
		pos = new Point2D.Float();
		speed = new Point2D.Float();
		posInter= (Point2D.Float) pos.clone();


	}

	/**Temporaire**/
	public void setUvDifficulty(type nameUv){
		//TODO : diminuer à 6UV différente et répartir les 180 ects
		//TODO IL FAUT ASSOCIER CA DIRECTEMENT A L ENUM
		if(nameUv==type.MT45) {
			difficulty=25;
		}else if(nameUv==type.MT42) {
			difficulty=30;
		}else if(nameUv==type.MI41) {
			difficulty=50;
		}else if(nameUv==type.LO43) {
			difficulty=18;
		}else if(nameUv==type.LO44) {
			difficulty=14;
		}else if(nameUv==type.HT08) {
			difficulty=15;
		}else if(nameUv==type.SP08) {
			difficulty=7;
		}else if(nameUv==type.MR01) {
			difficulty=10;
		}else if(nameUv==type.LE01) {
			difficulty=8;
		}else if(nameUv==type.LE02) {
			difficulty=14;
		}else if(nameUv==type.LE03) {
			difficulty=21;
		}else if(nameUv==type.LG00) {
			difficulty=13;
		}


	}


	public type getNameUv() { //TODO CHANGE NAME TO GETTYPEUV NOT GETNAMEUV!!!
		return nameUv;
	}

	public void setTypeUV(type uv){
    	nameUv=uv;
	}

	public int getDifficulty() {
        return difficulty;
    }

	public int getEcts() {
		return ects;
	}

	public void update(){
		if (onCollision) {
			count++;
			//System.out.println(count);
			if (count > countLimit) {
				onCollision = false;

				//System.out.println("je suis pas collision");
				count = 0;
				//TODO SETDRINKTOGETHER A FALSE
			}
		}

	}




}
