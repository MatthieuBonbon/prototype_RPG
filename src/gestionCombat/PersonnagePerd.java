package gestionCombat;

class PersonnagePerd implements Etat {
    @Override
    public void CombatCommence(Contexte c) {

    }

    @Override
    public void PersonnageAttaque(Contexte c) {

    }

    @Override
    public void EnnemisAttaque(Contexte c) {

    }

    @Override
    public void CombatTermine(Contexte c) { // d'une certaine manière, le combat se termine si le personnage meurt
        c.setEtatCourant(this);
    }
}
