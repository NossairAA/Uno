package Uno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		int Npartie=1; //num�ro de partie
		System.out.println("<<<---------- LANCEMANT DE PARTIE n�"+Npartie+" ---------->>>\n");
		Partie p = new Partie();
		while(!p.trouveGagnant()) {
		Npartie++;
		System.out.println("<<<---------- Cas d'�galit� : LANCEMANT D'UNE NOUVELLE PARTIE (partie n�"+Npartie+") ---------->>>\n");
		p = new Partie();
		} 
		System.out.println("<-------          "+p.gagnant.getNom()+" � gagn� la partie, F�licitations !!!-------          >");

		
		
		
		

	
        

 
	}

}



