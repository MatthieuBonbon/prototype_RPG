package gestionCombat;

class AttenteEnnemisAttaque implements Etat {
    @Override
    public void CombatCommence(Contexte c) {
        // on laisse "vide" cette méthode car elle n'est pas utilisée
        // par cette classe implémentant l'interface Etat
    }

    @Override
    public void PersonnageAttaque(Contexte c) {
        // on laisse "vide" cette méthode car elle n'est pas utilisée
        // par cette classe implémentant l'interface Etat
    }

    @Override
    public void EnnemisAttaque(Contexte c) {
        c.setEtatCourant(this);
    }

    @Override
    public void CombatTermine(Contexte c) {
        // on laisse "vide" cette méthode car elle n'est pas utilisée
        // par cette classe implémentant l'interface Etat
    }
}
