package com.application.core;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Jeux {

    protected int nbParam;
    protected int nbVictoires;
    protected int nbDefaites;
    protected String nomJeu;
    protected String descriptionJeu;
    protected String descriptionVictoire = "\n" + "C'est gagné." + "\n";
    protected String descriptionDefaite = "\n" + "C'est perdu." + "\n";
    protected String resultat;

    public void run() {
        int nbParam = getNbParam();
        ArrayList<String> mots = getParams(nbParam);
        boolean resultat = initJeu(mots);
        actualiserResultat(resultat);
    }

    public void setNomJeu(String nom) {
        this.nomJeu = nom;
    }

    public String getNomJeu() {
        return nomJeu;
    }

    public void setDescriptionJeu(String description) {
        this.descriptionJeu = description;
    }

    public String getDescriptionJeu() {
        return descriptionJeu;
    }

    protected void setNbParam(int nbParam) {
        this.nbParam = nbParam;
    }

    protected int getNbParam() {
        return nbParam;
    }

    protected ArrayList<String> getParams(int nbParam) {

        ArrayList<String> params = new ArrayList<>();

        for (int i = 0; nbParam > i; i++) {
            int nbMot = i + 1;
            Scanner sc = new Scanner(System.in,  "UTF-8");
            if (nbParam > 1) {
                System.out.println("Saisir mot n°" + nbMot + " : ");
            } else {
                System.out.println("Saisir mot : ");
            }
            String mot = sc.nextLine();
            params.add(i, mot);
        }

        return params;
    }

    protected abstract boolean initJeu(ArrayList<String> mots);

    protected void actualiserVictoires() {
        nbVictoires++;
    }

    protected void actualiserDefaites() {
        nbDefaites++;
    }

    protected int getVictoires() {
        return nbVictoires;
    }

    protected int getDefaites() {
        return nbDefaites;
    }

    protected void actualiserResultat(boolean resultat) {
        if(resultat) {
            actualiserVictoires();
            setResultat(descriptionVictoire);
        } else {
            actualiserDefaites();
            setResultat(descriptionDefaite);
        }
    }

    protected void setResultat(String resultat) {
        this.resultat = resultat;
    }

    protected String getResultat() {
        return resultat;
    }
}
