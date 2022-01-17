package gestionCombat;

import factoryPNJ.PNJ;
import factoryPersonnage.Personnage;

import java.util.ArrayList;

public class Combat implements Evenement {

  private Contexte monContexte = new Contexte();
  private ArrayList<PNJ> piece;
  private Personnage personnage;


  // constructor
  public Combat(ArrayList<PNJ> piece, Personnage personnage) {
    this.piece = piece;
    this.personnage = personnage;
    Etat etat = new AttenteCombatCommence();
    etat.CombatCommence(monContexte);
  }


  public int GestionCombat(){

    if(monContexte.getEtatCourant().getClass()==AttenteCombatCommence.class){
      CommencerCombat();
      return GestionCombat();
    }
    else if(monContexte.getEtatCourant().getClass()==AttentePersonnageAttaque.class){
      AttaquePersonnage();
      return GestionCombat();
    }
    else if(monContexte.getEtatCourant().getClass()==AttenteEnnemisAttaque.class){
      AttaqueEnnemis();
      return GestionCombat();
    }
    else if(monContexte.getEtatCourant().getClass()==AttenteCombatTermine.class){
      TerminerCombat();
      return 1;
    }
    else{ // si c'est du type PersonnagePerd
      return 0;
    }

  }



  private void CommencerCombat() {
    CombatCommence();
  }

  private void AttaquePersonnage() {
    PersonnageAttaque();
  }

  private void AttaqueEnnemis() {
    EnnemisAttaque();
  }

  private void TerminerCombat() {
    CombatTermine();
  }



  private void afficherPV(){
    System.out.println("\n******** POINTS DE VIE ********");

    System.out.println("Vos points de vie : " + personnage.getPv());

    System.out.println("Points de vie des ennemis : ");

    for (int i = 0; i < piece.size(); i++)
      System.out.println("Ennemi : " + piece.get(i).toString() + " | PV : " + piece.get(i).getPv() );

    System.out.println("\n*******************************\n");

  }


  @Override
  public void CombatCommence() {

    System.out.println("ENNEMIS PRESENTS DANS CETTE PIECE : " + piece);

    Etat etat = new AttentePersonnageAttaque();
    etat.PersonnageAttaque(monContexte);

    System.out.println("mon contexte d'après combat commence : " + monContexte.getEtatCourant());

    afficherPV();

    GestionCombat();
  }



  @Override
  public void PersonnageAttaque() { // on décide que le personnage attaque le premier PNJ

    piece.get(0).subirDegats(personnage.attaquer()); // le héros attaque le pnj

    if(piece.get(0).getPv()<=0) // si le premier pnj est mort, on l'enlève des ennemis à combattre dans la pièce
      piece.remove(0);

    if (piece.size() == 0) {
      Etat etat = new AttenteCombatTermine();
      etat.CombatTermine(monContexte);
    }
    else {
      Etat etat = new AttenteEnnemisAttaque();
      etat.EnnemisAttaque(monContexte);
    }

    GestionCombat();
  }




  @Override
  public void EnnemisAttaque() {

    afficherPV();

    for(int i = 0; i < piece.size(); i++){ // tout les pnj attaquent le héros
      personnage.subirDegats(piece.get(i).Attaquer());
      if(personnage.getPv()<=0){
        Etat etat = new PersonnagePerd();
        etat.CombatTermine(monContexte);
        break;
      }
      afficherPV();

    }

    if(personnage.getPv()>0) {
      Etat etat = new AttentePersonnageAttaque();
      etat.PersonnageAttaque(monContexte);
    }

    GestionCombat();
  }



  @Override
  public void CombatTermine() {}
}
