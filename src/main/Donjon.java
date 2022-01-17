package main;

import abstractFactoryObjets.*;
import java.util.ArrayList;
import java.util.Random;

import factoryPNJ.PNJ;
import factoryPNJ.FabriquePNJ;
import factoryPNJ.TypePNJ;
import factoryPersonnage.Personnage;
import gestionCombat.Combat;

class Donjon {
  private FabriquePNJ fabriquePNJ;
  private Combat combat;
  private Personnage personnage;
  private IHM ihm;
  private ArrayList<ArrayList<PNJ>> pieces;
  private Random random = new Random();

  public Donjon(Personnage personnage, IHM ihm){
    this.fabriquePNJ = new TypePNJ();
    this.personnage = personnage;
    this.ihm = ihm;
  }



  public boolean creerDonjon(int lvl){ // lvl -> nombre de pièces du donjon

    if(lvl<2){
      lvl = random.nextInt(9)+2;
    }

    this.pieces = new ArrayList<>(lvl);
    for(int i = 0; i < lvl; i++){ // on crée les pièces
      pieces.add(new ArrayList<>());
    }

    for(int i = 0; i < lvl; i++){ // on remplie les pièces de monstres
      // pour chaque pièce
      for(int j = 0; j < 2*(i+1); j++){
        pieces.get(i).add(PNJgenerator());
      }
    }

    // on ajoute un boss à la dernière pièce
    pieces.get(pieces.size()-1).add(fabriquePNJ.CreerPNJ(TypePNJ.TYPE.BOSS));



    // pour chaque pièce
    while (pieces.size()>0){ // tant que toutes les pièces n'ont pas été vidées de leurs PNJ

      String choixFinDeSalle;

      combat = new Combat(pieces.get(0), personnage);
      int res = combat.GestionCombat();
      System.out.println("resultat de fin de combat : " + res);
      if(res==0){ // si le personnage perd
        System.out.println("Vous avez perdu le combat");
        break;
      }
      else if(res==1) { // si le personnage gagne
        System.out.println("Vous avez gagné le combat");
        // ouvrir menu -> quitter donjon, passer piece suivante, check inventaire
        choixFinDeSalle = personnage.choixFinDeSalle();
        if(choixFinDeSalle.equals("Q"))
          return false;
      }

      pieces.remove(0); // on supprime la pièce qui a été vidée de ses PNJ
    }

    if (pieces.size()==0){ // si le donjon a été vidé de tout ses PNJ dont le Boss
      // on donne du matériel au personnage

      int typeFabriqueObjet  = random.nextInt(2);

      FabriqueAbstraiteObjet fabrique;
      if(typeFabriqueObjet==0){
        fabrique = FabriqueAbstraiteObjet.chooseFactory("Feu");
      }
      else {
        fabrique = FabriqueAbstraiteObjet.chooseFactory("Glace");
      }

      ArmeAbstraite arme = fabrique.creerArme();
      ArmureAbstraite armure = fabrique.creerArmure();
      ChaussureAbstraite chaussures = fabrique.creerChaussure();
      PotionAbstraite potion = fabrique.creerPotion();

      if(typeFabriqueObjet==0){
        personnage.getInventaire().ajouterArmeDansInventaire(arme, "Feu");
        personnage.getInventaire().ajouterArmureDansInventaire(armure, "Feu");
        personnage.getInventaire().ajouterChaussuresDansInventaire(chaussures, "Feu");
        personnage.getInventaire().ajouterPotionDansInventaire(potion, "Feu");
      }
      else {
        personnage.getInventaire().ajouterArmeDansInventaire(arme, "Glace");
        personnage.getInventaire().ajouterArmureDansInventaire(armure, "Glace");
        personnage.getInventaire().ajouterChaussuresDansInventaire(chaussures, "Glace");
        personnage.getInventaire().ajouterPotionDansInventaire(potion, "Glace");
      }

    }


    else {
      // si le personnage est mort
      personnage.mort();
      return false;
    }

    return true;
  }



  private PNJ PNJgenerator(){
    if(random.nextInt(2)==1){ // si c'est 1 -> zombie
      return fabriquePNJ.CreerPNJ(TypePNJ.TYPE.ZOMBIE);
    }
    else { // si c'est 0 -> lapin
      return fabriquePNJ.CreerPNJ(TypePNJ.TYPE.LAPIN);
    }
  }

}
