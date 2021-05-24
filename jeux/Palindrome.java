package com.application.jeux;

import com.application.core.Jeux;

import java.util.ArrayList;

public class Palindrome extends Jeux {

    public Palindrome() {
        setNbParam(1);
        setNomJeu("Palindrome");
        setDescriptionJeu("\n"
                + "Le but de ce jeu est d'écrire un mot, si celui-ci est un palindrome, vous remportez la partie."
                + "\n");
    }

    @Override
    protected boolean initJeu(ArrayList<String> mots) {

        String mot = mots.get(0).toLowerCase();

        // Mot inversé
        String mot2 = new StringBuilder(mot).reverse().toString();

        // Analysé le mot original et le mot inversé
        if (mot.equals(mot2)) {
            return true;
        } else {
            return false;
        }
    }
}
