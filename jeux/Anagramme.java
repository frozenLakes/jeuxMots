package com.application.jeux;

import com.application.core.Jeux;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Anagramme extends Jeux {

    public Anagramme() {
        setNbParam(2);
        setNomJeu("Anagramme");
        setDescriptionJeu("\n"
                + "Le but de ce jeu est d'écrire deux mots, si ceux-ci sont des Anagrammes, " +
                "vous remportez la partie."
                + "\n");
    }

    @Override
    protected boolean initJeu(ArrayList<String> mots) {

        // Vérifier la longueur pour éviter une exécution inutile du code suivant.
        if ( mots.get(0).length() != mots.get(1).length() ) {
            return false;
        }

        String mot1 = mots.get(0).toLowerCase();
        String mot2 = mots.get(1).toLowerCase();

        // Gérer les erreurs concernant les accents avec la lettre e
        mot1 = Normalizer.normalize(mot1, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "e");
        mot2 = Normalizer.normalize(mot2, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "e");

        // Séparer les lettres et les ranger dans un tableau
        String[] tableau1 = mot1.split("");
        String[] tableau2 = mot2.split("");

        // Ranger les mots dans l'ordre alphabétique
        Arrays.sort(tableau1);
        Arrays.sort(tableau2);

        // Comparer les deux tableaux contenant les lettres des mots rangés dans l'ordre alphabétique
        if (Arrays.equals(tableau1, tableau2)) {
            return true;
        } else {
            return false;
        }
    }
}
