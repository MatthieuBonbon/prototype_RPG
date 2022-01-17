package factoryPersonnage;

import main.IHM;

class Sorcier extends Personnage {
    public Sorcier(String nom, IHM ihm) {
        this(nom, 80, 3.0, 1.0, ihm);
    }

    private Sorcier(String nom, int pv, double force, double resistance, IHM ihm) {
        super(nom, pv, force, resistance, ihm);
    }
}
