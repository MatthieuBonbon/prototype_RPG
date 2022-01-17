package factoryPersonnage;

import abstractFactoryObjets.ArmeAbstraite;
import abstractFactoryObjets.ArmureAbstraite;
import abstractFactoryObjets.ChaussureAbstraite;
import inventaire.Inventaire;
import main.IHM;

public class Personnage {
  private String nom;

  private int pv;

  private double force;

  private double resistance;

  private Inventaire inventaire = new Inventaire();

  private IHM ihm;

  private ArmeAbstraite armeEquipee = null;
  private String typeArmeEquipee = "";
  private ArmureAbstraite armureEquipee = null;
  private String typeArmureEquipee = "";
  private ChaussureAbstraite chaussuresEquipees = null;
  private String typeChaussuresEquipees = "";



  protected Personnage(String nom, int pv, double force, double resistance, IHM ihm){
    this.nom = nom;
    this.pv = pv;
    this.force = force;
    this.resistance = resistance;
    this.ihm = ihm;
  }

  public int attaquer(){
    if(armeEquipee!=null){
      double armeDamage = armeEquipee.attaquer();
      return (int) (armeDamage*force);
    }
    else // S'il n'a pas d'arme, il attaque aux poings et les poings font 10 de dégâts
      return 10;
  }

  public void subirDegats(int degatsBruts){
    double resist = 1.0/resistance;
    double degats = ((double) degatsBruts) * resist;

    this.pv=this.pv-(int)degats;
  }

  public void choixInterfaceJeu(){
    String choix = ihm.choixInterfaceJeu();
    if(choix.equals("I")){
      ouvrirInventaire();
    }
    else{
      System.out.println("Partons combattre !"); // mettre ici code lié à l'inventaire
    }
  }


  public String choixFinDeSalle(){
    String choix = ihm.choixFinDeSalle();
    if(choix.equals("I")){
      ouvrirInventaire();
    }
    else if(choix.equals("Q")){

    }
    else{
      System.out.println("Partons combattre !");
    }
    return choix;
  }


  public void mort(){
    System.out.println("Vous êtes mort !");
    pv = 1;
    inventaire.suppLastElement(); // quand le personnage meurt -> on supprime le dernier élément de chaque type d'objet dans son inventaire
  }


  private void ouvrirInventaire() {
    inventaire.afficherInventaire(this);
    String choixActionInventaire = ihm.choixActionInventaire();

    switch (choixActionInventaire) {
      case "1":
        consommerPotion();
        break;
      case "2":
        jeterObjet();
        break;
      case "3":
        equiperObjet();
        break;
      default:  // Si on quitte l'inventaire
        choixInterfaceJeu();
        break;
    }
  }



  private void consommerPotion(){
    // Consommer une potion
    /* càd si potion existe
     choisir potion
    utiliser potion
    supprimer potion
     */
    if(inventaire.getNbPotions()>0){ // s'il y a des potions dans l'inventaire

      inventaire.afficherPotions(); // on affiche les potions

      String typePotion;

      while (true){
        typePotion = ihm.choixPotionConsommer();
        boolean resInventaire = inventaire.consommerPotion(typePotion, this);
        if(resInventaire)
          break;
      }

      // On supprime la potion consommée
      inventaire.suppPotionDansInventaire(typePotion);
    }
    else { // s'il n'y a pas de potions dans l'inventaire
      ihm.objetInexistant();
    }

    ouvrirInventaire();
  }



  private void jeterObjet(){
    // Jeter un objet
    /*
    càd si objet existe
    choisir objet à suppr
    supprimer objet
     */

    String typeObjet = ihm.choixTypeObjetJeter();

    switch (typeObjet) {
      case "1":
        // jeter arme
        if (inventaire.getNbArmes()>0) {
          while (true) {
            String typeArme = ihm.choixObjetSupprimer("ARME");
            boolean resInventaire = inventaire.objetExiste("ARME", typeArme);
            if (resInventaire){
              inventaire.suppArmeDansInventaire(typeArme);
              break;
            }
            else
              ihm.objetInexistant();
          }
        }
        else
          ihm.objetInexistant();
        break;
      case "2":
        // jeter armure
        if(inventaire.getNbArmures()>0){
          while (true){
            String typeArmure = ihm.choixObjetSupprimer("ARMURE");
            boolean resInventaire = inventaire.objetExiste("ARMURE", typeArmure);
            if(resInventaire) {
              inventaire.suppArmureDansInventaire(typeArmure);
              break;
            }
            else
              ihm.objetInexistant();
          }
        }
        else
          ihm.objetInexistant();
        break;
      case "3":
        // jeter chaussures
        if(inventaire.getNbChaussures()>0){
          while (true){
            String typeChaussures = ihm.choixObjetSupprimer("CHAUSSURES");
            boolean resInventaire = inventaire.objetExiste("CHAUSSURES", typeChaussures);
            if(resInventaire){
              inventaire.suppChaussuresDansInventaire(typeChaussures);
              break;
            }
            else
              ihm.objetInexistant();
          }
        }
        else
          ihm.objetInexistant();
        break;
      case "4":
        // jeter potion
        if(inventaire.getNbPotions()>0){
          while (true){
            String typePotion = ihm.choixObjetSupprimer("POTION");
            boolean resInventaire = inventaire.objetExiste("POTION", typePotion);
            if(resInventaire){
              inventaire.suppPotionDansInventaire(typePotion);
              break;
            }
            else
              ihm.objetInexistant();
          }
        }
        else
          ihm.objetInexistant();
        break;
      default:  // Si on quitte l'interface de suppression d'objets de l'inventaire
        ouvrirInventaire();
        break;
    }
    ouvrirInventaire();
  }



  private void equiperObjet(){
    // S'équiper avec un objet
    /*
    càd si objet existe
    envoyer l'objet au personnage
    supprimer l'objet de l'inventaire
     */


    String typeEquipement = ihm.choixTypeObjetEquiper();
    switch (typeEquipement) {
      case "1":
        // equiper une arme
        if (inventaire.getNbArmes()>0) {
          while (true) {
            String typeArme = ihm.choixObjetEquiper("ARME");
            boolean resInventaire = inventaire.objetExiste("ARME", typeArme);
            if (resInventaire){

              if(armeEquipee!=null){
                // on met l'ancienne arme dans l'inventaire
                // (permet de libérer le slot d'arme du personnage)
                inventaire.ajouterArmeDansInventaire(armeEquipee,typeArmeEquipee.substring(0,1).toUpperCase()+typeArmeEquipee.substring(1));
              }

              // on equipe la nouvelle arme au personnage
              inventaire.equiperArme(typeArme, this);
              // on supprime la nouvelle arme de l'inventaire
              inventaire.suppArmeDansInventaire(typeArme);
              break;
            }
            else
              ihm.objetInexistant();
          }
        }
        break;
      case "2":
        // equiper une armure
        if (inventaire.getNbArmures()>0) {
          while (true) {
            String typeArmure = ihm.choixObjetEquiper("ARMURE");
            boolean resInventaire = inventaire.objetExiste("ARMURE", typeArmure);
            if (resInventaire){

              if(!typeArmure.toLowerCase().equals(typeArmureEquipee.toLowerCase())){ // Si l'objet à équiper est différent de celui déjà équipé

                if(armureEquipee!=null){
                  // on met l'ancienne armure dans l'inventaire
                  // (permet de libérer le slot d'armure du personnage)

                  // On divise la resistance/force du personnage par celle donnée par l'objet dans le but de supprimer l'amélioration offerte par ce dernier
                  armureEquipee.retirerArmure(this);

                  inventaire.ajouterArmureDansInventaire(armureEquipee,typeArmureEquipee.substring(0,1).toUpperCase()+typeArmureEquipee.substring(1));
                }

                // on equipe la nouvelle armure au personnage
                inventaire.equiperArmure(typeArmure, this);
                // on supprime la nouvelle armure de l'inventaire
                inventaire.suppArmureDansInventaire(typeArmure);
                break;
              }
              else{
                ihm.objetDejaEquipe();
                break;
              }
            }
            else
              ihm.objetInexistant();
          }
        }
        break;
      case "3":
        // equiper des chaussures
        if (inventaire.getNbChaussures()>0) {
          while (true) {
            String typeChaussures = ihm.choixObjetEquiper("CHAUSSURES");
            boolean resInventaire = inventaire.objetExiste("CHAUSSURES", typeChaussures);
            if (resInventaire){

              if(!typeChaussures.toLowerCase().equals(typeChaussuresEquipees.toLowerCase())){
                if(chaussuresEquipees!=null){
                  // on met les anciennes chaussures dans l'inventaire
                  // (permet de libérer le slot de chaussures du personnage)

                  // On divise la resistance/force du personnage par celle donnée par l'objet dans le but de supprimer l'amélioration offerte par ce dernier
                  chaussuresEquipees.retirerChaussures(this);

                  inventaire.ajouterChaussuresDansInventaire(chaussuresEquipees,typeChaussuresEquipees.substring(0,1).toUpperCase()+typeChaussuresEquipees.substring(1));
                }

                inventaire.equiperChaussures(typeChaussures, this);
                inventaire.suppChaussuresDansInventaire(typeChaussures);
                break;
              }
              else {
                ihm.objetDejaEquipe();
                break;
              }
            }
            else
              ihm.objetInexistant();
          }
        }
        break;
      default: // Si on quitte l'interface d'équipement de l'inventaire.
        ouvrirInventaire();
        break;
    }
    ouvrirInventaire();
  }





  // Getter and Setter

  public String getNom() {
    return nom;
  }

  public int getPv() {
    return pv;
  }

  public void setPv(int pv) {
    this.pv = pv;
  }

  public double getForce() {
    return force;
  }

  public void setForce(double force) {
    this.force = force;
  }

  public double getResistance() {
    return resistance;
  }

  public void setResistance(double resistance) {
    this.resistance = resistance;
  }

  public Inventaire getInventaire() {
    return inventaire;
  }

  public void setArmeEquipee(ArmeAbstraite armeEquipee,String type) {
    this.typeArmeEquipee = type;
    this.armeEquipee = armeEquipee;
  }

  public void setArmureEquipee(ArmureAbstraite armureEquipee, String type) {
    armureEquipee.equiperArmure(this);
    this.armureEquipee = armureEquipee;
    this.typeArmureEquipee = type;
  }

  public void setChaussuresEquipees(ChaussureAbstraite chaussuresEquipees, String type) {
    chaussuresEquipees.equiperChaussures(this);
    this.chaussuresEquipees = chaussuresEquipees;
    this.typeChaussuresEquipees = type;
  }

  public ArmeAbstraite getArmeEquipee() {
    return armeEquipee;
  }

  public String getTypeArmeEquipee() {
    return typeArmeEquipee;
  }

  public ArmureAbstraite getArmureEquipee() {
    return armureEquipee;
  }

  public String getTypeArmureEquipee() {
    return typeArmureEquipee;
  }

  public ChaussureAbstraite getChaussuresEquipees() {
    return chaussuresEquipees;
  }

  public String getTypeChaussuresEquipees() {
    return typeChaussuresEquipees;
  }
}
