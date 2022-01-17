package gestionCombat;

class Contexte implements Evenement {
  private Etat etatCourant;

  public Contexte() {
    this.etatCourant = null;
  }

  public Etat getEtatCourant() {
    return etatCourant;
  }

  public void setEtatCourant(Etat etatCourant) {
    this.etatCourant = etatCourant;
  }

  @Override
  public void CombatCommence() {
    // on n'utilise pas ces méthodes dans le contexte
  }

  @Override
  public void PersonnageAttaque() {
    // on n'utilise pas ces méthodes dans le contexte
  }

  @Override
  public void EnnemisAttaque() {
    // on n'utilise pas ces méthodes dans le contexte
  }

  @Override
  public void CombatTermine() {
    // on n'utilise pas ces méthodes dans le contexte
  }
}
