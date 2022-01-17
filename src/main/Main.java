package main;

import abstractFactoryObjets.*;
import factoryPersonnage.FabriquePersonnage;
import factoryPersonnage.Personnage;
import factoryPersonnage.TypePersonnage;
import gestionCombat.Combat;


public class Main {

  public static void main(String[] args){

    boolean nouveauDonjon = true;

    int nbDonjonFini = 0;

    IHM ihm = new IHM();

    // initialisation du personnage

    String[] dataPersonnage = ihm.choisirPersonnage();

    FabriquePersonnage fabriquePersonnage = new TypePersonnage();
    Personnage personnage;


    if(dataPersonnage[1].equals("Assassin")){
      personnage = fabriquePersonnage.CreerPersonnage(dataPersonnage[0], TypePersonnage.TYPE.ASSASSIN, ihm);
    }
    else if(dataPersonnage[1].equals("Barbare")){
      personnage = fabriquePersonnage.CreerPersonnage(dataPersonnage[0], TypePersonnage.TYPE.BARBARE, ihm);
    }
    else{
      personnage = fabriquePersonnage.CreerPersonnage(dataPersonnage[0], TypePersonnage.TYPE.SORCIER, ihm);
    }

    personnage.choixInterfaceJeu();


    // Inventaire de base du personnage

    FabriqueAbstraiteObjet fabrique = FabriqueAbstraiteObjet.chooseFactory("Feu");
    ArmureAbstraite armure = fabrique.creerArmure();

    PotionAbstraite potion = fabrique.creerPotion();

    fabrique = FabriqueAbstraiteObjet.chooseFactory("Glace");

    ArmureAbstraite armure1 = fabrique.creerArmure();
    ArmureAbstraite armure2 = fabrique.creerArmure();
    ArmeAbstraite arme = fabrique.creerArme();
    ChaussureAbstraite chaussures = fabrique.creerChaussure();
    ChaussureAbstraite chaussures1 = fabrique.creerChaussure();


    personnage.getInventaire().ajouterChaussuresDansInventaire(chaussures,"Glace");
    personnage.getInventaire().ajouterChaussuresDansInventaire(chaussures1,"Glace");
    personnage.getInventaire().ajouterArmeDansInventaire(arme,"Glace");
    personnage.getInventaire().ajouterArmureDansInventaire(armure1,"Glace");
    personnage.getInventaire().ajouterArmureDansInventaire(armure2,"Glace");
    personnage.getInventaire().ajouterPotionDansInventaire(potion,"Feu");
    personnage.getInventaire().ajouterArmeDansInventaire(arme,"Feu");
    personnage.getInventaire().ajouterArmeDansInventaire(arme,"Feu");
    personnage.getInventaire().ajouterArmureDansInventaire(armure,"Feu");

    // Donjons


    Donjon donjon = new Donjon(personnage,ihm);


    while (nouveauDonjon){
      personnage.choixInterfaceJeu();

      if(nbDonjonFini==0)
        nouveauDonjon = donjon.creerDonjon(2);
      else
        nouveauDonjon = donjon.creerDonjon(0);

      if(nouveauDonjon == true) // si le joueur a fini un donjon
        nbDonjonFini++;

      if(nouveauDonjon == false){ // si le joueur ne souhaite pas refaire de nouvelle partie dans un donjon

        if(personnage.getPv()==1){ // si le joueur est mort
            System.out.println("Vous ne faisiez pas le poids !");
        }
        String choix = ihm.choixFinDeJeu();
        if(choix.equals("Q")) {// si le joueur décide de quitter le jeu
          System.out.println("Vous avez terminé " + nbDonjonFini + " donjons.");
          break;
        }
        else // si le joueur décide de rester dans le jeu
          nouveauDonjon=true;
      }

    }

  }
}
