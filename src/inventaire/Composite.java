package inventaire;

import factoryPersonnage.Personnage;

import java.util.ArrayList;

class Composite implements Composant {

  private ArrayList<Composant> enfants = new ArrayList<Composant>();
  private String nomComposite;

  public Composite(String nomComposite) {
    this.nomComposite = nomComposite;
  }

  @Override
  public void afficherInventaire() {
    if(!nomComposite.equals("Inventaire"))
      System.out.println("\n" + nomComposite);

    for(Composant composant : enfants){

      composant.afficherInventaire();

      if(!nomComposite.equals("Inventaire"))
        System.out.print(" |");
    }
  }

  public void UtiliserObjet(Personnage perso) {}

  public void addComposant(Composant c) {
    enfants.add(c);
  }

  public void rmComposant(Composant c) {
    enfants.remove(c);
  }

  public ArrayList<Composant> getEnfants() {
    return enfants;
  }

  public int getEnfantsSize() {
    return enfants.size();
  }
}
