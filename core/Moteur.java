package com.application.core;

import com.application.jeux.*;

import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

public class Moteur {

    ArrayList<Jeux> jeux = new ArrayList<>();
    Random rand = new Random();

    Anagramme anagramme = new Anagramme();
    Palindrome palindrome = new Palindrome();

    public void run() {
        boolean continuer = true;

        jeux.addAll(Arrays.asList(palindrome, anagramme));

        while (continuer) {
            Jeux jeu = jeux.get(rand.nextInt(jeux.size()));

            System.out.println("Bienvenue sur le jeu " + jeu.getNomJeu());
            System.out.println(jeu.getDescriptionJeu());
            jeu.run();
            System.out.println(jeu.getResultat());
            System.out.println("Victoires : " + jeu.getVictoires() + " - Defaites : " + jeu.getDefaites() + "\n");
            System.out.println("========================" + "\n");
        }
    }
}
