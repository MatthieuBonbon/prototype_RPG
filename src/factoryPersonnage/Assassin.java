package factoryPersonnage;

import main.IHM;

class Assassin extends Personnage {
    public Assassin(String nom, IHM ihm) {
        this(nom, 100, 2.0, 2.0, ihm);
    }

    private Assassin(String nom, int pv, double force, double resistance, IHM ihm) {
        super(nom, pv, force, resistance, ihm);
    }
}
