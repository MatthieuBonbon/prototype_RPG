package gestionCombat;

class AttenteCombatCommence implements Etat {
    @Override
    public void CombatCommence(Contexte c) {
        System.out.println("Le combat commence depuis notre super pattern de gestion de combat !"); // temporaire -> pour prouver que ça fonctionne
        c.setEtatCourant(this); // cela signifie que l'état courant du combat est "Attente Combat Commence" (notre classe)

        // ajouter ici les différentes commandes permettant le début du combat
    }

    @Override
    public void PersonnageAttaque(Contexte c) {
        // on laisse "vide" cette méthode car elle n'est pas utilisée
        // par cette classe implémentant l'interface Etat
    }

    @Override
    public void EnnemisAttaque(Contexte c) {
        // on laisse "vide" cette méthode car elle n'est pas utilisée
        // par cette classe implémentant l'interface Etat
    }

    @Override
    public void CombatTermine(Contexte c) {
        // on laisse "vide" cette méthode car elle n'est pas utilisée
        // par cette classe implémentant l'interface Etat
    }
}
