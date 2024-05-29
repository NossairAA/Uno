package Uno;

import java.util.ArrayList;
import java.util.Scanner;

public class Joueur  {
private int score;
private String nom;
private int nbMancheGagn�;//nb de manches gang�
private CarteUno carteJou�e;
private ArrayList<CarteUno> saMain = new ArrayList<>();
private boolean carteValide;//vrai si le joueur � jou� une carte valide

public Joueur() {
	Scanner s = new Scanner(System.in);
	System.out.println("ENTREZ LE NOM DU JOUEUR :");
 	this.nom = s.next().toUpperCase();
 	carteJou�e=null;
 	score=0;
 	nbMancheGagn�=0;
 	}
//getters
public String getNom() {
	return this.nom; 
}

public int getScore() {
	return this.score;
}

public ArrayList<CarteUno> getSaMain(){
	return saMain;
}

public CarteUno getCarteJou�e() {
	return this.carteJou�e;
}

public int getnbMancheGagn�() {
	return this.nbMancheGagn�;
}

public boolean getCarteValide() {
	return this.carteValide;
}
//setters
public void setCarteJou�e(CarteUno x) {
	this.carteJou�e=x;
}

public void setnbMancheGagn�(int x) {
	this.nbMancheGagn�=x;
}

public void setCarteValide(boolean x) {
	this.carteValide=x;
}
//


public void voirlescartes() {
	System.out.println("\n> les cartes de "+this.nom+" :");
	for(int i=0;i<saMain.size();i++)
	saMain.get(i).afficheCarte();
}

public void piocher() {
    int cartePioch�e = (int)(Math.random() * Manche.pioche.size());
    saMain.add(Manche.pioche.get(cartePioch�e));
    Manche.pioche.remove(cartePioch�e);
    carteJou�e=null;
}

public void joueCarte(int icarteChoisi) {
	Scanner s = new Scanner(System.in);
		if(icarteChoisi>=saMain.size()) {
			System.out.println("\n>ERREUR ! Vous n'avez que "+saMain.size()+" cartes.");
			carteValide= false;
		}
		
		else if((saMain.get(icarteChoisi).getvaleur()==Evaleur.JOKER)||(saMain.get(icarteChoisi).getvaleur()==Evaleur.PLUS4)) {
			Manche.talon.add(saMain.get(icarteChoisi));
			carteJou�e=saMain.get(icarteChoisi);
			saMain.remove(icarteChoisi);
			do {
			System.out.println("\n> Quelle couleur attendue ?");
			String colChoisi = s.next();
				
			 if ((colChoisi.equalsIgnoreCase("BLEU"))||(colChoisi.equalsIgnoreCase("ROUGE"))||(colChoisi.equalsIgnoreCase("JAUNE"))||(colChoisi.equalsIgnoreCase("VERT"))){	
					Manche.talon.get(Manche.talon.size()-1).setcouleur(Ecouleur.valueOf(colChoisi.toUpperCase()));					
					carteValide=true;
					System.out.print("\n- "+nom+" joue un changement de couleur en "+Manche.talon.get(Manche.talon.size()-1).getcouleur());
				}  
			 
			 else {
					System.out.println("\n>ERREUR ! Vous ne pouvez pas choisir ce couleur !, essayer un autre couleur.");
					carteValide=false;

				}
				  
				
			} while(carteValide==false);
		}
		
		else if ((saMain.get(icarteChoisi).getvaleur()==Evaleur.PLUS2)&&(saMain.get(icarteChoisi).getcouleur()!=Manche.talon.get(Manche.talon.size()-1).getcouleur())) {
			System.out.println("\n>ERREUR ! Votre carte � un couleur diff�rent, si vous n'avez pas la bonne carte piocher en utilisant /p !");
			carteValide= false;
		}	
		
		else if ((saMain.get(icarteChoisi).getvaleur()==Manche.talon.get(Manche.talon.size()-1).getvaleur())||(saMain.get(icarteChoisi).getcouleur()==Manche.talon.get(Manche.talon.size()-1).getcouleur())) {
			Manche.talon.add(saMain.get(icarteChoisi));
			carteJou�e=saMain.get(icarteChoisi);
			saMain.remove(icarteChoisi);
			carteValide=true;
			System.out.print("\n- "+nom+" joue un ");
			carteJou�e.afficheCarte();
		}
		
		else if  ((saMain.get(icarteChoisi).getvaleur()!=Manche.talon.get(Manche.talon.size()-1).getvaleur())&&(saMain.get(icarteChoisi).getcouleur()!=Manche.talon.get(Manche.talon.size()-1).getcouleur())){
			System.out.println("\n>ERREUR ! Ce n'est pas la bonne carte, si vous ne l'avez pas piocher en utilisant /p !");
			carteValide= false;
		}	
	System.out.print("\nLA CARTE VISIBLE DU TALON : ");
	Manche.talon.get(Manche.talon.size()-1).afficheCarte();

}

public void calScore() {
	for(int i=0;i<saMain.size();i++) {
		if(saMain.get(i).getcouleur()==Ecouleur.NOIR) 
			score+=50;
		else	
			switch(saMain.get(i).getvaleur()) {
				case N0: score+=0;
				break;
				case N1: score+=1;
				break;
				case N2: score+=2;
				break;
				case N3: score+=3;
				break;
				case N4: score+=4;
				break;
				case N5: score+=5;
				break;
				case N6: score+=6;
				break;
				case N7: score+=7;
				break;
				case N8: score+=8;
				break;
				case N9: score+=9;
				break;
				default: score+=20;
				break;
			}
	}
}





//
//fonction pour lire la commande

}
