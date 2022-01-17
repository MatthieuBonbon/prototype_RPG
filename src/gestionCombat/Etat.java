package gestionCombat;

interface Etat {
  void CombatCommence(Contexte c) ;

  void PersonnageAttaque(Contexte c) ;

  void EnnemisAttaque(Contexte c) ;

  void CombatTermine(Contexte c) ;

}
